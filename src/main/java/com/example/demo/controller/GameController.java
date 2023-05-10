package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.GameDto;
import com.example.demo.model.dto.GameMinDto;
import com.example.demo.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public List<GameMinDto> getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public GameDto get(@PathVariable Long id){
        return service.findById(id);
    }
}
