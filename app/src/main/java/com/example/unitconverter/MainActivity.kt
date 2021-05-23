package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)





        binding.calculateButton.setOnClickListener { convertMeasurement() }
    }

    fun convertMeasurement() {

        val fromUnit = when (binding.fromOptions.checkedRadioButtonId) {
            R.id.optionCup -> "Cup"
            R.id.optionOunce -> "Ounce"
            else -> "Milliliter"
        }
        val toUnit = when (binding.toOptions.checkedRadioButtonId) {
            R.id.toOptionCup -> "Cup"
            R.id.toOptionOunce -> "Ounce"
            else -> "Milliliter"
        }

        val fromNumber: Double? = binding.fromUnit.text.toString().toDoubleOrNull()

        if (fromNumber == null){
            binding.toUnit.text = "0.0"
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
        } else {
            if (fromUnit == "Cup" && toUnit == "Ounce") {
                cupToOunce(fromNumber)
            } else if (fromUnit == "Cup" && toUnit == "Milliliter") {
                cupToMilliliter(fromNumber)
            } else if (fromUnit == "Ounce" && toUnit == "Cup") {
                ounceToCup(fromNumber)
            } else if (fromUnit == "Ounce" && toUnit == "Milliliter") {
                ounceToMilliliter(fromNumber)
            } else if (fromUnit == "Milliliter" && toUnit == "Cup") {
                milliliterToCup(fromNumber)
            } else if (fromUnit == "Milliliter" && toUnit == "Ounce") {
                milliliterToOunce(fromNumber)
            } else if (fromUnit == toUnit) {
                sameMeasurement(fromNumber)
            }
        }

    }


    fun cupToOunce(fromNumber: Double) {
        val convertedNumber = fromNumber * 8.0
        val formattedNumber = "%.4f".format(convertedNumber)
        binding.toUnit.text = "$formattedNumber oz"
    }

    fun cupToMilliliter(fromNumber: Double) {
        val convertedNumber = fromNumber * 236.588236
        val formattedNumber = "%.4f".format(convertedNumber)
        binding.toUnit.text = "$formattedNumber mL"
    }

    fun ounceToCup(fromNumber: Double) {
        val convertedNumber = fromNumber / 8
        val formattedNumber = "%.4f".format(convertedNumber)
        binding.toUnit.text = "$formattedNumber Cups"
    }

    fun ounceToMilliliter(fromNumber: Double) {
        val convertedNumber = fromNumber * 29.5735296
        val formattedNumber = "%.4f".format(convertedNumber)
        binding.toUnit.text = "$formattedNumber mL"
    }

    fun milliliterToCup(fromNumber: Double) {
        val convertedNumber = fromNumber / 236.588236
        val formattedNumber = "%.4f".format(convertedNumber)

        binding.toUnit.text = "$formattedNumber Cups"
    }

    fun milliliterToOunce(fromNumber: Double) {
        val convertedNumber = fromNumber / 29.5735296
        val formattedNumber = "%.4f".format(convertedNumber)

        binding.toUnit.text = "$formattedNumber oz"
    }

    fun sameMeasurement (fromNumber: Double){
        binding.toUnit.text = fromNumber.toString()
    }

}