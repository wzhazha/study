package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.database.PmsProduct;
import org.example.entity.vo.PmsProductVo;
import org.example.mapper.PmsProductMapper;
import org.example.service.PmsProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PmsProductServiceImpl implements PmsProductService {

    @Resource
    private PmsProductMapper pmsProductMapper;

    @Override
    public PmsProductVo getPmsProduct(Long id, String name, Integer productSn, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<PmsProduct> wrapper = new LambdaQueryWrapper<>();
        if (id != null) {
            wrapper.eq(PmsProduct::getId, id);
        }
        if (StringUtils.isNotBlank(name)) {
            wrapper.eq(PmsProduct::getName, name);
        }
        if (productSn != null) {
            wrapper.eq(PmsProduct::getProductSn, productSn);
        }
        wrapper.orderByAsc(PmsProduct::getSort);
        Page<PmsProduct> page = new Page<>(pageNum, pageSize);
        IPage<PmsProduct> result = pmsProductMapper.selectPage(page, wrapper);
        return new PmsProductVo()
                .setProductList(result.getRecords())
                .setTotalCount(result.getTotal());
    }
}
