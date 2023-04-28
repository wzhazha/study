package org.example.controller;

import org.example.api.CommonResult;
import org.example.entity.bo.CategoryCreateBo;
import org.example.entity.bo.CategoryUpdateBo;
import org.example.entity.vo.CategoryVo;
import org.example.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    CategoryService categoryService;

    @GetMapping("")
    public CommonResult<CategoryVo> getCategory(
            @RequestParam(required = false, value = "id") Long id,
            @RequestParam(required = false, value = "name") String name,
            @RequestParam(required = false, value = "level") Integer level,
            @RequestParam(required = false, value = "page", defaultValue = "1") Integer page,
            @RequestParam(required = false, value = "pageSize", defaultValue = "10") Integer pageSize) {
        CategoryVo product = categoryService.getProduct(id, name, level, page, pageSize);
        return CommonResult.success(product);
    }

    @PutMapping("")
    public CommonResult putCategory(@RequestBody CategoryCreateBo createBo) {
        int count = categoryService.createPo(createBo.toPo());
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @PostMapping("")
    public CommonResult postCategory(@RequestBody CategoryUpdateBo updateBo) {
        int count = categoryService.updateByPo(updateBo.toPo());
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @DeleteMapping("")
    public CommonResult deleteCategory(@RequestParam Long id) {
        int count = categoryService.abolishById(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
