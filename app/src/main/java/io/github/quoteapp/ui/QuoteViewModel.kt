package io.github.quoteapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.quoteapp.network.QuotesApi
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val api: QuotesApi
): ViewModel()  {
   private var _sizeOf: MutableLiveData<Int> = MutableLiveData()

    init {
        getQuotes()
    }
    val sizeOf: MutableLiveData<Int> = _sizeOf
    fun getQuotes(){
        viewModelScope.launch {
            _sizeOf.value = try {
              api.getQuotes().body()?.results?.size
            }catch (e: Exception){
                Log.d("TAG", "Error getting documents: ", e)
            }
        }
    }

}