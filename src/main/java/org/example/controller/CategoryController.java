package org.example.controller;

import org.example.api.CommonResult;
import org.example.entity.vo.CategoryVo;
import org.example.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    CategoryService categoryService;

    @GetMapping("")
    public CommonResult<CategoryVo> getCategory(
            @RequestParam(required = false, value = "parentId") Long parentId,
            @RequestParam(required = false, value = "name") String name,
            @RequestParam(required = false, value = "level") Integer level,
            @RequestParam(required = false, value = "page", defaultValue = "1") Integer page,
            @RequestParam(required = false, value = "pageSize", defaultValue = "10") Integer pageSize) {
        CategoryVo product = categoryService.getProduct(parentId, name, level, page, pageSize);
        return CommonResult.success(product);
    }
}
