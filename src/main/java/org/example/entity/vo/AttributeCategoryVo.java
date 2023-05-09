package org.example.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.example.entity.database.PmsProductAttributeCategory;

import java.util.List;

@Data
@Accessors(chain = true)
public class AttributeCategoryVo {
    private List<PmsProductAttributeCategory> attributeCategoryList;
    private Long totalCount;
}
