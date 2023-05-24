package org.example.entity.database;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class PmsProduct {
    private Long id;
    private Long brandId;
    private Long productCategoryId;
    private Long productAttributeCategoryId;
    private String name;
    private String pic;
    private String productSn;
    private Integer deleteStatus;
    private Integer publishStatus;
    private Integer newStatus;
    private Integer recommendStatus;
    private Integer verifyStatus;
    private Integer sort;
    private Integer sale;
    private Double price;
    private Double promotionPrice;
    private Integer giftGrowth;
    private Integer giftPoint;
    private Integer usePointLimit;
    private String subTitle;
    private String description;
    private Double originalPrice;
    private Integer stock;
    private Integer lowStock;
    private String unit;
    private Double weight;
    private Integer previewStatus;
    private String serviceIds;
    private String keywords;
    private String note;
    private String albumPics;
    private String detailTitle;
    private String detailDesc;
    private String detailHtml;
    private String detailMobileHtml;
    private Timestamp promotionStartTime;
    private Timestamp promotionEndTime;
    private Integer promotionPerLimit;
    private Integer promotionType;
    private String productCategoryName;
    private String brandName;
}
