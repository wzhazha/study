package org.example.entity.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class PmsBrandPo {
    private Long id;
    private String name;
    private String firstLetter;
    private int sort;
    private int factoryStatus;
    private int showStatus;
    private int productCount;
    private int productCommentCount;
    private String logo;
    private String bigPic;
    private String brandStory;
}
