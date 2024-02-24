package com.example.demoretrofit.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.demoretrofit.R

class MyAdapter(val context: Context, val layoutId: Int, val list: List<com.example.demoretrofit.Model.Result>): BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var viewHolder: MyViewHolder?
        var view: View

        if(convertView == null) {
            view = LayoutInflater.from(context).inflate(layoutId, null)
            viewHolder = MyViewHolder(view)
            view.setTag(viewHolder)
        } else {
            view = convertView
            viewHolder = view.tag as MyViewHolder
        }

        viewHolder.txtName.text = list.get(position).name.title +
                list.get(position).name.first + list.get(position).name.last

        viewHolder.txtGender.text = list.get(position).gender
        viewHolder.txtLocation.text =
            list.get(position).location.street.number.toString() + list.get(position).location.street.name

        return view
    }

    inner class MyViewHolder(view: View) {
        lateinit var txtName: TextView
        lateinit var txtGender: TextView
        lateinit var txtLocation: TextView

        init {
            txtName = view.findViewById(R.id.txtName)
            txtGender = view.findViewById(R.id.txtGender)
            txtLocation = view.findViewById(R.id.txtLocation)
        }
    }
}