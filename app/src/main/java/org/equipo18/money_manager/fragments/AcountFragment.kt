package org.equipo18.money_manager.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.equipo18.money_manager.R
import org.equipo18.money_manager.adapters.CustomAdapterAccounts
import org.equipo18.money_manager.models.AccountsViewModel
import org.equipo18.money_manager.models.CategoriesViewModel


class AcountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_acount, container, false)

        // getting the recyclerview by its id
        val recyclerview = view.findViewById<RecyclerView>(R.id.rvAccount)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        val accounts = listOf(
            AccountsViewModel("Principal",5000f,"Mx", R.drawable.ic_account),
            AccountsViewModel("Secundario",1000f,"Mx", R.drawable.ic_account)
        )

        val adapter = CustomAdapterAccounts(accounts, requireContext())

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        return view

    }

    companion object {
        fun newInstance(): AcountFragment = AcountFragment()
    }

}