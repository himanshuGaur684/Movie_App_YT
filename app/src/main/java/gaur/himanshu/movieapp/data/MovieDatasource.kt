package gaur.himanshu.movieapp.data

import gaur.himanshu.movieapp.network.ApiService

class MovieDatasource(private val apiService: ApiService) {

    suspend fun getMovieList()= apiService.getMovieList(apiKey = "")

    suspend fun getMovieDetails(id:String) = apiService.getMovieDetails(id, apiKey = "")

}