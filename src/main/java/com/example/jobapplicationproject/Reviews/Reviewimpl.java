package com.example.jobapplicationproject.Reviews;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Reviewimpl implements ReviewsService {

    ReviewsRepository reviewsRepository;

    public Reviewimpl(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    @Override
    public void deleteReview(Long id) {
        reviewsRepository.deleteById(id);

    }

    @Override
    public void createReview(Reviews reviews) {
        reviewsRepository.save(reviews);
    }

    @Override
    public List<Reviews> getAllReviews(Long companyId) {
        List<Reviews> reviews =  reviewsRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean updateReview(Long id, Reviews updatedReview) {

        Optional<Reviews> reviewsOptional = reviewsRepository.findById(id);
        if (reviewsOptional.isPresent()){
            Reviews reviews = reviewsOptional.get();
            reviews.setId(updatedReview.getId());
            reviews.setDescription(updatedReview.getDescription());
            reviews.setTitle(updatedReview.getTitle());
            reviews.setRating(updatedReview.getRating());
            reviewsRepository.save(reviews);
            return true;
        }

        return false;
    }
}
