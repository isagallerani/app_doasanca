package com.example.bianca.doasanca
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_item_lista_locais.view.*


class LocaisAdapter(val context: Context, val locais: List<Local>)
    : RecyclerView.Adapter<LocaisAdapter.ViewHolder>()  {

    var clickListener: ((local:Local, index: Int) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_lista_locais, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return locais.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context,locais[position],clickListener)
    }

    fun setOnItemClickListener(clique: ((local:Local, index: Int) -> Unit)){
        this.clickListener = clique
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context:Context, local:Local, clickListener: ((local:Local, index: Int) -> Unit)?) {
            itemView.tvNome.text = local.nome_local

            if(clickListener != null) {
                itemView.setOnClickListener {
                    clickListener.invoke(local, adapterPosition)
                }
            }
        }




    }
}