package com.example.nbapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NewsFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_news, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val products = ArrayList<News>()
        val news1 = News(title = "Highest Team Payrolls in NBA History", image = R.drawable.notizia1, editor = "bleacherreport")
        products.add(news1)
        val news2 = News(title = "KD’s Conditions for Heat Trade", image = R.drawable.notizia2, editor = "bleacherreport")
        products.add(news2)
        val news3 = News(title = "Winners & Losers from KD's Trade Request ", image = R.drawable.notizia3, editor = "bleacherreport")
        products.add(news3)
        val news4 = News(title = "Updated Free-Agency Big Board ", image = R.drawable.notizia4, editor = "bleacherreport")
        products.add(news4)

        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        val productAdapter = NewsAdapter(products, requireContext())
        recyclerView.apply {
            adapter = productAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

}