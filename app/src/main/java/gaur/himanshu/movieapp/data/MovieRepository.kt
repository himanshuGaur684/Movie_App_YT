package gaur.himanshu.movieapp.data

import gaur.himanshu.movieapp.common.Resource
import gaur.himanshu.movieapp.model.Movie

class MovieRepository(private val movieDatasource: MovieDatasource) {


    suspend fun getMovieList(): Resource<List<Movie>> {
        return try {
            Resource.Success(data = movieDatasource.getMovieList().results)
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }

}