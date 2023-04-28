package org.example.service.impl;

import org.example.entity.vo.CategoryVo;
import org.example.mapper.CategoryMapper;
import org.example.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public CategoryVo getProduct(Long parentId, String name, Integer level, Integer page, Integer pageSize) {
        int offset = (page - 1) * pageSize;
        return new CategoryVo()
                .setTotalCount(categoryMapper.selectCount(parentId, name, level))
                .setProductCategoryPoList(categoryMapper.selectList(parentId, name, level, pageSize, offset));
    }
}
