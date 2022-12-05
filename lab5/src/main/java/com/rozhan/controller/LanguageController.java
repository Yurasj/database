package com.rozhan.controller;

import com.rozhan.domain.Language;
import com.rozhan.dto.LanguageDto;
import com.rozhan.dto.assembler.LanguageDtoAssembler;
import com.rozhan.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;
    @Autowired
    private LanguageDtoAssembler languageDtoAssembler;

    @GetMapping(value = "/{languageId}")
    public ResponseEntity<LanguageDto> getLanguage(@PathVariable Integer languageId) {
        Language language = languageService.findById(languageId);
        LanguageDto languageDto = languageDtoAssembler.toModel(language);
        return new ResponseEntity<>(languageDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<LanguageDto>> getAllLanguages() {
        List<Language> languages = languageService.findAll();
        CollectionModel<LanguageDto> languageDtos = languageDtoAssembler.toCollectionModel(languages);
        return new ResponseEntity<>(languageDtos, HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<LanguageDto> addLanguage(@RequestBody Language language) {
        Language newLanguage = languageService.create(language);
        LanguageDto languageDto = languageDtoAssembler.toModel(newLanguage);
        return new ResponseEntity<>(languageDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{languageId}")
    public ResponseEntity<?> updateLanguage(@RequestBody Language uLanguage, @PathVariable Integer languageId) {
        languageService.update(languageId, uLanguage);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{languageId}")
    public ResponseEntity<?> deleteLanguage(@PathVariable Integer languageId) {
        languageService.delete(languageId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
