package com.traview.Web;

import com.traview.Model.Commands.ReviewCommand;
import com.traview.Service.ReviewService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity getAllReviews(Pageable pageable) {
        return this.reviewService.getReviews(pageable)
                .map(reviews -> ResponseEntity.ok(reviews))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity insertReview(@RequestBody ReviewCommand reviewCommand) {
        return ResponseEntity.ok(this.reviewService.insertReview(reviewCommand));
    }
}
