package com.yz.mapper;

import com.yz.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeMapper {
    int save(String typename);
    List<Type> getList();
    int delete(Long id);
    int update(Long id,String typename);
}
