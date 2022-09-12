package io.github.quoteapp.network

data class QuotesDto(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    var results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)
