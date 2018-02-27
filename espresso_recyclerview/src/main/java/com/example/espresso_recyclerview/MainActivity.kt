package com.example.espresso_recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import com.example.espresso_recyclerview.MyRecyclerViewAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        recycler_view.adapter= MyRecyclerViewAdapter(getDummyObjects())
        recycler_view.layoutManager=LinearLayoutManager(this)
    }

    private fun getDummyObjects(): List<ModelClass> {
        var list:ArrayList<ModelClass> = ArrayList<ModelClass>()
        for(i in 1..10){
           list.add(ModelClass("Model no:"+i))
        }
        return list
    }

}

class MyRecyclerViewAdapter(var objects: List<ModelClass> = ArrayList<ModelClass>()) :
        RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textview.setText(objects[position].name)

    }

    override fun getItemCount(): Int {
        return objects.size
    }

    fun getItem(position: Int): ModelClass {
        return objects[position]
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textview: TextView
        init {
            textview=itemView.findViewById(R.id.row_textView)
        }
    }
}
