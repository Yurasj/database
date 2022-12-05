package com.rozhan.service.impl;

import com.rozhan.domain.Actor;
import com.rozhan.exception.ActorNotFoundException;
import com.rozhan.repository.ActorRepository;
import com.rozhan.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    ActorRepository actorRepository;


    public Actor findById(Long id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(id));
    }

    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Transactional
    public Actor create(Actor actor) {
        actorRepository.save(actor);
        return actor;
    }

    @Transactional
    public void update(Long id, Actor uActor) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(id));
        //update
        actor.setFullName(uActor.getFullName());
        actor.setBio(uActor.getBio());
        actor.setAge(uActor.getAge());
        actorRepository.save(actor);
    }

    @Transactional
    public void delete(Long id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(id));
        actorRepository.delete(actor);
    }

    @Override
    @Transactional
    public void insertTenActors() {
        actorRepository.insertTenActors();
    }

    @Override
    @Transactional
    public void insertActor(Actor actor) {
        actorRepository.insertActorWithProcedure(actor.getFullName(),
                actor.getBio(), actor.getAge());
    }
}
