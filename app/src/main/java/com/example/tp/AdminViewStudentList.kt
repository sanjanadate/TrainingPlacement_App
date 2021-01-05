package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import database.AppDatabase
import kotlinx.coroutines.launch

class AdminViewStudentList : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_view_students, container, false)
        val ans = view.findViewById<TextView>(R.id.students_placed_label)
        launch {

            ans.text =
                AppDatabase(requireActivity()).getExperienceDao().getNoOfStudents().toString()
        }

        return view
    }
}