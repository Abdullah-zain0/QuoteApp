package io.github.quoteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.github.quoteapp.ui.QuoteViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textview1 = findViewById<TextView>(R.id.tv)

        viewModel.sizeOf.observe(this, ){
            textview1.text = it.toString()
        }

    }
}