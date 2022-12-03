package com.rozhan.controller.impl;

import com.rozhan.controller.AwardController;
import com.rozhan.domain.Award;
import com.rozhan.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AwardControllerImpl implements AwardController {
    @Autowired
    private AwardService awardService;

    @Override
    public List<Award> findAll() {
        return awardService.findAll();
    }

    @Override
    public Optional<Award> findById(Integer id) {
        return awardService.findById(id);
    }

    @Override
    public int create(Award award) {
        return awardService.create(award);
    }

    @Override
    public int update(Integer id, Award award) {
        return awardService.update(id, award);
    }

    @Override
    public int delete(Integer id) {
        return awardService.delete(id);
    }
}
