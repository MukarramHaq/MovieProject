package dev.mukarram.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*This annotation will let the framework know that this will be a service layer.
* Inside this class we will write the database access methods.
*
* @Autowired will let the framework know that we want to instantiate the class
* MovieRepository and it will do it for us.
*
* the .findAll() method is described inside the MongoRepository class
* and it will return a list of a required data type. In our case, its
* Movie*/
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    /*This method has the possibility of returning a null value. So we use Optional
    * to return an Optional to indicate that the value may or may not be present.
    * So basically, if there exists an id then the Optional will store that value
    * if that id doesn't exist then Optional will store empty, and it will help us to
    * avoid a NullPointerException */
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }

}

/*This service class uses the repository and talkes to the database to get the movies
* and returns to the API layer.*/
