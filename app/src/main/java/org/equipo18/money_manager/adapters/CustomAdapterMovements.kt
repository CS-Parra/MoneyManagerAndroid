package org.equipo18.money_manager.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.equipo18.money_manager.R
import org.equipo18.money_manager.models.MovementsViewModel

class CustomAdapterMovements(private val mList: List<MovementsViewModel>) : RecyclerView.Adapter<CustomAdapterMovements.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design_movements, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val movementsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.image.setImageResource(movementsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.name.text = movementsViewModel.name

        holder.description.text = movementsViewModel.description

        holder.amount.text = movementsViewModel.amount.toString()

        holder.date.text = movementsViewModel.date

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val image: ImageView = itemView.findViewById(R.id.imgMovement)
        val name: TextView = itemView.findViewById(R.id.tvName)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
        val amount: TextView = itemView.findViewById(R.id.tvAmount)
        val date: TextView = itemView.findViewById(R.id.tvDate)
    }

}