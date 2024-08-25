package com.example.taskexam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskexam.databinding.ItemcardBinding

class TaskAdapter :RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){
    private val tasklist= arrayListOf<TaskModel>()
    lateinit var clickitem:(TaskModel)->Unit
    lateinit var deleteitem:(TaskModel)->Unit

    inner class TaskViewHolder(val itemcardBinding:ItemcardBinding):
        RecyclerView.ViewHolder(itemcardBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view=ItemcardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasklist.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task=tasklist[position]
        holder.itemcardBinding.imageView.setImageResource(task.image)
        holder.itemcardBinding.textView.text=task.task
        holder.itemcardBinding.imageView2.setOnClickListener{
            deleteitem(task)
        }
        holder.itemcardBinding.cardview.setOnClickListener{
            clickitem(task)
        }
    }
    fun updatelist(newlist :ArrayList<TaskModel>){
        tasklist.clear()
        tasklist.addAll(newlist)
        notifyDataSetChanged()
    }
}