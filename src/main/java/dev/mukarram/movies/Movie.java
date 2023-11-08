package dev.mukarram.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

/*This will let the framework know that this class represents
* each document in the movies collection.
* @Document is used to map a class to noSQL database
* (specifically mongoDB), it represents a MongoDB documents.
*
* @Data bundles the features of all those getters and setters, toStrings
* and requiredArgsConstructor together
*
* @AllArgsConstructor annotation that creates a constructor for all the
* private fields in our class as arguments
*
* @NoArgsConstructor annotation creates an empty constructor or
* a constructor with no arguments
*
* Now to use Movie class to pull some data from database we would need a
* service class and as well as a repository class*/
@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    /*This annotation will let the framework know that the below property
    * should be treated as the unique identifier of each movie inside the
    * databse.*/
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    /*this is an embedded relationship so all the reviews that are related to a movie
    * will be added to a list of reviews. This is a one-to-many relationship i.e, one
    * movie can have many reviews. This is completely fine as well
    *
    * But, since he is demonstrating features of Spring Boot MongoDB data then we will
    * use the below annotation. This annotation will cause the database to store
    * only the ids of the reviews and the reviews will be in a separate collection.
    * this is called manual reference relationships*/
    @DocumentReference
    private List<Review> reviewIds;

}
