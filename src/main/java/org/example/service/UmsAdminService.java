package org.example.service;

import org.example.entity.bo.UmsAdminCreateBo;
import org.example.entity.database.UmsAdmin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UmsAdminService {
    UmsAdmin register(UmsAdminCreateBo createBo) throws Exception;

    String login(String username, String password, HttpServletResponse response) throws Exception;

    Object state(HttpServletRequest request);


}
