    package com.example.mobile.api.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.SyncStateContract
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile.R
import com.example.mobile.databinding.ActivityCoursesBinding
import com.example.mobile.viewmodel.Constants
import com.example.mobile.viewmodel.CoursesViewModel

    class coursesActivity : AppCompatActivity() {
        lateinit var binding: ActivityCoursesBinding
        val CourseViewModel: CoursesViewModel by viewModels()
        lateinit var sharedPreferences: SharedPreferences

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityCoursesBinding.inflate(layoutInflater)
            setContentView(R.layout.activity_courses)
            setContentView(binding.root)
            sharedPreferences = getSharedPreferences(Constants.SHAREDPRES, Context.MODE_PRIVATE)

        }

        override fun onResume() {
            val accessToken =
                SharedPreferences.getstring(Constants.ACCESSTOKEN, Constants.EMPTYSTRING)
            val bearer = "Bearer ${accessToken}"
            val studentIdIntent = intent.getStringExtra("STUDENT_ID")
            val courseIntent = intent.getStringExtra("courseId")
        }
    }


//            if (!accessToken!!.isEmpty()) {
//                enrol()
//                coursesViewModel.getCourses(bearer)
//                val enrolReq = EnrolmentRequest(
//                    student_id = studentIdIntent.toString(),
//                    course_id = courseIntent.toString()
//                )
//                enrolCourseViewModel.enrolCourse(bearer, enrolReq)
//            }
//
//            coursesViewModel.coursesLiveData.observe(this, { courseList ->
//                binding.rvCourses.adapter = CoursesRecyclerViewAdapter(courseList, baseContext)
//                binding.rvCourses.layoutManager = LinearLayoutManager(baseContext)
//                Toast.makeText(baseContext, "${courseList.size} courses", Toast.LENGTH_LONG).show()
//
//            })
//            coursesViewModel.coursesFailedLiveData.observe(this, { error ->
//                Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
//
//            })
//        }
























//            var rvcourses=findViewById<RecyclerView>(R.id.rvcourses)
//        var courseList= listOf(
//            Courses("mk100","NYJ","Introduction","wambui otieno"),
//            Courses("MK200","KOTLIN","INTRO","WAFULA"),
//            Courses("GFHFHG","python","backend","JANE"),
//            Courses("kjki","javascript","fronted ","kamau")
//
//
//        )
//        var coursesAdapter= coursesAdapter(courseList)
//        rvcourses.layoutManager=LinearLayoutManager(baseContext)
//        rvcourses.adapter=coursesAdapter
//
//    }