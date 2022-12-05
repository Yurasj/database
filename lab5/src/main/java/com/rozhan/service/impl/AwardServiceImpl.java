package com.rozhan.service.impl;

import com.rozhan.domain.Award;
import com.rozhan.exception.AwardNotFoundException;
import com.rozhan.repository.AwardRepository;
import com.rozhan.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AwardServiceImpl implements AwardService {
    @Autowired
    AwardRepository awardRepository;


    public Award findById(Integer id) {
        return awardRepository.findById(id)
                .orElseThrow(() -> new AwardNotFoundException(id));
    }

    public List<Award> findAll() {
        return awardRepository.findAll();
    }

    @Transactional
    public Award create(Award award) {
        awardRepository.save(award);
        return award;
    }

    @Transactional
    public void update(Integer id, Award uAward) {
        Award award = awardRepository.findById(id)
                .orElseThrow(() -> new AwardNotFoundException(id));
        //update
        award.setName(uAward.getName());
        awardRepository.save(award);
    }

    @Transactional
    public void delete(Integer id) {
        Award award = awardRepository.findById(id)
                .orElseThrow(() -> new AwardNotFoundException(id));
        awardRepository.delete(award);
    }
}
