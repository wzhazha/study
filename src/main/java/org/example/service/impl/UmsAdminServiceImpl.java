package org.example.service.impl;

import org.example.config.JwtTokenConfig;
import org.example.entity.vo.LoginUserVo;
import org.example.exception.Asserts;
import org.example.config.AESConfig;
import org.example.entity.bo.UmsAdminCreateBo;
import org.example.entity.database.UmsAdmin;
import org.example.exception.MyException;
import org.example.mapper.UmsAdminMapper;
import org.example.service.UmsAdminService;
import org.example.utils.AESUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Resource
    private UmsAdminMapper umsAdminMapper;
    @Resource
    private AESConfig aesConfig;
    @Resource
    private JwtTokenConfig jwtTokenConfig;

    @Override
    public UmsAdmin register(UmsAdminCreateBo createBo) throws Exception {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(createBo, umsAdmin);
        umsAdmin.setCreateTime(new Timestamp(System.currentTimeMillis()));
        umsAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        String username = umsAdmin.getUsername();
        int count = umsAdminMapper.countByUserName(username);
        if (count > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = AESUtil
                .encrypt(umsAdmin.getPassword(), aesConfig.getSecretKey());
        umsAdmin.setPassword(encodePassword);
        int insert = umsAdminMapper.insert(umsAdmin);
        if (insert < 0) {
            throw new MyException("Failed to add user");
        }
        return umsAdmin;
    }

    @Override
    public String login(String username, String password, HttpServletResponse response) throws Exception {
        UmsAdmin umsAdmin = umsAdminMapper.selectByUserName(username);
        if (umsAdmin == null) {
            Asserts.fail("用户名错误");
        }
        String encodePassword = umsAdmin.getPassword();
        String decryptPassword = AESUtil.decrypt(encodePassword, aesConfig.getSecretKey());
        if (!password.equals(decryptPassword)) {
            Asserts.fail("密码不正确");
        }
        if (umsAdmin.getStatus() != 1) {
            Asserts.fail("帐号已被禁用");
        }
        String token = jwtTokenConfig.generateToken(username);
        jwtTokenConfig.addTokenToRequest(response, token);
        return token;
    }

    @Override
    public Object state(HttpServletRequest request) {
        String tokenFromRequest = jwtTokenConfig.getTokenFromRequest(request);
        String usernameFromToken = jwtTokenConfig.getUsernameFromToken(tokenFromRequest);
        UmsAdmin umsAdmin = umsAdminMapper.selectByUserName(usernameFromToken);
        return new LoginUserVo()
            .setId(umsAdmin.getId())
            .setUsername(umsAdmin.getUsername())
            .setNickName(umsAdmin.getNickName())
            .setNote(umsAdmin.getNote())
            .setEmail(umsAdmin.getEmail());
    }

    @Override
    public UmsAdmin loadUserByUsername(String userName) {
        if (userName == null) {
            throw new NullPointerException();
        }
        return umsAdminMapper.selectByUserName(userName);
    }
}
