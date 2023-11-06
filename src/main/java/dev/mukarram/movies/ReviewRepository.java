package dev.mukarram.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*Repository are one of the ways to talk to the database
* Don't forget to annotate this as a repository*/
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
