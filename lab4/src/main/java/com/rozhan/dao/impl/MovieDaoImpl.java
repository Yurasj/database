package com.rozhan.dao.impl;

import com.rozhan.dao.MovieDao;
import com.rozhan.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class MovieDaoImpl implements MovieDao{
    private static final String FIND_ALL = "SELECT * FROM movie";
    private static final String CREATE = "INSERT movie(company_id, language_id, actor_id, award_id, name, info) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE movie SET company_id=?, language_id=?, actor_id=?, award_id=?, name=?, info=? WHERE id=?";
    private static final String DELETE = "DELETE FROM movie WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM movie WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Movie> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Movie.class));
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        Optional<Movie> movie;
        try {
            movie = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Movie.class), id));
        } catch (EmptyResultDataAccessException e) {
            movie = Optional.empty();
        }
        return movie;
    }

    @Override
    public int create(Movie movie) {
        return jdbcTemplate.update(CREATE, movie.getCompany_id(), movie.getLanguage_id(), movie.getActor_id(), movie.getAward_id(), movie.getName(), movie.getInfo());
    }

    @Override
    public int update(Integer id, Movie movie) {
        return jdbcTemplate.update(UPDATE, movie.getCompany_id(), movie.getLanguage_id(), movie.getActor_id(), movie.getAward_id(), movie.getName(), movie.getInfo(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
