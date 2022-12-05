package com.rozhan.service.impl;

import com.rozhan.domain.Company;
import com.rozhan.exception.CompanyNotFoundException;
import com.rozhan.repository.CompanyRepository;
import com.rozhan.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;


    public Company findById(Integer id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Transactional
    public Company create(Company company) {
        companyRepository.save(company);
        return company;
    }

    @Transactional
    public void update(Integer id, Company uCompany) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
        //update
        company.setName(uCompany.getName());
        company.setInfo(uCompany.getInfo());
        companyRepository.save(company);
    }

    @Transactional
    public void delete(Integer id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
        companyRepository.delete(company);
    }

    @Override
    @Transactional
    public void dynamic_procedure() {
        companyRepository.dynamic_procedure();
    }
}
