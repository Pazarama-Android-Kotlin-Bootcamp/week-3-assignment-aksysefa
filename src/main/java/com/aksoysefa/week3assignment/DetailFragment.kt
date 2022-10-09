package com.aksoysefa.week3assignment

import android.media.Image
import android.os.Bundle
import android.view.Gravity.apply
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat.apply
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.callbackFlow
import org.w3c.dom.Text


class DetailFragment : Fragment() {
    private lateinit var  bookName:TextView
    private lateinit var bookAuthor:TextView
    private lateinit var bookBrief:TextView
    private lateinit var bookImage:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews(view)
        val callback=object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_detailFragment_to_bookListFragment,Bundle().apply {
                    putString("back","ana sayfaya dönüldü")
                })
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback)
    }
    private fun setupViews(view: View) {
        bookName = view.findViewById(R.id.booknameDetail)
        bookAuthor = view.findViewById(R.id.bookAuthorDetail)
        bookBrief = view.findViewById(R.id.bookBriefDetail)
        bookImage=view.findViewById(R.id.imageViewDetail)

        arguments?.let {
            val bookData = it.getString("bookModel")

            bookData?.let { safeBookData ->
                val book = bookModel.fromJson(safeBookData)

                bookName.text = book.bookName
                bookAuthor.text = book.author
                bookBrief.text = book.brief
                bookImage.setImageResource(book.bookImage)

            }
        }
    }
}