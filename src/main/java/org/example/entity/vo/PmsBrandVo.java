package org.example.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.example.entity.po.PmsBrandPo;

import java.util.List;

@Data
@Accessors(chain = true)
public class PmsBrandVo {
    private List<PmsBrandPo> pmsBrandPoList;
    private Integer totalCount;
}
