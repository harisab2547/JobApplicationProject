package com.example.jobapplicationproject.company;

import com.example.jobapplicationproject.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

   // private List<Review> reviews;



}
