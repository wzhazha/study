package org.example.service.impl;

import org.example.entity.po.PmsProductCategoryPo;
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
    public CategoryVo getProduct(Long id, String name, Integer level, Integer page, Integer pageSize) {
        int offset = (page - 1) * pageSize;
        return new CategoryVo()
                .setTotalCount(categoryMapper.selectCount(id, name, level))
                .setProductCategoryPoList(categoryMapper.selectList(id, name, level, pageSize, offset));
    }

    @Override
    public int createPo(PmsProductCategoryPo pmsProductCategoryPo) {
        return categoryMapper.insertPo(pmsProductCategoryPo);
    }

    @Override
    public int updateByPo(PmsProductCategoryPo pmsProductCategoryPo) {
        return categoryMapper.updateByPo(pmsProductCategoryPo);
    }

    @Override
    public int abolishById(Long id) {
        return categoryMapper.abolishById(id);
    }
}
