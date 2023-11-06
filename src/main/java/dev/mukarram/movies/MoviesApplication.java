package dev.mukarram.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}


}

/*
* 1. The first logical step is to configure the database so we can successfully connect
* to the MongoDB cluster and communicate with it. So go to application.properties and
* configure MongoDB but, putting sensitive data like this into your github repository
* is not safe at all. Instead, you should be putting this in the ".env" file.
* 		Resources -> New -> File -> ".env"
* 2. After this go to .gitignore file and ad the following
*
* 				### ENV Files ###
						".env"
* this will make sure that you don't accidentally commit the .env file in your repository
* and expose your database to the world.
*
* 3. Spring does not support reading .env files out of the box. For this we would need
* to install a new dependency to our project. In order to tackle this we will add the
* new dependency to our pom.xml file
*
* 4. After installing the new dependency, go to application.properties and write down the
* following code:
*
* spring.data.mongodb.database=${MONGO_DATABSE}
  spring.data.mongodb.uri=mongodb+srv://${env.MONGO_USER}:${env.MONGO_PASSWORD}@${MONGO_CLUSTER}
  *
  *
  * 5. Then we make the classes for the entities. In our case it was Movie and Review
  *
  * 6.
* */

