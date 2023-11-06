package dev.mukarram.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*Below will let the framework know that this is a repository and the data that
* we will be using is Movie and what type of id we will be dealing with (which will
* be the same as in the Movies class.)
*
* Now the problem is that we don't want to expose the ObjectId of the entities
 * to the public. The repository comes with built in methods for the ObjectId
 * but, we need it for ImdbId. So we'll have to implement it ourselves. its easy
 * since we have automatic queries*/
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findMovieByImdbId(String imdbid);
}

/*This is the data access layer for our API. IT does the job of actually talking
* to the database and getting the data back.*/
