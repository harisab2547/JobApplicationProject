package com.example.jobapplicationproject.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies()
    {
        List<Company> companies = companyService.getAllCompany();
        return new ResponseEntity<>(companies,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompanies(@RequestBody Company company){
        companyService.saveCompanies(company);
        return new ResponseEntity<>("Company Saved",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,
                                                @RequestBody Company company){
        companyService.updateCompany(company,id);
        return new ResponseEntity<>("Company Updated Successfully", HttpStatus.OK);
    }


}
