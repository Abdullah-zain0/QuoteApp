package io.github.quoteapp

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.quoteapp.model.QuotesWithAuthor

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<QuotesWithAuthor>?) {
    val adapter = recyclerView.adapter as QuoteAdapter
    adapter.submitList(data)

}
