package com.example.brzusio

class Song(song_name: String, artist_name: String) {
    val title = song_name
    val artist = artist_name

    var correct : Boolean

    init {
        correct = false;
    }

    fun guessed_correctly() {
        correct = true;
    }
}
