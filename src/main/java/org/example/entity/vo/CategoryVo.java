package org.example.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.example.entity.po.PmsProductCategoryPo;

import java.util.List;

@Data
@Accessors(chain = true)
public class CategoryVo {
    private List<PmsProductCategoryPo> productCategoryPoList;
    private Integer totalCount;
}
