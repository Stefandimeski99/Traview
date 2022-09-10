package com.traview.Service.Implementation;

import com.traview.Model.Commands.ReviewCommand;
import com.traview.Model.Dtos.ReviewDto;
import com.traview.Model.Entities.Review;
import com.traview.Repository.ReviewRepository;
import com.traview.Service.ReviewService;
import com.traview.Utils.ObjectMapperUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<ReviewDto> getReviews() {
        return ObjectMapperUtils.mapAll(this.reviewRepository.findAll(), ReviewDto.class);
    }

    @Override
    public ReviewDto insertReview(ReviewCommand reviewCommand) {
        Review reviewEntity = this.reviewRepository.save(ObjectMapperUtils.map(reviewCommand, Review.class));
        return ObjectMapperUtils.map(reviewEntity, ReviewDto.class);
    }
}
