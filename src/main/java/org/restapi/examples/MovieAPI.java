package org.restapi.examples;

import org.restapi.model.MovieData;
import org.restapi.model.Response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.restapi.HttpUtil.convertJsonToObjectByGson;
import static org.restapi.HttpUtil.invoke;

/*** get a list of ordered all movie titles
The api url is "https://jsonmock.hackerrank.com/api/movies"
The api response is like
{
   "page":1,
   "per_page":10,
   "total":2770,
   "total_pages":277,
   "data":[
      {
         "Title":"Waterworld",
         "Year":1995,
         "imdbID":"tt0114898"
      },...
***/
public class MovieAPI extends HackerrankAPI{

    static class MovieResponse extends Response<MovieData> {}
    public MovieAPI(String url) {
        super(url);
    }

//    @Override
//    public String getResponse() {
//        return invoke(BASE_URL + "/movies?Title=The%20Walk");
//    }

    public List<String> getTitles() {
        String url = "/movies?page=%s";
        String firstPageResponseString = invoke(String.format(BASE_URL + url, 1));
        MovieResponse firstPageResponse = convertJsonToObjectByGson(firstPageResponseString, MovieResponse.class);
        int totalPages = firstPageResponse.getTotalPages();
        List<String> titles = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            String responseString = invoke(String.format(BASE_URL + url, i));
            MovieResponse response = convertJsonToObjectByGson(responseString, MovieResponse.class);
            List<String> titlesPerPage = response.getData().stream().map(MovieData::getTitle).toList();
            titles.addAll(titlesPerPage);
        }
        //Collections.sort(titles);
        titles = titles.stream().distinct().sorted().toList();
        return titles;
    }
}
