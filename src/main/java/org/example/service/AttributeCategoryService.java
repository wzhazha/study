package org.example.service;

import org.example.entity.database.PmsProductAttributeCategory;
import org.example.entity.vo.AttributeCategoryVo;

public interface AttributeCategoryService {
    AttributeCategoryVo getAttributeCategory(Long id, String name, Integer pageNum, Integer pageSize);

    int insertAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory);

    int updateById(PmsProductAttributeCategory pmsProductAttributeCategory);
}
