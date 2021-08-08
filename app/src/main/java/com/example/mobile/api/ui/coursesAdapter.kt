package com.example.mobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class coursesAdapter(var courseList:List<Courses>):RecyclerView.Adapter<CoursesViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
       var itemView=LayoutInflater.from(parent.context).inflate(R.layout.courses_list_item,parent,false)
        return CoursesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        var currentcourse=courseList.get(position)
        holder.tvcoursename.text=currentcourse.courseName
        holder.tvdescription.text=currentcourse.description
        holder.tvinstructor.text=currentcourse.instructor
        holder.tvcode.text=currentcourse.courseCode
    }

    override fun getItemCount(): Int {
       return courseList.size
    }
}
class CoursesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvcoursename=itemView.findViewById<TextView>(R.id.tvcoursename)
    var tvdescription=itemView.findViewById<TextView>(R.id.tvdescription)
    var tvinstructor=itemView.findViewById<TextView>(R.id.tvinstructor)
    var tvcode=itemView.findViewById<TextView>(R.id.tvcode)
//    var name=itemView.findViewById<TextInputLayout>(R.id.etName)
//    var email=itemView.findViewById<TextInputLayout>(R.id.etEmail)




}