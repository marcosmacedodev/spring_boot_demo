package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.GameListDto;
import com.example.demo.model.dto.GameMinDto;
import com.example.demo.model.dto.ReplacementDto;
import com.example.demo.services.GameListService;
import com.example.demo.services.GameService;

@RestController
@RequestMapping(value = "/gamelists")
public class GameListController {

    @Autowired
    private GameListService service;
    @Autowired
    private GameService gService;

    @GetMapping
    public List<GameListDto> getAll(){
        return service.findAll();
    }

    @GetMapping("/{listId}/games")
    public List<GameMinDto> getListById(@PathVariable Long listId){
    
        return gService.findByList(listId);
    }

    @PostMapping("/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDto replacementDto){
        service.move(listId, replacementDto.getSourceIndex(), replacementDto.getDestinationIndex());
    }
    
}
