package com.rozhan.dto.assembler;

import com.rozhan.dto.AwardDto;
import com.rozhan.controller.AwardController;
import com.rozhan.domain.Award;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AwardDtoAssembler implements RepresentationModelAssembler<Award, AwardDto> {
    @Override
    public AwardDto toModel(Award entity) {
        AwardDto awardDto = AwardDto.builder()
                .id((int)(long)entity.getId())
                .name(entity.getName())
                .build();
        Link selfLink = linkTo(methodOn(AwardController.class).getAward(awardDto.getId())).withSelfRel();
        awardDto.add(selfLink);
        return awardDto;
    }

    @Override
    public CollectionModel<AwardDto> toCollectionModel(Iterable<? extends Award> entities) {
        CollectionModel<AwardDto> awardDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(AwardController.class).getAllAwards()).withSelfRel();
        awardDtos.add(selfLink);
        return awardDtos;
    }

    public CollectionModel<AwardDto> toCollectionModel(Iterable<? extends Award> entities, Link link) {
        CollectionModel<AwardDto> awardDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        awardDtos.add(link);
        return awardDtos;
    }
}
