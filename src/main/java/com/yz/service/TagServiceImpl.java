package com.yz.service;

import com.yz.mapper.TagMapper;
import com.yz.mapper.TypeMapper;
import com.yz.pojo.Tag;
import com.yz.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public boolean saveTag(String typename) {
       return tagMapper.save(typename)==1;
    }

    @Override
    public List<Tag> getList() {
        return tagMapper.getList();
    }

    @Override
    public boolean updateTag(Long id,String typename) {
        return tagMapper.update(id,typename)==1;
    }

    @Override
    public boolean deleteTag(Long id) {
        return tagMapper.delete(id)==1;
    }

}
