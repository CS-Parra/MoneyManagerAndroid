package org.equipo18.money_manager.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.equipo18.money_manager.R
import org.equipo18.money_manager.adapters.CustomAdapterCategories
import org.equipo18.money_manager.models.CategoriesViewModel
import org.equipo18.money_manager.models.MovementsViewModel

class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        // getting the recyclerview by its id
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        val categories = listOf(
            CategoriesViewModel(R.drawable.ic_category, "Transporte"),
            CategoriesViewModel(R.drawable.ic_category, "Alimentacion"),
            CategoriesViewModel(R.drawable.ic_category, "Rutina"),
            CategoriesViewModel(R.drawable.ic_category, "Familia"),
            CategoriesViewModel(R.drawable.ic_category, "Regalos"),
            CategoriesViewModel(R.drawable.ic_category, "Interes"),
            CategoriesViewModel(R.drawable.ic_category, "Salario"),
            CategoriesViewModel(R.drawable.ic_category, "Casa"),
            CategoriesViewModel(R.drawable.ic_category, "Educacion"),
            CategoriesViewModel(R.drawable.ic_category, "Salud"),
        )

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapterCategories(categories)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        return view
    }

    companion object {
        fun newInstance(): CategoryFragment = CategoryFragment()
    }
}