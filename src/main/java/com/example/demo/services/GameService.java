package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Game;
import com.example.demo.model.dto.GameDto;
import com.example.demo.model.dto.GameMinDto;
import com.example.demo.projections.GameMinProjection;
import com.example.demo.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        List<Game> list = repository.findAll();
        return list.stream().map((game) -> new GameMinDto(game)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id){

        Optional<Game> game = repository.findById(id);

        return new GameDto(game.orElse(null));

    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listId){
        List<GameMinProjection> list = repository.searchByList(listId);
        return list.stream().map((game) -> new GameMinDto(game)).collect(Collectors.toList());
    }
    
}
