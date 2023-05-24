package org.example.service;

import org.example.entity.vo.PmsProductVo;

public interface PmsProductService {
    PmsProductVo getPmsProduct(Long id, String name, Integer productSn, Integer pageNum, Integer pageSize);
}
