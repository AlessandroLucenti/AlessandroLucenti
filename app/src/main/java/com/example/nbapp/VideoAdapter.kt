package com.example.nbapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter(private val products: ArrayList<Video>,
                   private val context: Context)
    : RecyclerView.Adapter<VideoAdapter.CustomViewHolder>() {


    class CustomViewHolder(val view: ViewGroup)
        : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.videoview, parent, false) as ViewGroup
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val product = products[position]

        val title = holder.view.findViewById<TextView>(R.id.HightlightdTitle)
        title.text = product.title
        val video = holder.view.findViewById<WebView>(R.id.HighlightsVideo)

        val frameVideo =
            "<html><body><iframe width=\"100%\" height=\"100%\" src=\"${product.video}\" frameborder=\"0\" allowfullscreen></iframe></body></html>"


        video.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return false
            }
        }
        val webSettings = video.settings
        webSettings.javaScriptEnabled = true
        video.loadData(frameVideo, "text/html", "utf-8")




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