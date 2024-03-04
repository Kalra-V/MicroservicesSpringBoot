package com.embarkx.reviewms.reviews.impl;


import com.embarkx.reviewms.reviews.Reviews;
import com.embarkx.reviewms.reviews.ReviewsRepository;
import com.embarkx.reviewms.reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {
    private ReviewsRepository reviewsRepository;

    public ReviewsServiceImpl(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    @Override
    public List<Reviews> getAllReviews(Long companyId) {
        List<Reviews> reviews = reviewsRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Reviews review) {
        if (companyId != null && review != null) {
            review.setCompanyId(companyId);
            reviewsRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Reviews getReview(Long reviewId) {
        return reviewsRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Reviews updatedReview) {
        Reviews review = reviewsRepository.findById(reviewId).orElse(null);
        if(review != null){
            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setCompanyId(updatedReview.getCompanyId());
            reviewsRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Reviews review = reviewsRepository.findById(reviewId).orElse(null);
        if (review != null) {
            reviewsRepository.delete(review);
            return true;
        }
        return false;
    }
}
