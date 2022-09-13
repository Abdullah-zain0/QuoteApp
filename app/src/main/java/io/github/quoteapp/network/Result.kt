package io.github.quoteapp.network

import com.squareup.moshi.Json
import io.github.quoteapp.model.QuotesWithAuthor

data class Result(
    @Json(name = "_id") val id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    val tags: List<String>
)

fun Result.toQuoteWithAuthor(): QuotesWithAuthor {
    return QuotesWithAuthor(
        quote = content,
        author = author,
        id = id
    )
}