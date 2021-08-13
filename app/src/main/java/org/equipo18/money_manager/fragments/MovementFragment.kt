package org.equipo18.money_manager.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.equipo18.money_manager.R
import org.equipo18.money_manager.adapters.CustomAdapterMovements
import org.equipo18.money_manager.models.MovementsViewModel

class MovementFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movement, container, false)

        // getting the recyclerview by its id
        val recyclerview = view.findViewById<RecyclerView>(R.id.rvMovement)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        // ArrayList of class ItemsViewModel

        val movements = listOf(
            MovementsViewModel(R.drawable.ic_movements,"Salario","Me pagaron",1900f,"20-07-2021"),
            MovementsViewModel(R.drawable.ic_movements,"Comida","Tenia Hambre",80f,"20-07-2021")
        )
        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapterMovements(movements)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        return view

    }

    companion object {
        fun newInstance(): MovementFragment = MovementFragment()
    }

}