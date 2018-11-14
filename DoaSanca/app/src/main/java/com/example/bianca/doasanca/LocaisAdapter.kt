package com.example.bianca.doasanca
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_item_lista_locais.view.*


class LocaisAdapter(val locais: List<String>)
    : RecyclerView.Adapter<LocaisAdapter.ViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_lista_locais, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return locais.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(locais[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(localNome: String) {
            itemView.tvNome.text = localNome
        }

    }
}