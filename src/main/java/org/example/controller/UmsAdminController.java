package org.example.controller;

import org.example.api.CommonResult;
import org.example.entity.bo.UmsAdminCreateBo;
import org.example.entity.database.UmsAdmin;
import org.example.entity.pojo.UmsAdminLoginPojo;
import org.example.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class UmsAdminController {
    @Resource
    private UmsAdminService umsAdminService;
    @Value("${jwt.tokenPrefix}")
    private String tokenPrefix;

    @PutMapping("/register")
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdminCreateBo createBo) throws Exception {
        UmsAdmin umsAdmin = umsAdminService.register(createBo);
        if (umsAdmin == null) {
            return CommonResult.failed("Duplicate Username");
        }
        return CommonResult.success(umsAdmin);
    }

    @PostMapping("/login")
    public CommonResult login(@RequestBody UmsAdminLoginPojo umsAdminLoginPojo) throws Exception {
        String token = umsAdminService.login(umsAdminLoginPojo.getUsername(), umsAdminLoginPojo.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenPrefix", tokenPrefix);
        return CommonResult.success(tokenMap);
    }
}
