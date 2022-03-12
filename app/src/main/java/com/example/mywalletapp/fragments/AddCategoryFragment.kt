package com.example.mywalletapp.fragments
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mywalletapp.databinding.FragmentAddCategoryBinding
import com.example.mywalletapp.entities.Category
import com.example.mywalletapp.services.App

class AddCategoryFragment : Fragment() {
    private var _binding: FragmentAddCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = App.instance?.getDatabase()?.CategoryDao()
        binding.saveCategoryBtn.setOnClickListener {
            db?.addCategory(
                Category(
                    idCategory = null,
                    nameCategory = binding.addCategoryEt.text.toString()
                ))
            Log.d("DDDD", "${ db?.getAllCategory() }")
        }
    }
}