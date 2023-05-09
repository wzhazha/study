package org.example.service;

import org.example.entity.vo.AttributeCategoryVo;

public interface AttributeCategoryService {
    AttributeCategoryVo getAttributeCategory(Long id, String name, Integer pageNum, Integer pageSize);
}
