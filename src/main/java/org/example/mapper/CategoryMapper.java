package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.entity.po.PmsProductCategoryPo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {

    int selectCount(
            @Param("parentId") Long parentId,
            @Param("name") String name,
            @Param("level") Integer level);

    List<PmsProductCategoryPo> selectList(
            @Param("parentId") Long parentId,
            @Param("name") String name,
            @Param("level") Integer level,
            @Param("pageSize") Integer pageSize,
            @Param("offset") int offset);
}
