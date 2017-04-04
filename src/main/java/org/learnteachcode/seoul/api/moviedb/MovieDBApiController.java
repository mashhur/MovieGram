package org.learnteachcode.seoul.api.moviedb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mashhur on 4/4/17.
 */

@RequestMapping("/moviedb/api")
@RestController
public class MovieDBApiController {

    /* The movie DB
    // Please visit http://www.omdbapi.com/ for more info
    */
    // base API url of movie database
    private final String THEMOVIE_API_URL = "https://api.themoviedb.org/3/"; // 3rd version

    // a key
    private final String THEMOVIE_API_KEY = "api_key=6ee9ac55f15c253301af94c390c30c23";
    private final String THEMOVIE_API_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2ZWU5YWM1NWYxNWMyNTMzMDFhZjk0YzM5MGMzMGMyMyIsInN1YiI6IjU4ZTM1Yjg1OTI1MTQxMjdlYzAxZGMyYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9xJ0imNR0tm0_B9GQVYRtD9KeLT_u7arckN-v06iMls";

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieDBApiController.class);

    @RequestMapping("/getMovieInfo")
    String getMovieInfoByTitle(@RequestParam(value = "title", required = false) String movieTitle) {
        LOGGER.debug("Request with movie title -> ", movieTitle);
        return movieTitle;
    }

    @RequestMapping(value = "/discover", method = RequestMethod.GET)
    String discover(@RequestParam(value = "type", required = false) String type) {
        LOGGER.debug("Request with movie type -> ", type);

        final String uri = THEMOVIE_API_URL + "discover/movie?" + THEMOVIE_API_KEY;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri , String.class);
        return result;
    }
}
