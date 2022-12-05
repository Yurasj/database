package com.rozhan.dto.assembler;

import com.rozhan.dto.ActorDto;
import com.rozhan.controller.ActorController;
import com.rozhan.domain.Actor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ActorDtoAssembler implements RepresentationModelAssembler<Actor, ActorDto> {
    @Override
    public ActorDto toModel(Actor entity) {
        ActorDto actorDto = ActorDto.builder()
                .id((int)(long)entity.getId())
                .full_name(entity.getFullName())
                .bio(entity.getBio())
                .age(entity.getAge())
                .build();
        Link selfLink = linkTo(methodOn(ActorController.class).getActor((long)actorDto.getId())).withSelfRel();
        actorDto.add(selfLink);
        return actorDto;
    }

    @Override
    public CollectionModel<ActorDto> toCollectionModel(Iterable<? extends Actor> entities) {
        CollectionModel<ActorDto> actorDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ActorController.class).getAllActors()).withSelfRel();
        actorDtos.add(selfLink);
        return actorDtos;
    }

    public CollectionModel<ActorDto> toCollectionModel(Iterable<? extends Actor> entities, Link link) {
        CollectionModel<ActorDto> actorDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        actorDtos.add(link);
        return actorDtos;
    }
}
