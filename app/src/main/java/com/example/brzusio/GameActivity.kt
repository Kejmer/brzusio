package com.example.brzusio

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class GameActivity : AppCompatActivity() {

    private var songList : MutableList<Song> = ArrayList()
    private var roundNo : Int = 0

    private fun isLast() : Boolean {
        return roundNo >= songList.size
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

    }

    private fun displayEndScreen() {

    }

    private fun correctAnswer() {
        songList[roundNo].guessed_correctly()
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
        var db = DbHandler(context)

        this.songList = db.randomSongs()

        findViewById<Button>(R.id.correct_button).setOnClickListener {
            correctAnswer()
        }

        findViewById<Button>(R.id.skip_button).setOnClickListener {
            nextSong()
        }

//        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
    }

}