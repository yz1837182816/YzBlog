package com.yz.service;

import com.yz.pojo.Tag;
import com.yz.pojo.Type;

import java.util.List;

public interface TagService {
    boolean saveTag(String tagName);
    List<Tag> getList();
    boolean updateTag(Long id,String tagName);
    boolean deleteTag(Long id);
}
