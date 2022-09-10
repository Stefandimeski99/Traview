package com.traview.Service;

import com.traview.Model.Commands.ReviewCommand;
import com.traview.Model.Dtos.ReviewDto;
import com.traview.Model.Entities.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReviewService {
    Optional<Page<Review>> getReviews(Pageable pageable);
    ReviewDto insertReview(ReviewCommand reviewCommand);
}
