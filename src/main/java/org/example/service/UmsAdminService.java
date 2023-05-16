package org.example.service;

import org.example.entity.bo.UmsAdminCreateBo;
import org.example.entity.database.UmsAdmin;

public interface UmsAdminService {
    UmsAdmin register(UmsAdminCreateBo createBo) throws Exception;

    String login(String username, String password) throws Exception;
}
