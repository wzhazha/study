package org.example.service;

import org.example.entity.vo.PmsBrandVo;

public interface PmsBrandService {

    PmsBrandVo getList(Long id, String name, String firstLetter, Integer page, Integer pageSize);
}
