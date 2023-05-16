package org.example.mapper;

import org.example.entity.database.UmsAdmin;
import org.springframework.stereotype.Repository;

@Repository
public interface UmsAdminMapper {
    int insert(UmsAdmin user);

    int countByUsername(String userName);

    UmsAdmin selectByUsername(String userName);
}
