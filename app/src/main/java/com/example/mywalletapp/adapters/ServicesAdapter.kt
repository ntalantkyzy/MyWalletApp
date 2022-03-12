package com.example.mywalletapp.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mywalletapp.R
import com.example.mywalletapp.entities.Services
import com.example.mywalletapp.fragments.ServicesFragmentDirections

class ServicesAdapter(private val array: ArrayList<Services>, val context: FragmentActivity): RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.title_services)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_services_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.title.text = item.nameService
        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(ServicesFragmentDirections.actionServicesFragmentToTransactionFragment(
                serviceId = item.idService!!,
                servicesName = item.nameService!!,
                servicesCategory = item.fkCategory!!
            ))
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}