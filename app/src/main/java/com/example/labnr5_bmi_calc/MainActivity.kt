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
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import android.util.Log
import android.widget.Toast

val TAG = "cykl życia"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        val spplashScreen = installSplashScreen()
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

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
    }
}
