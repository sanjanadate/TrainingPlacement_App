package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import database.AppDatabase
import database.CompanyDetails
import database.StudentDetails
import kotlinx.coroutines.launch

class StudentRegistration : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_student_registration, container, false)
        val sButton : Button = view.findViewById(R.id.button_save)
        sButton.setOnClickListener {

            val studentName = view.findViewById<EditText>(R.id.student_name).text.toString().trim()
            val rollNo = view.findViewById<EditText>(R.id.input_rno).text.toString().trim()
            val cgpa = view.findViewById<EditText>(R.id.input_cgpa).text.toString().trim()
            val backlogs = view.findViewById<EditText>(R.id.input_backlogs).text.toString().trim()
            val stream = view.findViewById<EditText>(R.id.input_stream).text.toString().trim()

            val phoneNo = view.findViewById<EditText>(R.id.input_contactno).text.toString().trim()

            //validation
            if(studentName!=""&&rollNo!=""&&cgpa!=""&&backlogs!=""&&stream!=""&&phoneNo!="")
            {
                val obj = StudentDetails(studentName,rollNo.toInt(),cgpa.toFloat(),backlogs.toInt(),stream,phoneNo.toInt())
                launch {
                    context?.let()
                    {
                        println("h2")
                        AppDatabase(requireActivity()).getStudentDetailsDao().addStudentDetails(obj)
                        println("h3")
                        Toast.makeText(it,"Insert Successful", Toast.LENGTH_SHORT).show()

                    }

                }
            }
            else
            {
                Toast.makeText(context,"Details missing", Toast.LENGTH_SHORT).show()
            }


        }
        val cancelButton = view.findViewById<Button>(R.id.button_cancel)
        cancelButton.setOnClickListener {
            //nav graph command
        }
        return view
    }
}