package com.example.quantitymeasurement

class ValuesConversions {

    fun lengthConversions (inputSelectedSpinner: String, outPutSelectedSpinner: String, input: Double): Double {
        when {
            (inputSelectedSpinner == "Centimeter" && outPutSelectedSpinner == "Meter") -> {
                return input / 100.0
            }
            (inputSelectedSpinner == "Centimeter" && outPutSelectedSpinner == "Kilometer") -> {
                return input / 100000.0
            }
            (inputSelectedSpinner == "Centimeter" && outPutSelectedSpinner == "Miles") -> {
                return input / 160934.0
            }
            (inputSelectedSpinner == "Meter" && outPutSelectedSpinner == "Centimeter") -> {
                return input * 100.0
            }
            (inputSelectedSpinner == "Meter" && outPutSelectedSpinner == "Kilometer") -> {
                return input / 1000.0
            }
            (inputSelectedSpinner == "Meter" && outPutSelectedSpinner == "Miles") -> {
                return input * 0.0006213712
            }
            (inputSelectedSpinner == "Kilometer" && outPutSelectedSpinner == "Centimeter") -> {
                return input * 100000.0
            }
            (inputSelectedSpinner == "Kilometer" && outPutSelectedSpinner == "Meter") -> {
                return input * 1000.0
            }
            (inputSelectedSpinner == "Kilometer" && outPutSelectedSpinner == "Miles") -> {
                return input / 1.609
            }
            (inputSelectedSpinner == "Miles" && outPutSelectedSpinner == "Centimeter") -> {
                return input * 160934.0
            }
            (inputSelectedSpinner == "Miles" && outPutSelectedSpinner == "Meter") -> {
                return input * 1609.0
            }
            (inputSelectedSpinner == "Miles" && outPutSelectedSpinner == "Kilometer") -> {
                return input * 1.609
            }
            else -> {
                return input
            }
        }
    }

    fun volumeConversions(inputSelectedSpinner: String, outPutSelectedSpinner: String, input: Double): Double {
        when {

            (inputSelectedSpinner == "Millilitre" && outPutSelectedSpinner == "Litre") -> {
                return input / 1000.0
            }
            (inputSelectedSpinner == "Millilitre" && outPutSelectedSpinner == "Gallon") -> {
                return input / 3785.0
            }
            (inputSelectedSpinner == "Litre" && outPutSelectedSpinner == "Millilitre") -> {
                return input * 1000.0
            }
            (inputSelectedSpinner == "Litre" && outPutSelectedSpinner == "Gallon") -> {
                return input / 3.785
            }
            (inputSelectedSpinner == "Gallon" && outPutSelectedSpinner == "Millilitre") -> {
                return input * 3785.0
            }
            (inputSelectedSpinner == "Gallon" && outPutSelectedSpinner == "Litre") -> {
                return input * 3.785
            }
            else -> {
                return input
            }
        }
    }

    fun temperatureConversions(inputSelectedSpinner: String, outPutSelectedSpinner: String, input: Double): Double {
        when {
            inputSelectedSpinner == "Celsius" && outPutSelectedSpinner == "Kelvin" -> {
                return input + 273.15
            }
            inputSelectedSpinner == "Celsius" && outPutSelectedSpinner == "Fahrenheit" -> {
                return (((input * 9.0) / 5.0) + 32.0)
            }
            inputSelectedSpinner == "Kelvin" && outPutSelectedSpinner == "Fahrenheit" -> {
                return ((((input - 273.15) * 9.0) / 5.0) + 32.0)
            }
            inputSelectedSpinner == "Kelvin" && outPutSelectedSpinner == "Celsius" -> {
                return  input - 273.15
            }
            inputSelectedSpinner == "Fahrenheit" && outPutSelectedSpinner == "Kelvin" -> {
                return (((input - 32.0) * 5.0) / 9.0) + 273.15
            }
            inputSelectedSpinner == "Fahrenheit" && outPutSelectedSpinner == "Celsius" -> {
                return (((input - 32.0) * 5.0) / 9.0)
            }
            else -> {
                return input
            }
        }
    }

    fun addLengthConversions(spinner1: String, spinner2: String, spinner3: String, input1: Double, input2: Double): Double {
        when {
            (spinner1 == "Centimeter" && spinner2 == "Centimeter" && spinner3 == "Meter") -> {
                return ((input1 + input2) / 100.0)
            }
            (spinner1 == "Centimeter" && spinner2 == "Centimeter" && spinner3 == "Kilometer") -> {
                return ((input1 + input2) / 100000.0)
            }
            (spinner1 == "Centimeter" && spinner2 == "Centimeter" && spinner3 == "Miles") -> {
                return ((input1 + input2) / 160934.0)
            }
            (spinner1 == "Centimeter" && spinner2 == "Meter" && spinner3 == "Centimeter") -> {
                return ((input1 + (input2 * 100.0)))
            }
            (spinner1 == "Centimeter" && spinner2 == "Meter" && spinner3 == "Meter") -> {
                return ((input1 / 100.0) + input2)
            }
            (spinner1 == "Centimeter" && spinner2 == "Meter" && spinner3 == "Kilometer") -> {
                return (((input1 / 100.0) + input2) / 1000.0)
            }
            (spinner1 == "Centimeter" && spinner2 == "Meter" && spinner3 == "Miles") -> {
                return (((input1 / 100.0) + input2) * 0.0006213712)
            }
            (spinner1 == "Centimeter" && spinner2 == "Kilometer" && spinner3 == "Centimeter") -> {
                return (input1 + (input2 * 100000.0))
            }
            (spinner1 == "Centimeter" && spinner2 == "Kilometer" && spinner3 == "Meter") -> {
                return ((input1 + (input2 * 100000.0)) / 100.0)
            }
            (spinner1 == "Centimeter" && spinner2 == "Kilometer" && spinner3 == "Kilometer") -> {
                return ((input1 / 100000.0) + input2)
            }
            (spinner1 == "Centimeter" && spinner2 == "Kilometer" && spinner3 == "Miles") -> {
                return (((input1 / 100000.0) + input2) / 1.609)
            }
            (spinner1 == "Centimeter" && spinner2 == "Miles" && spinner3 == "Centimeter") -> {
                return (input1 + (input2 * 160934.0))
            }
            (spinner1 == "Centimeter" && spinner2 == "Miles" && spinner3 == "Meter") -> {
                return (input1 + (input2 * 160934.0) / 100.0)
            }
            (spinner1 == "Centimeter" && spinner2 == "Miles" && spinner3 == "Kilometer") -> {
                return (input1 + (input2 * 160934.0) / 100000.0)
            }
            (spinner1 == "Centimeter" && spinner2 == "Miles" && spinner3 == "Miles") -> {
                return ((input1 / 160934.0) + input2)
            }
            (spinner1 == "Meter" && spinner2 == "Meter" && spinner3 == "Centimeter") -> {
                return ((input1 + input2) * 100.0)
            }
            (spinner1 == "Meter" && spinner2 == "Meter" && spinner3 == "Kilometer") -> {
                return ((input1 + input2) / 1000.0)
            }
            (spinner1 == "Meter" && spinner2 == "Meter" && spinner3 == "Miles") -> {
                return ((input1 + input2) * 0.0006213712)
            }
            (spinner1 == "Meter" && spinner2 == "Centimeter" && spinner3 == "Centimeter") -> {
                return ((input1 * 100.0) + input2)
            }
            (spinner1 == "Meter" && spinner2 == "Centimeter" && spinner3 == "Meter") -> {
                return ((input1  + (input2 / 100.0)))
            }
            (spinner1 == "Meter" && spinner2 == "Centimeter" && spinner3 == "Kilometer") -> {
                return (((input1 + (input2 / 100.0) / 1000.0)))
            }
            (spinner1 == "Meter" && spinner2 == "Centimeter" && spinner3 == "Miles") -> {
                return (((input1 + input2 / 100.0) * 0.0006213712))
            }
            (spinner1 == "Meter" && spinner2 == "Kilometer" && spinner3 == "Centimeter") -> {
                return ((input1 + (input2 * 1000.0) * 100.0))
            }
            (spinner1 == "Meter" && spinner2 == "Kilometer" && spinner3 == "Meter") -> {
                return ((input1  + (input2 * 1000.0)))
            }
            (spinner1 == "Meter" && spinner2 == "Kilometer" && spinner3 == "Kilometer") -> {
                return ((input1 / 1000.0) + input2)
            }
            (spinner1 == "Meter" && spinner2 == "Kilometer" && spinner3 == "Miles") -> {
                return (((input1 / 1000.0) + input2) * 1.609)
            }
            (spinner1 == "Meter" && spinner2 == "Miles" && spinner3 == "Centimeter") -> {
                return (input1 + (input2 * 1609.0) * 100.0)
            }
            (spinner1 == "Meter" && spinner2 == "Miles" && spinner3 == "Meter") -> {
                return (input1 + (input2 * 1609.0))
            }
            (spinner1 == "Meter" && spinner2 == "Miles" && spinner3 == "Kilometer") -> {
                return (input1 + (input2 * 1609.0) * 1000.0)
            }
            (spinner1 == "Meter" && spinner2 == "Miles" && spinner3 == "Miles") -> {
                return ((input1 * 0006213712.0) + input2)
            }
            (spinner1 == "Kilometer" && spinner2 == "Kilometer" && spinner3 == "Centimeter") -> {
                return ((input1 + input2) * 100000.0)
            }
            (spinner1 == "Kilometer" && spinner2 == "Kilometer" && spinner3 == "Meter") -> {
                return ((input1 + input2) * 1000.0)
            }
            (spinner1 == "Kilometer" && spinner2 == "Kilometer" && spinner3 == "Miles") -> {
                return ((input1 + input2) / 1.609)
            }
            (spinner1 == "Kilometer" && spinner2 == "Centimeter" && spinner3 == "Centimeter") -> {
                return ((input1 * 100000.0) + input2)
            }
            (spinner1 == "Kilometer" && spinner2 == "Centimeter" && spinner3 == "Meter") -> {
                return ((input1  + (input2 / 100000.0)) * 1000.0)
            }
            (spinner1 == "Kilometer" && spinner2 == "Centimeter" && spinner3 == "Kilometer") -> {
                return (input1 + (input2 / 100000.0))
            }
            (spinner1 == "Kilometer" && spinner2 == "Centimeter" && spinner3 == "Miles") -> {
                return (((input1 + input2 / 100000.0) / 1.609))
            }
            else -> {
                return (input1 + input2)
            }
        }
    }
}