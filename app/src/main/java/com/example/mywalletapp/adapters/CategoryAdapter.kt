package com.example.mywalletapp.adapters
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mywalletapp.R
import com.example.mywalletapp.entities.Category
import com.example.mywalletapp.fragments.AddCategoryFragmentDirections
import com.example.mywalletapp.fragments.HomeFragmentDirections

class CategoryAdapter(private val array: Array<Category>, val context: FragmentActivity): RecyclerView.Adapter<CategoryAdapter.ViewHolder> (){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.title_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.title.text = item.nameCategory
        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToServicesFragment(item.idCategory!!))
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}