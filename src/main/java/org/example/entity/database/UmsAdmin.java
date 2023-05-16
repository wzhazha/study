package org.example.entity.database;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UmsAdmin {
    private Long id;
    private String username;
    private String password;
    private String icon;
    private String email;
    private String nickName;
    private String note;
    private Timestamp createTime;
    private Timestamp loginTime;
    private Integer status;
}
