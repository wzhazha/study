package org.example.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginUserVo {
  private Long id;
  private String username;
  private String email;
  private String nickName;
  private String note;

}
