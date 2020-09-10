package com.example.brzusio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.brzusio.Model.Song
import kotlinx.android.synthetic.main.fragment_second.*

class RemoveSongsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = DbHandler(requireContext())
        val listView = view.findViewById<ListView>(R.id.listView)
        val list = db.allSongs()
        listView.adapter = SongAdapter(requireContext(), R.layout.song_item, list)

        listView.setOnItemClickListener { _ : AdapterView<*>, _: View, position : Int, _ : Long ->
            db.deleteSong(list[position])
        }

    }
}