package com.aksoysefa.week3assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class bookListFragment : Fragment(), booksListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.adapter = bookAdapter(mockData, this@bookListFragment)

        arguments?.let {
            val mesaj=it.getString("back")
            val info=mesaj.toString()
            Toast.makeText(requireContext(),info,Toast.LENGTH_LONG).show()
        }


    }

    override fun onClicked(book: bookModel) {
        navController.navigate(R.id.action_bookListFragment_to_detailFragment, Bundle().apply {
            putString("bookModel", book.toJson())
        })


    }
}