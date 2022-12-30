package gaur.himanshu.movieapp.data

import gaur.himanshu.movieapp.network.ApiService

class MovieDatasource(private val apiService: ApiService) {

    suspend fun getMovieList()= apiService.getMovieList(apiKey = "your_api_key")

}