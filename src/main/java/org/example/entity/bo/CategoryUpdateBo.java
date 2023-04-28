package org.example.entity.bo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.example.entity.po.PmsProductCategoryPo;

@Accessors(chain = true)
@Data
public class CategoryUpdateBo {
    private Long id;
    private String name;
    private int level;
    private int productCount;
    private String productUnit;
    private int navStatus;
    private int showStatus;
    private int sort;

    public PmsProductCategoryPo toPo() {
        return new PmsProductCategoryPo()
                .setId(this.id)
                .setName(this.name)
                .setLevel(this.level)
                .setProductCount(this.productCount)
                .setProductUnit(this.productUnit)
                .setNavStatus(this.navStatus)
                .setShowStatus(this.showStatus)
                .setSort(this.sort);
    }
}
