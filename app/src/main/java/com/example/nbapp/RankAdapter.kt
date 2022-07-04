package com.example.nbapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RankAdapter(private val products: ArrayList<Rank>,
                  private val context: Context)
    : RecyclerView.Adapter<RankAdapter.CustomViewHolder>() {


    class CustomViewHolder(val view: ViewGroup)
        : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rankview, parent, false) as ViewGroup
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val product = products[position]

        val squadraW = holder.view.findViewById<TextView>(R.id.squadraW)
        squadraW.text = product.squadraW
        val stemmaW = holder.view.findViewById<ImageView>(R.id.stemmaW)
        stemmaW.setImageDrawable(ContextCompat.getDrawable(context,product.stemmaW))
        val squadraE = holder.view.findViewById<TextView>(R.id.squadraE)
        squadraE.text = product.squadraE
        val stemmaE = holder.view.findViewById<ImageView>(R.id.stemmaE)
        stemmaE.setImageDrawable(ContextCompat.getDrawable(context,product.stemmaE))



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