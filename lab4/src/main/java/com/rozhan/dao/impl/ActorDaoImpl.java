package com.rozhan.dao.impl;

import com.rozhan.dao.ActorDao;
import com.rozhan.domain.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ActorDaoImpl implements ActorDao{
    private static final String FIND_ALL = "SELECT * FROM actor";
    private static final String CREATE = "INSERT actor(full_name, bio, age) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE actor SET full_name=?, bio=?, age=? WHERE id=?";
    private static final String DELETE = "DELETE FROM actor WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM actor WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Actor> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Actor.class));
    }

    @Override
    public Optional<Actor> findById(Integer id) {
        Optional<Actor> actor;
        try {
            actor = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Actor.class), id));
        } catch (EmptyResultDataAccessException e) {
            actor = Optional.empty();
        }
        return actor;
    }

    @Override
    public int create(Actor actor) {
        return jdbcTemplate.update(CREATE, actor.getFull_name(), actor.getBio(), actor.getAge());
    }

    @Override
    public int update(Integer id, Actor actor) {
        return jdbcTemplate.update(UPDATE, actor.getFull_name(), actor.getBio(), actor.getAge(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
