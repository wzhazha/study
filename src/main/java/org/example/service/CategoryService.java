package org.example.service;

import org.example.entity.po.PmsProductCategoryPo;
import org.example.entity.vo.CategoryVo;


public interface CategoryService {

    CategoryVo getProduct(Long id, String name, Integer level, Integer page, Integer pageSize);

    int createPo(PmsProductCategoryPo pmsProductCategoryPo);

    int updateByPo(PmsProductCategoryPo pmsProductCategoryPo);

    int abolishById(Long id);
}
