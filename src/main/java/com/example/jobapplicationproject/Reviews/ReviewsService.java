package com.example.jobapplicationproject.Reviews;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewsService {


    void deleteReview(Long id);

    void createReview(Reviews reviews);

    List<Reviews> getAllReviews(Long CompanyId);

    boolean updateReview(Long id,Reviews reviews);

}
