package com.example.brzusio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.brzusio.Model.Song
import kotlinx.android.synthetic.main.fragment_second.*

class NewSongFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.add_song).setOnClickListener {
            if (name_input.text.toString().isNotEmpty()) {
                val song = Song(0, name_input.text.toString(), artist_input.text.toString())
                val db = DbHandler(requireContext())
                db.addSong(song)
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }
        }
    }
}