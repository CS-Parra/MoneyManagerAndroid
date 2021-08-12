package org.equipo18.money_manager.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.equipo18.money_manager.models.AccountsViewModel
import org.equipo18.money_manager.DetalleAccount
import org.equipo18.money_manager.R

class CustomAdapterAccounts(private val mList: List<AccountsViewModel>, private val context: Context) :
    RecyclerView.Adapter<CustomAdapterAccounts.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design_accounts, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val accountsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.accountText.text = accountsViewModel.accountName
        // sets the text to the textview from our itemHolder class
        holder.balance.text = accountsViewModel.balance.toString()

        holder.currency.text = accountsViewModel.currency

        holder.imgAccount.setImageResource(accountsViewModel.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetalleAccount::class.java)
            intent.putExtra("accountName", mList[position].accountName)
            intent.putExtra("balance", mList[position].balance)
            intent.putExtra("currency", mList[position].currency)
            intent.putExtra("image", mList[position].image)
            context.startActivity(intent)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val accountText: TextView = itemView.findViewById(R.id.txtAccountName)
        val balance: TextView = itemView.findViewById(R.id.txtBalance)
        val currency: TextView = itemView.findViewById(R.id.txtCurrency)
        val imgAccount: ImageView = itemView.findViewById(R.id.imgAccount)
    }
}