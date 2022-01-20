package com.example.quantitymeasurement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class AddQuantityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_add_quantity_, container, false)
        val leadSpinner = view.findViewById<Spinner>(R.id.leadSpinner)
        val inputText1 = view.findViewById<EditText>(R.id.inputText1)
        val inputText2 = view.findViewById<EditText>(R.id.inputText2)
        val outputResult = view.findViewById<TextView>(R.id.outputResult)
        val inputSpinner1 = view.findViewById<Spinner>(R.id.inputSpinner1)
        val inputSpinner2 = view.findViewById<Spinner>(R.id.inputSpinner2)
        val outputSpinner = view.findViewById<Spinner>(R.id.outputSpinner)
        val addButton = view.findViewById<Button>(R.id.add_button)

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
        leadSpinner.adapter = mainAdapter

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
        var inPutSelectedSpinner1: String = ""
        var inPutSelectedSpinner2: String = ""
        var outPutSelectedSpinner: String = ""

        leadSpinner?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                mainSelectedSpinner = parent?.getItemAtPosition(position).toString()
                if (mainSelectedSpinner != "Length") {
                    if (mainSelectedSpinner == "Temperature") {
                        inputSpinner1.adapter = tempAdapter
                        inputSpinner2.adapter = tempAdapter
                        outputSpinner.adapter = tempAdapter
                    } else {
                        inputSpinner1.adapter = volumeAdapter
                        inputSpinner2.adapter = volumeAdapter
                        outputSpinner.adapter = volumeAdapter
                    }
                } else {
                    inputSpinner1.adapter = lengthAdapter
                    inputSpinner2.adapter = lengthAdapter
                    outputSpinner.adapter = lengthAdapter
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        inputSpinner1?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                inPutSelectedSpinner1 = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        inputSpinner2?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                inPutSelectedSpinner2 = parent?.getItemAtPosition(position).toString()
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

        val addConversion = ValuesConversions()
        addButton.setOnClickListener {
            if (mainSelectedSpinner == "Length") {
                val value1 = inputText1.text.toString().toDouble()
                val value2 = inputText2.text.toString().toDouble()
                val result = addConversion.addLengthConversions(inPutSelectedSpinner1, inPutSelectedSpinner2,outPutSelectedSpinner, value1, value2)
                outputResult.text = result.toString()
            }
        }
        return view
    }
}