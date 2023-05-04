package org.example.controller;

import org.example.api.CommonResult;
import org.example.entity.vo.PmsBrandVo;
import org.example.service.PmsBrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Resource
    PmsBrandService pmsBrandService;

    @GetMapping("")
    public CommonResult<PmsBrandVo> getList(
            @RequestParam(required = false, value = "id") Long id,
            @RequestParam(required = false, value = "name") String name,
            @RequestParam(required = false, value = "firstLetter") String firstLetter,
            @RequestParam(required = false, value = "page", defaultValue = "1") Integer page,
            @RequestParam(required = false, value = "pageSize", defaultValue = "10") Integer pageSize) {
        PmsBrandVo list = pmsBrandService.getList(id, name, firstLetter, page, pageSize);
        return CommonResult.success(list);
    }
}
