package com.example.jobapplicationproject.Reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies/{id}")
public class ReviewsController {

    ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Reviews>> getAllReviews(@PathVariable Long id){
      return ResponseEntity.ok(reviewsService.getAllReviews(id));
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> postReview(@RequestBody Reviews reviews){
        reviewsService.createReview(reviews);
        return new ResponseEntity<>("Review Added Succesfully",HttpStatus.OK);
    }
    @DeleteMapping("/reviews/{ids}")
    public ResponseEntity<String> deleleReview(@PathVariable Long id){
        reviewsService.deleteReview(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @PutMapping("/reviews/{ids}")
    public ResponseEntity<String> updateReviews(@PathVariable Long id, @RequestBody Reviews reviews){

        reviewsService.updateReview(id,reviews);
        return new ResponseEntity<>("updated",HttpStatus.OK);

    }



}
