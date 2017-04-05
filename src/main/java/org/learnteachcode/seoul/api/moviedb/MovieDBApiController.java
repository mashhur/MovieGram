package org.learnteachcode.seoul.api.moviedb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mashhur on 4/4/17.
 */

@RequestMapping("/moviedb/api")
@RestController
public class MovieDBApiController {

    @Value("${themoviedb.api:}")
    private String api_url = "api";

    @Value("${themoviedb.key:}")
    private String api_key = "api_key";

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

        final String uri = api_url + "discover/movie?" + api_key;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri , String.class);
        return result;
    }
}