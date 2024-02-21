package com.example.Group.Models.Converters;

import com.example.Group.Interfaces.GroupRepository;
import com.example.Group.Models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class GroupByIdConverter implements Converter<Integer, Group> {
    private GroupRepository groupRepository;
    @Autowired
    public GroupByIdConverter(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
    @Override
    public Group convert(Integer id) {
        return groupRepository.findById(id).orElse(null);
    }
}

