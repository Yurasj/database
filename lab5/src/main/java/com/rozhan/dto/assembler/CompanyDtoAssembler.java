package com.rozhan.dto.assembler;

import com.rozhan.dto.CompanyDto;
import com.rozhan.controller.CompanyController;
import com.rozhan.domain.Company;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CompanyDtoAssembler implements RepresentationModelAssembler<Company, CompanyDto> {
    @Override
    public CompanyDto toModel(Company entity) {
        CompanyDto companyDto = CompanyDto.builder()
                .id((int)(long)entity.getId())
                .name(entity.getName())
                .info(entity.getInfo())
                .build();
        Link selfLink = linkTo(methodOn(CompanyController.class).getCompany(companyDto.getId())).withSelfRel();
        companyDto.add(selfLink);
        return companyDto;
    }

    @Override
    public CollectionModel<CompanyDto> toCollectionModel(Iterable<? extends Company> entities) {
        CollectionModel<CompanyDto> companyDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(CompanyController.class).getAllCompanies()).withSelfRel();
        companyDtos.add(selfLink);
        return companyDtos;
    }

    public CollectionModel<CompanyDto> toCollectionModel(Iterable<? extends Company> entities, Link link) {
        CollectionModel<CompanyDto> companyDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        companyDtos.add(link);
        return companyDtos;
    }
}
