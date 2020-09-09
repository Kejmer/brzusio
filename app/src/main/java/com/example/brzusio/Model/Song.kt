package com.example.brzusio.Model

class Song(id: Int, title: String, artist: String) {
    var id : Int = id
    var title : String = title
    var artist : String = artist
    var correct : Boolean = false

    fun guessed_correctly() {
        correct = true;
    }
}
