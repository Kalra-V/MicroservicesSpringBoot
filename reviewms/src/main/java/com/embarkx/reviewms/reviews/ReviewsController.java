package com.embarkx.reviewms.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    private ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping
    public ResponseEntity<List<Reviews>> getAllReviews(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewsService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Reviews review){
            boolean isReviewSaved = reviewsService.addReview(companyId, review);
            if(isReviewSaved)
                return new ResponseEntity<>("Review added successfully.", HttpStatus.CREATED);
            else
                return new ResponseEntity<>("Review not saved.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Reviews> getReview(@PathVariable Long reviewId) {
            return new ResponseEntity<>(reviewsService.getReview(reviewId), HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,
                                               @RequestBody Reviews review) {
        boolean isReviewUpdated = reviewsService.updateReview(reviewId, review);
        if (isReviewUpdated)
            return new ResponseEntity<>("Review updated successfully.", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not updated.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
        boolean isReviewDeleted = reviewsService.deleteReview(reviewId);
        if (isReviewDeleted)
            return new ResponseEntity<>("Review deleted successfully.", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not deleted.", HttpStatus.NOT_FOUND);
    }
}
