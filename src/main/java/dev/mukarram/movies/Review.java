package dev.mukarram.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    private ObjectId id; /*Ids are auto generated so we cannot pass this to the service class*/
    private String body;

    /*Custom constructor that takes only the body i.e, the review body.*/
    public Review(String body) {
        this.body = body;
    }
}
