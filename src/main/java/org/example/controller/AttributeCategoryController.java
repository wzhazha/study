package org.example.controller;

import org.example.api.CommonResult;
import org.example.entity.vo.AttributeCategoryVo;
import org.example.service.AttributeCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/attribute-category")
public class AttributeCategoryController {

    @Resource
    AttributeCategoryService attributeCategoryService;

    @GetMapping("")
    public CommonResult<AttributeCategoryVo> getList(
            @RequestParam(required = false, value = "id") Long id,
            @RequestParam(required = false, value = "name") String name,
            @RequestParam(required = false, value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, value = "pageSize", defaultValue = "10") Integer pageSize) {
        AttributeCategoryVo list = attributeCategoryService.getAttributeCategory(id, name, pageNum, pageSize);
        return CommonResult.success(list);
    }
}
