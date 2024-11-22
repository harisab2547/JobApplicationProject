package com.example.jobapplicationproject;

import com.example.jobapplicationproject.company.Company;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name= "job_table")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;

    private String maxSalary;
    private String location;

    @ManyToOne
    private Company company;

}
