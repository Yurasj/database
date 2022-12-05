package com.rozhan.controller.service.impl;

import com.rozhan.dao.AwardDao;
import com.rozhan.domain.Award;
import com.rozhan.controller.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AwardServiceImpl implements AwardService {
    @Autowired
    private AwardDao awardDao;

    @Override
    public List<Award> findAll() {
        return awardDao.findAll();
    }

    @Override
    public Optional<Award> findById(Integer id) {
        return awardDao.findById(id);
    }

    @Override
    public int create(Award award) {
        return awardDao.create(award);
    }

    @Override
    public int update(Integer id, Award award) {
        return awardDao.update(id, award);
    }

    @Override
    public int delete(Integer id) {
        return awardDao.delete(id);
    }

}
