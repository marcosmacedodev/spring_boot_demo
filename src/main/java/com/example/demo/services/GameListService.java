package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.GameList;
import com.example.demo.model.dto.GameListDto;
import com.example.demo.repositories.GameListRepository;


@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> list = repository.findAll();
        return list.stream().map(gameList -> new GameListDto(gameList)).toList();
    }

    @Transactional(readOnly = true)
    public GameListDto findById(Long id){
        Optional<GameList> result = repository.findById(id);
        return new GameListDto(result.orElse(null));
    }
    
}
