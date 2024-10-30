package com.example.jobapplicationproject;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Job {

    private Long id;
    private String title;
    private String description;
    private String minSalary;

    private String maxSalary;
    private String location;


}
