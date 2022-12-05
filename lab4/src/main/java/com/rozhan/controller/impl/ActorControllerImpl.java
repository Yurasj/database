package com.rozhan.controller.impl;

import com.rozhan.controller.ActorController;
import com.rozhan.domain.Actor;
import com.rozhan.controller.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorControllerImpl implements ActorController {
    @Autowired
    private ActorService actorService;

    @Override
    public List<Actor> findAll() {
        return actorService.findAll();
    }

    @Override
    public Optional<Actor> findById(Integer id) {
        return actorService.findById(id);
    }

    @Override
    public int create(Actor actor) {
        return actorService.create(actor);
    }

    @Override
    public int update(Integer id, Actor actor) {
        return actorService.update(id, actor);
    }

    @Override
    public int delete(Integer id) {
        return actorService.delete(id);
    }
}