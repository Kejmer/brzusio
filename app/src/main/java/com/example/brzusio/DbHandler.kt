package com.example.brzusio

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.brzusio.Model.Song

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
        initSongs(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    private fun resultValueToString(result: Long?): String {
        if (result == (-1).toLong())
            return "Failed"
        return "Success"
    }

    private fun insertSong(db : SQLiteDatabase?, song: Song) : Long? {
        val cv = ContentValues()
        cv.put(COL_NAME, song.title)
        cv.put(COL_ARTIST, song.artist)
        return db?.insert(TABLE_NAME, null, cv)
    }

    private fun initSongs(db : SQLiteDatabase?) {
        insertSong(db, Song(0, "Skyfall", "Adele"))
        insertSong(db, Song(0, "W dobrą stronę", "Dawid Podsiadło"))
        insertSong(db, Song(0, "No pokaż na co cię stać", "Feel"))
        insertSong(db, Song(0, "To co nam było", "Red Lips"))
        insertSong(db, Song(0, "Chciałbym być sobą", "Perfect"))
        insertSong(db, Song(0, "Radio hello", "Enej"))
        insertSong(db, Song(0, "Póki na to czas", "De Mono"))
        insertSong(db, Song(0, "Idę na plażę", "Video"))
        insertSong(db, Song(0, "Jeden Moment", "Pectus"))
        insertSong(db, Song(0, "A ja wolę swoją mamę", "Majka Jeżowska"))
        insertSong(db, Song(0, "Californication", "Red Hot Chilli Peppers"))
        insertSong(db, Song(0, "I will survive", "Gloria Gaynor"))
        insertSong(db, Song(0, "Kiedyś cię znajdę", "Reni Jusis"))
        insertSong(db, Song(0, "Typ niepokorny", "Stachursky"))
    }

    private fun selectSongs(query : String) : MutableList<Song> {
        val list : MutableList<Song> = ArrayList()

        val db = this.readableDatabase
        val result = db.rawQuery(query, null)

        if (result.moveToFirst()) {
            do {
                val song = Song(
                    result.getInt(result.getColumnIndex(COL_ID)),
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

    fun randomSongs() : MutableList<Song> {
        return selectSongs("SELECT * FROM $TABLE_NAME ORDER BY RANDOM() LIMIT 10")
    }

    fun allSongs() : MutableList<Song> {
        return selectSongs("SELECT * FROM $TABLE_NAME ORDER BY artist COLLATE NOCASE ASC")
    }

    fun deleteSong(song: Song) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$COL_ID = ?", arrayOf(song.id.toString()))
        db.close()
    }

    fun addSong(song: Song) {
        val db = this.writableDatabase
        val result = insertSong(db, song)
        Toast.makeText(context, resultValueToString(result), Toast.LENGTH_SHORT).show()
        db.close()
    }
}