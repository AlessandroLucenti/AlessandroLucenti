package com.example.nbapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MarketAdapter(private val products: ArrayList<Market>,
                    private val context: Context)
    : RecyclerView.Adapter<MarketAdapter.CustomViewHolder>() {


    class CustomViewHolder(val view: ViewGroup)
        : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.marketview, parent, false) as ViewGroup
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val product = products[position]

        val giocatore = holder.view.findViewById<ImageView>(R.id.Giocatore)
        giocatore.setImageDrawable(ContextCompat.getDrawable(context,product.giocatore))
        val nome = holder.view.findViewById<TextView>(R.id.nomeGiocatore)
        nome.text = product.nome
        val ruolo = holder.view.findViewById<TextView>(R.id.RuoloGiocatore)
        ruolo.text = product.ruolo
        val stemmaPrec = holder.view.findViewById<ImageView>(R.id.scudetto_prima)
        stemmaPrec.setImageDrawable(ContextCompat.getDrawable(context,product.stemmaPrec))
        val stemmaSucc = holder.view.findViewById<ImageView>(R.id.scudetto_dopo)
        stemmaSucc.setImageDrawable(ContextCompat.getDrawable(context,product.stemmaSucc))
        val nomeSquadPrec = holder.view.findViewById<TextView>(R.id.NomeSecondaSquadra)
        nomeSquadPrec.text = product.nomeSquadPrec
        val nomeSquadSucc = holder.view.findViewById<TextView>(R.id.NomePrimaSquadra)
        nomeSquadSucc.text = product.nomeSquadSucc



        holder.view.setOnClickListener {
            /*val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("name", product.name)
            context.startActivity(intent)*/
            mListener?.selectItem(position)
        }
    }

    override fun getItemCount() = products.size

    /*
     *
     *       Callback
     *
     * */
    interface AdapterCallback {
        fun selectItem(position: Int)
    }
    private var mListener: AdapterCallback? = null

    fun setOnCallback(mItemClickListener: AdapterCallback) {
        this.mListener = mItemClickListener
    }
}