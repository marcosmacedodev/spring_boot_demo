package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.GameList;
import com.example.demo.model.dto.GameListDto;
import com.example.demo.projections.GameMinProjection;
import com.example.demo.repositories.GameListRepository;
import com.example.demo.repositories.GameRepository;


@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;

    @Autowired
    private GameRepository gRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> list = repository.findAll();
        return list.stream().map(gameList -> new GameListDto(gameList)).toList();
    }

    @Transactional
    public void move(Long listid, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gRepository.searchByList(listid);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for(int it = min; it <= max; it++){
            repository.updateBelongingPosition(listid, list.get(it).getId(), it);
        }
    }
    
}
