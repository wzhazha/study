package org.example.service;

import org.example.entity.vo.CategoryVo;


public interface CategoryService {

    CategoryVo getProduct(Long parentId, String name, Integer level, Integer page, Integer pageSize);
}
