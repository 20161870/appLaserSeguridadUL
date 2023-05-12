package com.example.firebasecompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MainScreen(viewModelScreen: ViewModelScreen = viewModel()) {
    val link : String by viewModelScreen.link.observeAsState("")
    viewModelScreen.downloadPhoto()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Sistema de Seguridad Laser",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp)
        )

        AsyncImage(
            model = link,
            contentDescription = "Foto",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(top = 12.dp)
                .align(Alignment.CenterHorizontally)
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = { viewModelScreen.downloadPhoto() },
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Actualizar Foto"
            )
        }
    }
}

/*
ALTERNATIVA
-----------
val imageFire = remember { mutableStateOf("") }
val imageReference = FirebaseStorage.getInstance().getReference("Photo").downloadUrl.addOnSuccessListener {
    imageFire.value = it.toString()
}.addOnFailureListener {
    //
}
AsyncImage(
            model = imageFire.value,
            contentDescription = null
        )
*/