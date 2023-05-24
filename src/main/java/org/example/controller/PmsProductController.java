package org.example.controller;

import org.example.api.CommonResult;
import org.example.entity.vo.PmsProductVo;
import org.example.service.PmsProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class PmsProductController {

    @Resource
    private PmsProductService pmsProductService;

    @GetMapping("")
    public CommonResult<PmsProductVo> getList(
            @RequestParam(required = false, value = "id") Long id,
            @RequestParam(required = false, value = "name") String name,
            @RequestParam(required = false, value = "productSn") Integer productSn,
            @RequestParam(required = false, value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        PmsProductVo list = pmsProductService.getPmsProduct(id, name, productSn, pageNum, pageSize);
        return CommonResult.success(list);
    }
}
