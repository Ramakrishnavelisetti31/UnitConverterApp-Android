package com.example.quantitymeasurement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class ConvertQuantityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_convert_quantity_, container, false)
        val inputText = view.findViewById<EditText>(R.id.inputText)
        val outputResult = view.findViewById<TextView>(R.id.outputResult)
        val mainSpinner = view.findViewById<Spinner>(R.id.mainSpinner)
        val inputSpinner = view.findViewById<Spinner>(R.id.inputSpinner)
        val outputSpinner = view.findViewById<Spinner>(R.id.outputSpinner)
        val convertButton = view.findViewById<Button>(R.id.convert_button)

        val mainTerms = ArrayList<String>()
        mainTerms.add("Length")
        mainTerms.add("Temperature")
        mainTerms.add("Volume")

        val lengthTerms = ArrayList<String>()
        lengthTerms.add("Centimeter")
        lengthTerms.add("Meter")
        lengthTerms.add("Kilometer")
        lengthTerms.add("Miles")

        val tempTerms = ArrayList<String>()
        tempTerms.add("Fahrenheit")
        tempTerms.add("Celsius")
        tempTerms.add("Kelvin")

        val volumeTerms = ArrayList<String>()
        volumeTerms.add("Millilitre")
        volumeTerms.add("Litre")
        volumeTerms.add("Gallon")

        val mainAdapter: ArrayAdapter<String>? = activity?.let {
            ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, mainTerms)
        }
        mainSpinner.adapter = mainAdapter

        val lengthAdapter: ArrayAdapter<String>? = activity?.let {
            ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, lengthTerms)
        }

        val tempAdapter: ArrayAdapter<String>? = activity?.let {
            ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, tempTerms)
        }

        val volumeAdapter: ArrayAdapter<String>? = activity?.let {
            ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, volumeTerms)
        }

        var mainSelectedSpinner: String = ""
        var inPutSelectedSpinner: String = ""
        var outPutSelectedSpinner: String = ""

        mainSpinner?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                 mainSelectedSpinner = parent?.getItemAtPosition(position).toString()
                if (mainSelectedSpinner != "Length") {
                    if (mainSelectedSpinner == "Temperature") {
                        inputSpinner.adapter = tempAdapter
                        outputSpinner.adapter = tempAdapter
                    } else {
                        inputSpinner.adapter = volumeAdapter
                        outputSpinner.adapter = volumeAdapter
                    }
                } else {
                    inputSpinner.adapter = lengthAdapter
                    outputSpinner.adapter = lengthAdapter
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        inputSpinner?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                inPutSelectedSpinner = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        outputSpinner?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                outPutSelectedSpinner = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        val valueConversions = ValuesConversions()
        convertButton.setOnClickListener {
            val input = inputText.text.toString().toDouble()
            if (mainSelectedSpinner != "Length") {
                if(mainSelectedSpinner == "Temperature") {
                    val finalValue = valueConversions.temperatureConversions(inPutSelectedSpinner, outPutSelectedSpinner, input)
                    outputResult.text = finalValue.toString()
                } else {
                    val finalValue = valueConversions.volumeConversions(inPutSelectedSpinner, outPutSelectedSpinner, input)
                    outputResult.text = finalValue.toString()
                }
            } else {
                val finalValue = valueConversions.lengthConversions(inPutSelectedSpinner, outPutSelectedSpinner, input)
                outputResult.text = finalValue.toString()
            }
        }
            return view
    }

}
