package gaur.himanshu.movieapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gaur.himanshu.movieapp.data.MovieDatasource
import gaur.himanshu.movieapp.data.MovieRepository
import gaur.himanshu.movieapp.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideDataSource(apiService: ApiService): MovieDatasource {
        return MovieDatasource(apiService)
    }

    @Provides
    fun provideMovieRepo(datasource: MovieDatasource):MovieRepository{
        return MovieRepository(datasource)
    }


}
