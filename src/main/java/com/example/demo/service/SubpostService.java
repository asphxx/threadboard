package com.example.demo.service;

import com.example.demo.dto.SubpostDto;
import com.example.demo.model.Subpost;
import com.example.demo.repository.SubpostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class SubpostService {
    private final SubpostRepository subpostRepository;
    @Transactional
    public SubpostDto save(SubpostDto subpostDto){
        Subpost save = subpostRepository.save(mapSubpostDto(subpostDto));
        subpostDto.setId(save.getId());
        return subpostDto;
    }

    @Transactional(readOnly = true)
    public List<SubpostDto> getAll(){
        return subpostRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private SubpostDto mapToDto(Subpost subpost){
        return SubpostDto.builder().name(subpost.getName())
                .id(subpost.getId())
                .numberOfPosts(subpost.getPosts().size())
                .build();
    }
    private Subpost mapSubpostDto(SubpostDto subpostDto){
        return Subpost.builder().name(subpostDto.getName())
                .description(subpostDto.getDescription())
                .build();
    }

}
