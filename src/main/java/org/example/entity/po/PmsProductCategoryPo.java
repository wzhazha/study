package org.example.entity.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;


@Data
@Accessors(chain = true)
@NoArgsConstructor
public class PmsProductCategoryPo {
    private Long id;
    private Long parentId;
    private String name;
    private Integer level;
    private Integer productCount;
    private String productUnit;
    private Integer navStatus;
    private Integer showStatus;
    private Integer sort;
    private String icon;
    private String keywords;
    private String description;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Timestamp deleteTime;
}
