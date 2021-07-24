    package com.example.mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class coursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        var rvcourses=findViewById<RecyclerView>(R.id.rvcourses)
        var courseList= listOf(
            Courses("mk100","NYJ","Introduction","wambui otieno"),
            Courses("MK200","KOTLIN","INTRO","WAFULA"),
            Courses("GFHFHG","python","backend","JANE"),
            Courses("kjki","javascript","fronted ","kamau")


        )
        var coursesAdapter=coursesAdapter(courseList)
        rvcourses.layoutManager=LinearLayoutManager(baseContext)
        rvcourses.adapter=coursesAdapter

    }
}