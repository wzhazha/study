package org.example.entity.bo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.example.entity.po.PmsProductCategoryPo;

@Accessors(chain = true)
@Data
public class CategoryCreateBo {
    private Long parentId;
    private String name;
    private int level;
    private int productCount;
    private String productUnit;
    private int navStatus;
    private int showStatus;
    private int sort;
    private String icon;
    private String keywords;
    private String description;

    public PmsProductCategoryPo toPo() {
        return new PmsProductCategoryPo()
                .setParentId(this.parentId)
                .setName(this.name)
                .setLevel(this.level)
                .setProductCount(this.productCount)
                .setProductUnit(this.productUnit)
                .setNavStatus(this.navStatus)
                .setShowStatus(this.getShowStatus())
                .setSort(this.sort)
                .setIcon(this.icon)
                .setKeywords(this.keywords)
                .setDescription(this.description);
    }

}
