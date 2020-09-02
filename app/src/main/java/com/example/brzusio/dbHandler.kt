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

class dbHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " VARCHAR(256), " +
                COL_ARTIST + " INTEGER)";
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    private fun resultValueToString(result: Long): String {
        if (result == (-1).toLong())
            return "Failed"
        return "Success"
    }

    fun insertSong(song: Song) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, song.title)
        cv.put(COL_ARTIST, song.artist)
        var result = db.insert(TABLE_NAME, null, cv)
        Toast.makeText(context, resultValueToString(result), Toast.LENGTH_SHORT).show()
    }

    fun randomSongs() : MutableList<Song> {
        val list : MutableList<Song> = ArrayList()

        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME ORDER BY RANDOM() LIMIT 10"
        val result = db.rawQuery(query, null)

        if (result.moveToFirst()) {
            do {
                var song = Song(
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
        db.delete(TABLE_NAME, COL_ID + " = " + song.id)
        db.close()
    }
}