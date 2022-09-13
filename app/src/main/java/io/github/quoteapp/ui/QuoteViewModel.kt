package io.github.quoteapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.quoteapp.model.QuotesWithAuthor
import io.github.quoteapp.network.QuotesApi
import io.github.quoteapp.network.toQuoteWithAuthor
import io.github.quoteapp.utils.MyColor
import io.github.quoteapp.utils.coler
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val api: QuotesApi
) : ViewModel() {
    private var noOfQuotes: MutableLiveData<Int> = MutableLiveData()
    private lateinit var colorList: List<MyColor>

    private val _quoteWithAuthor = MutableLiveData<List<QuotesWithAuthor>>()

    val quoteWithAuthor: LiveData<List<QuotesWithAuthor>> = _quoteWithAuthor

    init {
        getQuotes()
    }


    private fun getQuotes() {
        viewModelScope.launch {
            try {
                api.getQuotes().body()?.results?.apply {
                    noOfQuotes.value = this.size
                    _quoteWithAuthor.value = this.map {
                        it.toQuoteWithAuthor()
                    }
                    colorList = coler(noOfQuotes.value)
                }


            } catch (e: Exception) {
                Log.d("TAG", "Error getting documents: ", e)
            }
        }
    }

}