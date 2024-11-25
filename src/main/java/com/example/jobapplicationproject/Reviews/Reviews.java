package com.example.jobapplicationproject.Reviews;

import com.example.jobapplicationproject.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    private String title;
    private String description;
    private Double rating;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "company_id") // Maps the foreign key column in the reviews table
    private Company company;
}
