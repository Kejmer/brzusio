package com.example.brzusio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.brzusio.Model.Song

class SongAdapter (
    var ctx : Context,
    var resources : Int,
    var items : List<Song>
) : ArrayAdapter<Song>(ctx, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(ctx)
        val view : View = layoutInflater.inflate(resources, null)

        val imageView : ImageView = view.findViewById(R.id.image)
        val titleTextView : TextView = view.findViewById(R.id.song_name)
        val artistTextView : TextView = view.findViewById(R.id.song_artist)

        var song : Song = items[position]
        titleTextView.text = song.title
        artistTextView.text = song.artist

        return view
//        return super.getView(position, convertView, parent)
    }
}