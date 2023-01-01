package gaur.himanshu.movieapp.network

import gaur.himanshu.movieapp.model.Movie
import gaur.himanshu.movieapp.model.MovieListResponse
import gaur.himanshu.movieapp.model.details.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    // https://api.themoviedb.org/3/movie/popular?api_key=%3Capi_key%3E

    // https://api.themoviedb.org/3/movie/76600?api_key=

    @GET("3/movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey:String
    ):MovieListResponse

    @GET("3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id:String,
        @Query("api_key") apiKey: String
    ):MovieDetails

}