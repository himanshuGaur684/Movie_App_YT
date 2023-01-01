package gaur.himanshu.movieapp.data

import gaur.himanshu.movieapp.common.Resource
import gaur.himanshu.movieapp.model.Movie
import gaur.himanshu.movieapp.model.details.MovieDetails

class MovieRepository(private val movieDatasource: MovieDatasource) {


    suspend fun getMovieList(): Resource<List<Movie>> {
        return try {
            Resource.Success(data = movieDatasource.getMovieList().results)
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }

    suspend fun getMovieDetails(id:String):Resource<MovieDetails>{
        return try {
            Resource.Success(data = movieDatasource.getMovieDetails(id))
        }catch (e:Exception){
            Resource.Error(e.message.toString())
        }
    }

}