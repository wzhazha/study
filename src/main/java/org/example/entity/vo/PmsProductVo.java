package org.example.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.example.entity.database.PmsProduct;

import java.util.List;

@Data
@Accessors(chain = true)
public class PmsProductVo {
    private List<PmsProduct> productList;
    private Long totalCount;
}
