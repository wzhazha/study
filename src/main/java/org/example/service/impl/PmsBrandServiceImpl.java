package org.example.service.impl;

import org.example.entity.vo.PmsBrandVo;
import org.example.mapper.PmsBrandMapper;
import org.example.service.PmsBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Resource
    PmsBrandMapper pmsBrandMapper;

    @Override
    public PmsBrandVo getList(Long id, String name, String firstLetter, Integer page, Integer pageSize) {
        int offset = (page - 1) * pageSize;
        return new PmsBrandVo()
                .setTotalCount(pmsBrandMapper.selectCount(id, name, firstLetter))
                .setPmsBrandPoList(pmsBrandMapper.selectList(id, name, firstLetter, pageSize, offset));
    }
}
