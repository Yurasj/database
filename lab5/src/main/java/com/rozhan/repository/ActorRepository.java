package com.rozhan.repository;

import com.rozhan.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Procedure("insert_actor")
    void insertActorWithProcedure(String full_name, String bio, Integer age);

    @Procedure("insert_10_actors")
    void insertTenActors();
}
