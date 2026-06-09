package com.example.musicplaylistmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Song(
    val title: String,
    val artist: String,
    val rating: Int,
    val comments: String
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var screen by remember { mutableStateOf("home") }

            var songTitle by remember { mutableStateOf("") }
            var artistName by remember { mutableStateOf("") }
            var rating by remember { mutableStateOf("") }
            var comments by remember { mutableStateOf("") }

            val songs = remember { mutableStateListOf<Song>() }

            Surface(
                modifier = Modifier.fillMaxSize()
            ) {

                when (screen) {


                    "home" -> {

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            Text(
                                text = "Welcome to Music Playlist Manager",
                                fontSize = 28.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Button(
                                onClick = { screen = "playlist" },
                                modifier = Modifier.width(220.dp)
                            ) {
                                Text("Add to Playlist")
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = { screen = "details" },
                                modifier = Modifier.width(220.dp)
                            ) {
                                Text("Display List")
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = { finish() },
                                modifier = Modifier.width(220.dp)
                            ) {
                                Text("Exit")
                            }
                        }
                    }


                    "playlist" -> {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "Enter Song Details",
                                fontSize = 24.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            OutlinedTextField(
                                value = songTitle,
                                onValueChange = { songTitle = it },
                                label = { Text("Song Title") }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value = artistName,
                                onValueChange = { artistName = it },
                                label = { Text("Artist Name") }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value = rating,
                                onValueChange = { rating = it },
                                label = { Text("Rating (1-5)") }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value = comments,
                                onValueChange = { comments = it },
                                label = { Text("Comments") }
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Row {

                                Button(
                                    onClick = {

                                        val ratingValue = rating.toIntOrNull()

                                        if (
                                            songTitle.isNotBlank() &&
                                            artistName.isNotBlank() &&
                                            ratingValue != null &&
                                            ratingValue in 1..5
                                        ) {

                                            songs.add(
                                                Song(
                                                    title = songTitle,
                                                    artist = artistName,
                                                    rating = ratingValue,
                                                    comments = comments
                                                )
                                            )

                                            songTitle = ""
                                            artistName = ""
                                            rating = ""
                                            comments = ""
                                        }
                                    }
                                ) {
                                    Text("Save")
                                }

                                Spacer(modifier = Modifier.width(10.dp))

                                Button(
                                    onClick = { screen = "home" }
                                ) {
                                    Text("Home")
                                }
                            }
                        }
                    }


                    "details" -> {

                        val averageRating =
                            if (songs.isNotEmpty())
                                songs.map { it.rating }.average()
                            else
                                0.0

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {

                            Text(
                                text = "Display List",
                                fontSize = 24.sp
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            // TABLE HEADER
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(1.dp, Color.Black)
                                    .padding(8.dp)
                            ) {
                                Text("Title", modifier = Modifier.weight(1f))
                                Text("Artist", modifier = Modifier.weight(1f))
                                Text("Rating", modifier = Modifier.weight(1f))
                                Text("Comments", modifier = Modifier.weight(2f))
                            }

                            LazyColumn(
                                modifier = Modifier.weight(1f)
                            ) {

                                items(songs) { song ->

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .border(1.dp, Color.Gray)
                                            .padding(8.dp)
                                    ) {

                                        Text(
                                            text = song.title,
                                            modifier = Modifier.weight(1f)
                                        )

                                        Text(
                                            text = song.artist,
                                            modifier = Modifier.weight(1f)
                                        )

                                        Text(
                                            text = song.rating.toString(),
                                            modifier = Modifier.weight(1f)
                                        )

                                        Text(
                                            text = song.comments,
                                            modifier = Modifier.weight(2f)
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = "Average Rating: %.1f".format(averageRating),
                                fontSize = 20.sp
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Button(
                                onClick = { screen = "home" }
                            ) {
                                Text("Home")
                            }
                        }
                    }
                }
            }
        }
    }
}