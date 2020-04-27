package com.yz.service;

import com.yz.mapper.TypeMapper;
import com.yz.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public boolean saveType(String typename) {
       return typeMapper.save(typename)==1;
    }

    @Override
    public List<Type> getList() {
        List<Type> list = new ArrayList<>();
        typeMapper.getList().forEach((Type t)->{if(t.getId()!=0){list.add(t);}});
        return list;
    }

    @Override
    public boolean updateType(Long id,String typename) {
        return typeMapper.update(id,typename)==1;
    }

    @Override
    public boolean deleteType(Long id) {
        return typeMapper.delete(id)==1;
    }
}
