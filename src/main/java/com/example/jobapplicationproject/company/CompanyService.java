package com.example.jobapplicationproject.company;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    List<Company> getAllCompany();

    void saveCompanies(Company company);

    boolean updateCompany(Company company,Long id);

    boolean deleteCompany(Long id);

    Company getCompanyByID(Long id);


}
