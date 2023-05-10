package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.GameListDto;
import com.example.demo.services.GameListService;

@RestController
@RequestMapping(value = "/gamelists")
public class GameListController {

    @Autowired
    private GameListService service;

    @GetMapping
    public List<GameListDto> getAll(){
        return service.findAll();
    }

    // @GetMapping("/{id}")
    // public GameListDto get(@PathVariable Long id){
    //     return service.findById(id);
    // }
    
}
