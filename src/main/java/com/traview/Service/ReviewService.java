package com.traview.Service;

import com.traview.Model.Commands.ReviewCommand;
import com.traview.Model.Dtos.ReviewDto;
import java.util.List;

public interface ReviewService {
    List<ReviewDto> getReviews();
    ReviewDto insertReview(ReviewCommand reviewCommand);
}
