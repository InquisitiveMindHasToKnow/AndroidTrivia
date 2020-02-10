package org.ohmstheresistance.androidtrivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.androidtrivia.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            @Suppress("UNUSED_VARIABLE")

            val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)
        }
    }
}