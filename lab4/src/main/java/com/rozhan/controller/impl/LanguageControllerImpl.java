package com.rozhan.controller.impl;

import com.rozhan.controller.LanguageController;
import com.rozhan.domain.Language;
import com.rozhan.controller.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageControllerImpl implements LanguageController {
    @Autowired
    private LanguageService languageService;

    @Override
    public List<Language> findAll() {
        return languageService.findAll();
    }

    @Override
    public Optional<Language> findById(Integer id) {
        return languageService.findById(id);
    }

    @Override
    public int create(Language language) {
        return languageService.create(language);
    }

    @Override
    public int update(Integer id, Language language) {
        return languageService.update(id, language);
    }

    @Override
    public int delete(Integer id) {
        return languageService.delete(id);
    }
}

