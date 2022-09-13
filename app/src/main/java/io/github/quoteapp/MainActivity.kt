package io.github.quoteapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.quoteapp.databinding.ActivityMainBinding
import io.github.quoteapp.ui.QuoteViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this

        // Giving the binding access to the QuoteModel
        binding.viewmodel = viewModel

        binding.photosGrid.adapter = QuoteAdapter()


    }
}