package com.example.pifagorth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import com.example.pifagorth.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun onClickResult(view: View){
        if(!isFieldEmpty()) {
            var result = getString(R.string.result) + getResult()
            binding.tvResult.text = result
        }

    }

    private fun isFieldEmpty(): Boolean{
        binding.apply {
            if(edA.text.isNullOrEmpty()) edA.error = "Поле должно быть заполнено"
            if(edB.text.isNullOrEmpty()) edB.error = "Поле должно быть заполнено"

            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()

        }

    }

    private fun getResult(): String{
        var a: Double
        var b: Double

        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()

            return sqrt((a.pow(2))+(b.pow(2))).toString()
        }
    }

}