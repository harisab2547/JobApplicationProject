package com.example.jobapplicationproject.company.impl;

import com.example.jobapplicationproject.company.Company;
import com.example.jobapplicationproject.company.CompanyRepository;
import com.example.jobapplicationproject.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public void saveCompanies(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Company company, Long id) {

        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()){
            Company updateCompany = companyOptional.get();
            updateCompany.setId(id);
            updateCompany.setJobs(company.getJobs());
            updateCompany.setDescription(company.getDescription());
            updateCompany.setName(company.getName());
            companyRepository.save(updateCompany);
            return true;
        }
        return false;
    }


}
