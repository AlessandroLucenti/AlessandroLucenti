package com.example.nbapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MarketFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_market, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val products = ArrayList<Market>()
        val giocatore1 = Market(nome = "Mychal Murder", giocatore = R.drawable.mulder, ruolo = "bleacherreport", stemmaPrec = R.drawable.magic, stemmaSucc = R.drawable.heat, nomeSquadPrec = "Magic",  nomeSquadSucc = "Heat",)
        products.add(giocatore1)
        val giocatore2 = Market(nome = "Javonate Smart", giocatore = R.drawable.smart, ruolo = "bleacherreport", stemmaPrec = R.drawable.bucks,stemmaSucc = R.drawable.heat, nomeSquadPrec = "Bucks",  nomeSquadSucc = "Heat",)
        products.add(giocatore2)
        val giocatore3 = Market(nome = "Chris Silva", giocatore = R.drawable.silva, ruolo = "bleacherreport", stemmaPrec = R.drawable.timberwolves, stemmaSucc = R.drawable.heat,  nomeSquadPrec = "T'Wolves",  nomeSquadSucc = "Heat",)
        products.add(giocatore3)
        val giocatore4 = Market(nome = "Kyle Guy", giocatore = R.drawable.guy, ruolo = "bleacherreport", stemmaPrec = R.drawable.kings, stemmaSucc = R.drawable.heat,  nomeSquadPrec = "King",  nomeSquadSucc = "Heat",)
        products.add(giocatore4)

        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        val productAdapter = MarketAdapter(products, requireContext())
        recyclerView.apply {
            adapter = productAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
}