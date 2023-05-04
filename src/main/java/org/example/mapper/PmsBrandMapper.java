package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.entity.po.PmsBrandPo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PmsBrandMapper {

    int selectCount(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("firstLetter") String firstLetter
    );

    List<PmsBrandPo> selectList(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("firstLetter") String firstLetter,
            @Param("pageSize") Integer pageSize,
            @Param("offset") int offset
    );
}
