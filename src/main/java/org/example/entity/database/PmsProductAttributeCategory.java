package org.example.entity.database;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class PmsProductAttributeCategory {
    private Long id;
    private String name;
    private int attributeCount;
    private int paramCount;
}
