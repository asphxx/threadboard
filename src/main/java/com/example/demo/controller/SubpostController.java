package com.example.demo.controller;

import com.example.demo.dto.SubpostDto;
import com.example.demo.service.SubpostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subpost")
@AllArgsConstructor
@Slf4j
public class SubpostController {
    private final SubpostService subpostService;

    @PostMapping
    public ResponseEntity<SubpostDto> createSubpost(@RequestBody SubpostDto subpostDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subpostService.save(subpostDto));
    }

    @GetMapping
    public ResponseEntity<List<SubpostDto>> getAllSubposts(){
        return ResponseEntity.status(HttpStatus.OK).body(subpostService.getAll());
    }
}
