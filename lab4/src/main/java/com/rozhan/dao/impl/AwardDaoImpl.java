package com.rozhan.dao.impl;

import com.rozhan.dao.AwardDao;
import com.rozhan.domain.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class AwardDaoImpl implements AwardDao {
    private static final String FIND_ALL = "SELECT * FROM award";
    private static final String CREATE = "INSERT award(name) VALUES (?)";
    private static final String UPDATE = "UPDATE award SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM award WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM award WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Award> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Award.class));
    }

    @Override
    public Optional<Award> findById(Integer id) {
        Optional<Award> award;
        try {
            award = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Award.class), id));
        } catch (EmptyResultDataAccessException e) {
            award = Optional.empty();
        }
        return award;
    }

    @Override
    public int create(Award award) {
        return jdbcTemplate.update(CREATE, award.getName());
    }

    @Override
    public int update(Integer id, Award award) {
        return jdbcTemplate.update(UPDATE, award.getName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
