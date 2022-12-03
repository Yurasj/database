package com.rozhan.controller;

import com.rozhan.domain.Actor;
import com.rozhan.dto.ActorDto;
import com.rozhan.dto.assembler.ActorDtoAssembler;
import com.rozhan.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/actors")
public class ActorController {
    @Autowired
    private ActorService actorService;
    @Autowired
    private ActorDtoAssembler actorDtoAssembler;

    @GetMapping(value = "/{actorId}")
    public ResponseEntity<ActorDto> getActor(@PathVariable Integer actorId) {
        Actor actor = actorService.findById(actorId);
        ActorDto actorDto = actorDtoAssembler.toModel(actor);
        return new ResponseEntity<>(actorDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ActorDto>> getAllActors() {
        List<Actor> actors = actorService.findAll();
        CollectionModel<ActorDto> actorDtos = actorDtoAssembler.toCollectionModel(actors);
        return new ResponseEntity<>(actorDtos, HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<ActorDto> addAward(@RequestBody Actor actor) {
        Actor newActor = actorService.create(actor);
        ActorDto actorDto = actorDtoAssembler.toModel(newActor);
        return new ResponseEntity<>(actorDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{actorId}")
    public ResponseEntity<?> updateAward(@RequestBody Actor uActor, @PathVariable Integer actorId) {
        actorService.update(actorId, uActor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{actorId}")
    public ResponseEntity<?> deleteActor(@PathVariable Integer actorId) {
        actorService.delete(actorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
