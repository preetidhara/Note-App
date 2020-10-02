package com.example.uisample.Fragment

import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.uisample.R
import com.example.uisample.data.DailyModel
import kotlinx.android.synthetic.main.card_row.view.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private var userlist= emptyList<DailyModel>()

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_row, parent, false))
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        val currentItem=userlist[position]
        holder.itemView.title_txt.text=currentItem.title
        holder.itemView.description_txt.text=currentItem.description


        holder.itemView.rowItem.setOnClickListener(){
            val action=ListFragmentDirections.actionListFragmentToUpdateFragemnt(currentItem)
            holder.itemView.findNavController().navigate(action)


        }
    }

    override fun getItemCount(): Int {
            return userlist.size
    }

    fun setData(user:List<DailyModel>){
        this.userlist=user
        notifyDataSetChanged()
    }

}