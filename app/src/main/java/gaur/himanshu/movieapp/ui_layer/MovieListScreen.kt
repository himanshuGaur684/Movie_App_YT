package gaur.himanshu.movieapp.ui_layer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import gaur.himanshu.movieapp.model.Movie

@Composable
fun MovieListScreen(viewModel: MovieViewModel = hiltViewModel()) {

    val result = viewModel.movieList.value

    if (result.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if (result.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = result.error)
        }
    }

    result.data?.let {
        LazyColumn {
            items(result.data) {
                MovieItem(it)
            }
        }
    }

}

@Composable
fun MovieItem(it: Movie) {
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500/${it.poster_path}", contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(vertical = 4.dp), contentScale = ContentScale.Crop
    )
}
