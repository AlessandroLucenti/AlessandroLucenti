package com.example.nbapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HighlightsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */




class HighlightsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val frameVideo =
            "<html><body>Video From YouTube<br><iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/EIw1w0Wu_V0\" frameborder=\"0\" allowfullscreen></iframe></body></html>"

        val displayYoutubeVideo = view.findViewById(R.id.webView) as WebView
        displayYoutubeVideo.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return false
            }
        }
        val webSettings = displayYoutubeVideo.settings
        webSettings.javaScriptEnabled = true
        displayYoutubeVideo.loadData(frameVideo, "text/html", "utf-8")
    }

    }


