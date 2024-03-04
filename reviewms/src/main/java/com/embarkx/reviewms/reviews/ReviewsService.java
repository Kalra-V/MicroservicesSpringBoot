package com.embarkx.reviewms.reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Reviews review);
    Reviews getReview(Long reviewId);
    boolean updateReview(Long reviewId, Reviews updatedReview);
    boolean deleteReview(Long reviewId);
}
