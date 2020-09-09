package com.example.brzusio

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.brzusio.Model.Song
import kotlinx.android.synthetic.main.final_score.*

class GameActivity : AppCompatActivity() {

    private var songList : MutableList<Song> = ArrayList()
    private var roundNo : Int = 0
    private var guessed : Int = 0

    private fun setTitle(name : String) {
        findViewById<TextView>(R.id.song_name).text = name
    }

    private fun setArtist(name : String) {
        findViewById<TextView>(R.id.song_artist).text = name
    }

    private fun currentSong() : Song {
        return songList[roundNo]
    }

    private fun isLast() : Boolean {
        return roundNo >= songList.size - 1
    }

    private fun nextSong() {
        if (isLast()) {
            displayEndScreen()
        } else {
            roundNo++
            displayCurrent()
        }
    }

    private fun displayCurrent() {
        setTitle(currentSong().title)
        setArtist(currentSong().artist)
    }

    private fun displayEndScreen() {
        setContentView(R.layout.final_score)

        val guessedList = arrayOfNulls<String>(guessed)
        val skippedList = arrayOfNulls<String>(songList.size - guessed)
        var guessIter = 0
        var skipIter = 0
        for (i in 0 until songList.size) {
            if (songList[i].correct) {
                guessedList[guessIter] = songList[i].title
                guessIter += 1
            } else {
                skippedList[skipIter] = songList[i].title
                skipIter += 1
            }
        }

        val guessAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, guessedList)
        val skipAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, skippedList)
        findViewById<ListView>(R.id.good_songs).adapter = guessAdapter
        findViewById<ListView>(R.id.skipped_songs).adapter = skipAdapter
    }

    private fun correctAnswer() {
        currentSong().guessed_correctly()
        guessed += 1
        nextSong()
    }

    private fun currentRound() : String {
        val roundAdjusted = roundNo + 1
        val totalRounds = songList.size
        return "$roundAdjusted / $totalRounds"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val context = this
        val db = DbHandler(context)
        this.songList = db.randomSongs()

        displayCurrent()

        findViewById<Button>(R.id.correct_button).setOnClickListener {
            correctAnswer()
        }

        findViewById<Button>(R.id.skip_button).setOnClickListener {
            nextSong()
        }
    }
}