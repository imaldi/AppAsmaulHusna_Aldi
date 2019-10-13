package com.aim2u.submissionbeginnerdicodingaldi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ListAsmaulHusnaAdapter (val listAsmaulHusna: ArrayList<AsmaulHusna>) : RecyclerView.Adapter<ListAsmaulHusnaAdapter.ListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_asmaul_husna,parent,false)
        return  ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listAsmaulHusna.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama, arti, photo, arab) = listAsmaulHusna[position]

        holder.tvArab.text = arab
        holder.tvNama.text = nama
        holder.tvArti.text = arti

        holder.cardView.setOnClickListener {
            var intent =Intent(holder.context,DetailAsmaulHusnaActivity::class.java)
            intent.putExtra("nama",listAsmaulHusna[position].nama)
            intent.putExtra("img_url",listAsmaulHusna[position].photo)
            intent.putExtra("detail",listAsmaulHusna[position].detail)
            holder.context.startActivity(intent)
        }
        //if (position % 2 ==0){
        //    //holder.tvArab.setBackgroundResource(R.color.colorPrimary)
        //    holder.relativeLayout.setBackgroundResource(R.color.colorPrimaryDark)
        //} else {
        //    //holder.tvArab.setBackgroundResource(R.color.colorPrimaryDark)
        //    holder.relativeLayout.setBackgroundResource(R.color.colorPrimary)
        //}
    }
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvNama: TextView = itemView.findViewById(R.id.tv_asmaul_husna)
        var tvArti: TextView = itemView.findViewById(R.id.tv_arti_nama)
        var tvArab: TextView = itemView.findViewById(R.id.tv_arabic)
        //var relativeLayout: RelativeLayout = itemView.findViewById(R.id.rvLayout)
        var cardView: CardView = itemView.findViewById(R.id.rvLayout)
        var linearLayout: LinearLayout = itemView.findViewById(R.id.linearLay)
        val context: Context = itemView.context
    }

}