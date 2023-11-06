package dev.mukarram.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /*This will create a review. We will first look for the movie with the given
    * imdbId, and then we will create a new review and then associate it with that
    * movie.*/
    public Review createReview(String reviewBody, String imdbId){

        /*Creation of a review*/
        Review review = new Review(reviewBody);

        /*Adding the review to the database*/
        reviewRepository.insert(review);

        /*Associating the review to the movie. First, we would need a template that is
        * at line 12. Repositories are a way to talk to the database but, a template
        * is another way to talk to the database because sometimes the repositories just
        * don't cut it. i.e, if the operation is too complex.
        * You can those these templates to form a new dynamic query that will do
        * some work in the database without using the repository.
        *
        * In the context of MongoDB, this means that it will find the first document
        * in the Movie collection where the imdbId matches the provided value
        * (imdbId). It will then add the review to the reviewIds array in that document.
        * */
        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId")
                        .is(imdbId))
                        .apply(new Update().push("reviewIds").value(review))
                        .first();

        return review;

    }

}
