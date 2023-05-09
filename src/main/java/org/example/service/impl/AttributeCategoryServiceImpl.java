package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.database.PmsProductAttributeCategory;
import org.example.entity.vo.AttributeCategoryVo;
import org.example.mapper.AttributeCategoryMapper;
import org.example.service.AttributeCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AttributeCategoryServiceImpl implements AttributeCategoryService {

    @Resource
    AttributeCategoryMapper attributeCategoryMapper;

    @Override
    public AttributeCategoryVo getAttributeCategory(Long id, String name, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<PmsProductAttributeCategory> wrapper = new LambdaQueryWrapper<>();
        if (id != null) {
            wrapper.eq(PmsProductAttributeCategory::getId, id);
        }
        if (StringUtils.isNotBlank(name)) {
            wrapper.eq(PmsProductAttributeCategory::getName, name);
        }
        Page<PmsProductAttributeCategory> page = new Page<>(pageNum, pageSize);
        IPage<PmsProductAttributeCategory> result = attributeCategoryMapper.selectPage(page, wrapper);
        return new AttributeCategoryVo()
                .setAttributeCategoryList(result.getRecords())
                .setTotalCount(result.getTotal());
    }

    @Override
    public int insertAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory) {
        return attributeCategoryMapper.insert(pmsProductAttributeCategory);
    }

    @Override
    public int updateById(PmsProductAttributeCategory pmsProductAttributeCategory) {
        return attributeCategoryMapper.updateById(pmsProductAttributeCategory);
    }
}
