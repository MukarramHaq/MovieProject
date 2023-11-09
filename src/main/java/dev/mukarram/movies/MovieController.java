package dev.mukarram.movies;

import com.sun.net.httpserver.HttpsServer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    /*Although it is completely fine if you want to return a String but this is not
    * a good practice. It would be better to return a ResponseEntity.
    * ResponseEntity represents the whole HTTP response: status code, headers and
    * body. This can be used to fully configure the HTTP response.
    * This comes in handy when working with any front-end application and any REST
    * API out there should return proper status codes*/

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    /*This will take a parameter, and we will pass the id, so we are trying to search a
    * movie by its id.
    * Inside the function parentheses which lets the framework know that we'll be
    * using the information passed in the path variable as ObjectId id
    *
    * For example, if you have a URL like http://example.com/users/{id}, where {id}
    * represents a variable part that can be different for different requests, you
    * can use @PathVariable to extract the value of id from the URL.
    *
    *  In this example, when a GET request is made to a URL like
    *  http://example.com/users/123, Spring will automatically extract the value
    *  123 from the URI and pass it as the id parameter to the getUserById method.
    *
    * */
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }


    /*This is a rest API which will only concern itself with getting input for a user
    * and return the response and that is it. This class does that by using the service
    * class i.e, the MovieService class and delegating the task to it to fetch all the
    * movies from the database and giving it back to the API Layer*/

}
