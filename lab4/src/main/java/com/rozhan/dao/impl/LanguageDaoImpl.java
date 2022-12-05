package com.rozhan.dao.impl;

import com.rozhan.dao.LanguageDao;
import com.rozhan.domain.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class LanguageDaoImpl implements LanguageDao {
    private static final String FIND_ALL = "SELECT * FROM language";
    private static final String CREATE = "INSERT language(language) VALUES (?)";
    private static final String UPDATE = "UPDATE language SET language=? WHERE id=?";
    private static final String DELETE = "DELETE FROM language WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM language WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Language> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Language.class));
    }

    @Override
    public Optional<Language> findById(Integer id) {
        Optional<Language> language;
        try {
            language = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Language.class), id));
        } catch (EmptyResultDataAccessException e) {
            language = Optional.empty();
        }
        return language;
    }

    @Override
    public int create(Language language) {
        return jdbcTemplate.update(CREATE, language.getLanguage());
    }

    @Override
    public int update(Integer id, Language language) {
        return jdbcTemplate.update(UPDATE, language.getLanguage(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
