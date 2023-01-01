package gaur.himanshu.movieapp.ui_layer.list.list

import gaur.himanshu.movieapp.model.Movie

data class MovieStateHolder(
    val isLoading: Boolean = false,
    val data: List<Movie>? = null,
    val error: String = ""
)
