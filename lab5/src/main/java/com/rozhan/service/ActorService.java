package com.rozhan.service;

import com.rozhan.domain.Actor;

import java.util.List;

public interface ActorService extends GeneralService<Actor, Long> {
    void insertTenActors();

    void insertActor(Actor actor);
}
