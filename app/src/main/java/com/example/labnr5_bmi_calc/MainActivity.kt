package com.example.labnr5_bmi_calc

import android.icu.text.DecimalFormat
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.example.labnr5_bmi_calc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun bmiGoobery() {
            var heightStr = binding.editTextText.text.toString()
            var weightStr = binding.editTextText2.text.toString()

            if(heightStr.isNotEmpty() && weightStr.isNotEmpty() && heightStr.isDigitsOnly() && weightStr.isDigitsOnly()) {
                var heightNum = heightStr.toDouble() / 100
                var weightNum = weightStr.toDouble()

                if (heightNum > 0 && weightNum > 0) {
                    var bmiVal = weightNum / (heightNum * heightNum)

                    var decFormat = DecimalFormat("#.##")
                    var formattedBmi = decFormat.format(bmiVal)

                    binding.textView2.text = "Twoje BMI: $formattedBmi"
                }
            }
        }

        binding.editTextText.addTextChangedListener {
            bmiGoobery()
        }

        binding.editTextText2.addTextChangedListener {
            bmiGoobery()
        }
    }
}
