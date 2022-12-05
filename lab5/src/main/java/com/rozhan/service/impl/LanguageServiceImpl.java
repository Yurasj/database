package com.rozhan.service.impl;

import com.rozhan.domain.Language;
import com.rozhan.exception.LanguageNotFoundException;
import com.rozhan.repository.LanguageRepository;
import com.rozhan.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    LanguageRepository languageRepository;


    public Language findById(Integer id) {
        return languageRepository.findById(id)
                .orElseThrow(() -> new LanguageNotFoundException(id));
    }

    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Transactional
    public Language create(Language language) {
        languageRepository.save(language);
        return language;
    }

    @Transactional
    public void update(Integer id, Language uLanguage) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new LanguageNotFoundException(id));
        //update
        language.setLanguage(uLanguage.getLanguage());
        languageRepository.save(language);
    }

    @Transactional
    public void delete(Integer id) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new LanguageNotFoundException(id));
        languageRepository.delete(language);
    }
}