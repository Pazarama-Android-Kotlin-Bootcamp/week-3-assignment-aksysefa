package com.aksoysefa.week3assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class bookAdapter(private val bookList: MutableList<bookModel>,
                  private val listener: booksListener): RecyclerView.Adapter<bookAdapter.bookHolder>() {

    class bookHolder(view: View):RecyclerView.ViewHolder(view){
        private val bookName = view.findViewById<TextView>(R.id.book_Name)
        private val bookAuthor = view.findViewById<TextView>(R.id.book_Author)
        private val bookBrief = view.findViewById<TextView>(R.id.book_Brief)
        private val bookImage = view.findViewById<ImageView>(R.id.image_Book)

        fun bind(book: bookModel, listener: booksListener) {

            bookName.text = book.bookName
            bookAuthor.text = book.author
            bookBrief.text=book.brief
            bookImage.setImageResource(book.bookImage)

            itemView.setOnClickListener {
                listener.onClicked(book)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bookHolder {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.book_list_row,parent,false)
        return bookHolder(view)
    }

    override fun onBindViewHolder(holder: bookHolder, position: Int) {
        holder.bind(bookList[position], listener)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}
interface booksListener {
    fun onClicked(book: bookModel)
}