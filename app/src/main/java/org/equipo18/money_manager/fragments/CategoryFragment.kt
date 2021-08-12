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

        // ArrayList of class ItemsViewModel
        val incomes = ArrayList<CategoriesViewModel>()

        incomes.add(CategoriesViewModel(R.drawable.ic_category, "Texto"))

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapterCategories(incomes)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        return view
    }

    companion object {
        fun newInstance(): CategoryFragment = CategoryFragment()
    }
}