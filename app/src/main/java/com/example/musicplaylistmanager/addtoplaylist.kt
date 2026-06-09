package com.example.musicplaylistmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicplaylistmanager.ui.theme.MusicPlaylistManagerTheme



class addtoplaylist : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicPlaylistManagerTheme {

                var screen  by remember { mutableStateOf("add to playlist") }
                var songTittle by remember { mutableStateOf("") }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (screen == "add to playlist") {
                        Text(
                            text = "Enter Song Details",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(48.dp))
                        Button(
                            onClick = { screen = "Playlist" },
                            modifier = Modifier.height(80.dp).width(300.dp)
                        ) {
                            Text("Song tittle", fontSize = 34.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(48.dp))
                    Button(
                        onClick = { screen = "playlist" },
                        modifier = Modifier.height(80.dp).width(300.dp)
                    ) {
                        Text("Artist Name", fontSize = 34.sp)
                    }
                    Spacer(modifier = Modifier.height(48.dp))
                    Button(
                        onClick = { screen = "playlist" },
                        modifier = Modifier.height(80.dp).width(300.dp)
                    ) {
                        Text("Rating", fontSize = 34.sp)
                    }
                    if (screen == "review") {
                        Text(
                            text = "Review",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(24.dp))

                        if (screen == "review") {

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()
                            ) {

                                Text("Song Title: The Promiseland")
                                Spacer(modifier = Modifier.height(10.dp))

                                Text("Artist Name: A-Reece")
                                Spacer(modifier = Modifier.height(10.dp))

                                Text("Rating: 5")
                            }
                        }

                    }
                }
            }
        }
    }
}
