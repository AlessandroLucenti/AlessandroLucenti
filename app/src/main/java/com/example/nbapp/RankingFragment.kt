package com.example.nbapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RankingFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_ranking, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val products = ArrayList<Rank>()
        val s1 = Rank(squadraW = "Suns", stemmaW = R.drawable.suns, squadraE = "Heat", stemmaE = R.drawable.heat,)
        products.add(s1)
        val s2 = Rank(squadraW = "Grizzlies", stemmaW = R.drawable.grizzlies, squadraE = "Celtics", stemmaE = R.drawable.celtics,)
        products.add(s2)
        val s3 = Rank(squadraW = "Warriors", stemmaW = R.drawable.warriors, squadraE = "Bucks", stemmaE = R.drawable.bucks,)
        products.add(s3)
        val s4 = Rank(squadraW = "Mavericks" , stemmaW = R.drawable.mavericks, squadraE = "Sixers", stemmaE = R.drawable.phi76ers,)
        products.add(s4)
        val s5 = Rank(squadraW = "Jazz", stemmaW = R.drawable.jazz, squadraE = "Raptors", stemmaE = R.drawable.raptors,)
        products.add(s5)
        val s6 = Rank(squadraW = "Nuggets", stemmaW = R.drawable.nuggets, squadraE = "Bulls", stemmaE = R.drawable.bulls,)
        products.add(s6)
        val s7 = Rank(squadraW = "Timberwolves", stemmaW = R.drawable.timberwolves, squadraE = "Nets", stemmaE = R.drawable.nets,)
        products.add(s7)
        val s8 = Rank(squadraW = "Pelicans", stemmaW = R.drawable.pelicans, squadraE = "Hawks", stemmaE = R.drawable.hawks,)
        products.add(s8)
        val s9 = Rank(squadraW = "Clippers", stemmaW = R.drawable.clippers, squadraE = "Cavaliers", stemmaE = R.drawable.cavaliers,)
        products.add(s9)
        val s10 = Rank(squadraW = "Spurs", stemmaW = R.drawable.spurs, squadraE = "Hornets", stemmaE = R.drawable.hornets,)
        products.add(s10)
        val s11 = Rank(squadraW = "Lakers", stemmaW = R.drawable.lakers, squadraE = "Knicks", stemmaE = R.drawable.knicks,)
        products.add(s11)
        val s12 = Rank(squadraW = "Kings", stemmaW = R.drawable.kings, squadraE = "Wizards", stemmaE = R.drawable.wizards,)
        products.add(s12)
        val s13 = Rank(squadraW = "Blazers", stemmaW = R.drawable.blazers, squadraE = "Pacers", stemmaE = R.drawable.pacers,)
        products.add(s13)
        val s14 = Rank(squadraW = "Thunder", stemmaW = R.drawable.thunder, squadraE = "Pistons", stemmaE = R.drawable.pistons,)
        products.add(s14)
        val s15 = Rank(squadraW = "Rockets", stemmaW = R.drawable.rockets, squadraE = "Magic", stemmaE = R.drawable.magic,)
        products.add(s15)


        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        val productAdapter = RankAdapter(products, requireContext())
        recyclerView.apply {
            adapter = productAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
}