package org.example.entity.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UmsAdminCreateBo {
    private String username;
    private String password;
    private String icon;
    private String email;
    private String nickName;
    private String note;
}
