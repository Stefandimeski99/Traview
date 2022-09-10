package com.traview.Service.Implementation;

import com.traview.Model.Commands.ReviewCommand;
import com.traview.Model.Dtos.ReviewDto;
import com.traview.Model.Entities.Review;
import com.traview.Repository.ReviewRepository;
import com.traview.Service.ReviewService;
import com.traview.Utils.ObjectMapperUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Page<Review>> getReviews(Pageable pageable) {
        return Optional.of(this.reviewRepository.findAll(pageable));
    }

    @Override
    public ReviewDto insertReview(ReviewCommand reviewCommand) {
        Review reviewEntity = this.reviewRepository.save(ObjectMapperUtils.map(reviewCommand, Review.class));
        return ObjectMapperUtils.map(reviewEntity, ReviewDto.class);
    }
}
