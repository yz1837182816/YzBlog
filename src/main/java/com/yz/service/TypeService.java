package com.yz.service;

import com.yz.pojo.Type;

import java.util.List;

public interface TypeService{
    boolean saveType(String typename);
    List<Type> getList();
    boolean updateType(Long id,String typename);
    boolean deleteType(Long id);
}
