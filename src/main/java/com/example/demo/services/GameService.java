package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Game;
import com.example.demo.model.dto.GameMinDto;
import com.example.demo.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public List<GameMinDto> findAll(){
        List<Game> list = repository.findAll();
        return list.stream().map((game) -> new GameMinDto(game)).collect(Collectors.toList());
    }
    
}
