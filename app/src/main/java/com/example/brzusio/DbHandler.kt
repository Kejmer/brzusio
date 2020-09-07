package com.example.brzusio

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

const val DATABASE_NAME = "brzusioDB"
const val TABLE_NAME = "songs"
const val COL_ID = "id"
const val COL_NAME = "title"
const val COL_ARTIST = "artist"

class DbHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " VARCHAR(256), " +
                COL_ARTIST + " VARCHAR(256))";
        db?.execSQL(createTable)
        initSongs()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP IF TABLE EXISTS $TABLE_NAME")
        onCreate(db)
    }

    private fun resultValueToString(result: Long): String {
        if (result == (-1).toLong())
            return "Failed"
        return "Success"
    }

    fun insertSong(song: Song) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAME, song.title)
        cv.put(COL_ARTIST, song.artist)
        val result = db.insert(TABLE_NAME, null, cv)
        Toast.makeText(context, resultValueToString(result), Toast.LENGTH_SHORT).show()
    }

    private fun initSongs() {
        insertSong(Song(0, "Skyfall", "Adele"))
        insertSong(Song(0, "W dobrą stronę", "Dawid Podsiadło"))
        insertSong(Song(0, "No pokaż na co cię stać", "Feel"))
        insertSong(Song(0, "To co nam było", "Red Lips"))
        insertSong(Song(0, "Chciałbym być sobą", "Perfect"))
        insertSong(Song(0, "Radio hello", "Enej"))
        insertSong(Song(0, "Póki na to czas", "De Mono"))
        insertSong(Song(0, "Idę na plażę", "Video"))
        insertSong(Song(0, "Jeden Moment", "Pectus"))
        insertSong(Song(0, "A ja wolę swoją mamę", "Majka Jeżowska"))
        insertSong(Song(0, "Californication", "Red Hot Chilli Peppers"))
        insertSong(Song(0, "I will survive", "Gloria Gaynor"))
        insertSong(Song(0, "Kiedyś cię znajdę", "Reni Jusis"))
        insertSong(Song(0, "Typ niepokorny", "Stachursky"))
    }

    fun randomSongs() : MutableList<Song> {
        val list : MutableList<Song> = ArrayList()

        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME ORDER BY RANDOM() LIMIT 10"
        val result = db.rawQuery(query, null)

        if (result.moveToFirst()) {
            do {
                val song = Song(
                    result.getString(result.getColumnIndex(COL_ID)).toInt(),
                    result.getString(result.getColumnIndex(COL_NAME)),
                    result.getString(result.getColumnIndex(COL_ARTIST))
                );
                list.add(song)
            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun deleteSong(song: Song) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$COL_ID = ?", arrayOf(song.id.toString()))
        db.close()
    }
}