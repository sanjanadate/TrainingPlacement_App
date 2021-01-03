package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class AdminDeleteCompany : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_delete_company, container, false)

        //cancel
        val cancel = view.findViewById<Button>(R.id.button_cancel)
        cancel.setOnClickListener {
            view.findNavController().navigate(R.id.action_adminDeleteCompany_to_adminDashboard)
            Toast.makeText(context, "Changes unsaved", Toast.LENGTH_LONG).show()
        }

        //delete
        val delete = view.findViewById<Button>(R.id.button_delete)
        delete.setOnClickListener {
            view.findNavController().navigate(R.id.action_adminDeleteCompany_to_adminDashboard)
            Toast.makeText(context, "Deleted successfully", Toast.LENGTH_LONG).show()
        }

        return view.rootView
    }
}