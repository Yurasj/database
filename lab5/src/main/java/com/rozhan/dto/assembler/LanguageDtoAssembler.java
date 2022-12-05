package com.rozhan.dto.assembler;

import com.rozhan.dto.LanguageDto;
import com.rozhan.controller.LanguageController;
import com.rozhan.domain.Language;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class LanguageDtoAssembler implements RepresentationModelAssembler<Language, LanguageDto> {
    @Override
    public LanguageDto toModel(Language entity) {
        LanguageDto languageDto = LanguageDto.builder()
                .id((int)(long)entity.getId())
                .language(entity.getLanguage())
                .build();
        Link selfLink = linkTo(methodOn(LanguageController.class).getLanguage(languageDto.getId())).withSelfRel();
        languageDto.add(selfLink);
        return languageDto;
    }

    @Override
    public CollectionModel<LanguageDto> toCollectionModel(Iterable<? extends Language> entities) {
        CollectionModel<LanguageDto> languageDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(LanguageController.class).getAllLanguages()).withSelfRel();
        languageDtos.add(selfLink);
        return languageDtos;
    }

    public CollectionModel<LanguageDto> toCollectionModel(Iterable<? extends Language> entities, Link link) {
        CollectionModel<LanguageDto> languageDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        languageDtos.add(link);
        return languageDtos;
    }
}
