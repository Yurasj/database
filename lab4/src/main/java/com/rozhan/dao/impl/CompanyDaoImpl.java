package com.rozhan.dao.impl;

import com.rozhan.dao.CompanyDao;
import com.rozhan.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class CompanyDaoImpl implements CompanyDao {
    private static final String FIND_ALL = "SELECT * FROM company";
    private static final String CREATE = "INSERT company(name, info) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE company SET name=?, info=? WHERE id=?";
    private static final String DELETE = "DELETE FROM company WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM company WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Company> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Company.class));
    }

    @Override
    public Optional<Company> findById(Integer id) {
        Optional<Company> company;
        try {
            company = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Company.class), id));
        } catch (EmptyResultDataAccessException e) {
            company = Optional.empty();
        }
        return company;
    }

    @Override
    public int create(Company company) {
        return jdbcTemplate.update(CREATE, company.getName(), company.getInfo());
    }

    @Override
    public int update(Integer id, Company company) {
        return jdbcTemplate.update(UPDATE, company.getName(), company.getInfo(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
