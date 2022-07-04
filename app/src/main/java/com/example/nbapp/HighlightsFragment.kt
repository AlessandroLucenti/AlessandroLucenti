package com.example.nbapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HighlightsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            }

        }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_highlights, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val products = ArrayList<Video>()
        val video1 = Video("Celtic vs Heats", video = "https://www.youtube.com/embed/EIw1w0Wu_V0")
        products.add(video1)

        val video2 = Video("Heat vs Hawks", video = "https://www.youtube.com/embed/lTM0K3DJ2io?start=15" )
        products.add(video2)

        val video3 = Video("Heat vs Sixers", video = "https://www.youtube.com/embed/Ln2F90hpv7E?start=15" )
        products.add(video3)

        val video4 = Video("Bulls vs Heats", video = "https://www.youtube.com/embed/cyMSgHEAoDc?start=5" )
        products.add(video4)

        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        val productAdapter = VideoAdapter(products, requireContext())
        recyclerView.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    }


