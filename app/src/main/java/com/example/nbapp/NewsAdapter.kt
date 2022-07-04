package com.example.nbapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val products: ArrayList<News>,
                  private val context: Context)
    : RecyclerView.Adapter<NewsAdapter.CustomViewHolder>() {


    class CustomViewHolder(val view: ViewGroup)
        : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.newsview, parent, false) as ViewGroup
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val product = products[position]

        val title = holder.view.findViewById<TextView>(R.id.notizia)
        title.text = product.title
        val image = holder.view.findViewById<ImageView>(R.id.immagineNotizia)
        image.setImageDrawable(ContextCompat.getDrawable(context,product.image))
        val editor = holder.view.findViewById<TextView>(R.id.editore)
        editor.text = product.editor



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