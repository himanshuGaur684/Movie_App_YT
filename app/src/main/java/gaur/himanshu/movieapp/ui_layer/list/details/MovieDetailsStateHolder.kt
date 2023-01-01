package gaur.himanshu.movieapp.ui_layer.list.details

import gaur.himanshu.movieapp.model.details.MovieDetails

data class MovieDetailsStateHolder(
    val isLoading:Boolean= false,
    val data:MovieDetails?=null,
    val error:String=""
)
