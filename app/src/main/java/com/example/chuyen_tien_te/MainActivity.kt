package com.example.chuyen_tien_te

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import android.text.TextWatcher
import android.util.Log

class MainActivity : AppCompatActivity() {

    lateinit var listSpinner1:Spinner
    lateinit var listSpinner2:Spinner
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var button_CE: Button
    lateinit var button_C: Button
    lateinit var button_0: Button
    lateinit var button_1: Button
    lateinit var button_2: Button
    lateinit var button_3: Button
    lateinit var button_4: Button
    lateinit var button_5: Button
    lateinit var button_6: Button
    lateinit var button_7: Button
    lateinit var button_8: Button
    lateinit var button_9: Button
    lateinit var button_dot: Button
    lateinit var button_equal: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listSpinner1 = findViewById(R.id.spinner1)
        listSpinner2 = findViewById(R.id.spinner2)
        editText1 = findViewById(R.id.edit_text1)
        editText2 = findViewById(R.id.edit_text2)
        button_0 = findViewById(R.id.button_0)
        button_1 = findViewById(R.id.button_1)
        button_2 = findViewById(R.id.button_2)
        button_3 = findViewById(R.id.button_3)
        button_4 = findViewById(R.id.button_4)
        button_5 = findViewById(R.id.button_5)
        button_6 = findViewById(R.id.button_6)
        button_7 = findViewById(R.id.button_7)
        button_8 = findViewById(R.id.button_8)
        button_9 = findViewById(R.id.button_9)
        button_CE = findViewById(R.id.button_CE)
        button_C = findViewById(R.id.button_C)
        button_dot = findViewById(R.id.button_dot)
        button_equal = findViewById(R.id.button_equal)
        val nations = arrayOf(
            "Vietnam - VND",
            "China - Yuan",
            "Japan - Yen",
            "UK - Pound",
            "US - Dollar"
        )
        var adapter: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,nations)
        listSpinner1.adapter = adapter
        listSpinner2.adapter = adapter
        var currentEditText: EditText? = null
        var currentSpinner: Spinner? = null
        var anotherEditText: EditText? = null
        var anotherSpinner: Spinner? = null
        editText1.setOnFocusChangeListener(object: View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if (hasFocus) {
                    anotherEditText = editText2
                    currentEditText = editText1
                    currentSpinner = listSpinner1
                    anotherSpinner = listSpinner2
                }
            }
        })
        editText2.setOnFocusChangeListener(object: View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if (hasFocus) {
                    currentEditText = editText2
                    anotherEditText = editText1
                    currentSpinner = listSpinner2
                    anotherSpinner = listSpinner1
                }
            }
        })

        button_0.setOnClickListener {
            currentEditText?.let {
                var tmp: String = it.text.toString()
                tmp += '0'
                it.setText(tmp)
                it.setSelection(tmp.length)
            }
        }
        button_1.setOnClickListener {
            currentEditText?.let {
                var tmp: String = it.text.toString()
                tmp += '1'
                it.setText(tmp)
                it.setSelection(tmp.length)
            }
        }
        button_2.setOnClickListener {
            currentEditText?.let {
                var tmp: String = it.text.toString()
                tmp += '2'
                it.setText(tmp)
                it.setSelection(tmp.length)
            }
        }
        button_3.setOnClickListener {
            currentEditText?.let {
                var tmp: String = it.text.toString()
                tmp += '3'
                it.setText(tmp)
                it.setSelection(tmp.length)
            }
        }
        button_4.setOnClickListener {
            currentEditText?.let {
                var tmp: String = it.text.toString()
                tmp += '4'
                it.setText(tmp)
                it.setSelection(tmp.length)
            }
        }
        button_5.setOnClickListener {
            currentEditText?.let {
                var tmp: String = it.text.toString()
                tmp += '5'
                it.setText(tmp)
                it.setSelection(tmp.length)
            }
        }
        button_6.setOnClickListener {
            currentEditText?.let {
                var tmp: String = it.text.toString()
                tmp += '6'
                it.setText(tmp)
                it.setSelection(tmp.length)
            }
        }
        button_7.setOnClickListener {
            currentEditText?.let {
                var tmp: String = it.text.toString()
                tmp += '7'
                it.setText(tmp)
                it.setSelection(tmp.length)
            }
        }
        button_8.setOnClickListener {
            currentEditText?.let {
                var tmp: String = it.text.toString()
                tmp += '8'
                it.setText(tmp)
                it.setSelection(tmp.length)
            }
        }
        button_9.setOnClickListener {
            currentEditText?.let {
                var tmp: String = it.text.toString()
                tmp += '9'
                it.setText(tmp)
                it.setSelection(tmp.length)
            }
        }

        button_dot.setOnClickListener {
            currentEditText?.let {
                var tmp: String = it.text.toString()
                tmp += '.'
                it.setText(tmp)
                it.setSelection(tmp.length)
            }
        }

        button_CE.setOnClickListener {
            currentEditText?.setText("")
        }


        button_C.setOnClickListener {
            currentEditText?.let {
                val text = it.text.toString()
                if (text.isNotEmpty()) {
                    it.setText(text.substring(0, text.length - 1))
                    it.setSelection(it.text.length)
                }
            }
        }

        button_equal.setOnClickListener {
            if(currentEditText?.text.toString().isNotEmpty()){
                val selectedValue1 = currentSpinner?.selectedItem.toString()
                val selectedValue2 = anotherSpinner?.selectedItem.toString()
                var amount: Double = currentEditText?.text.toString().toDouble()
                var currency1: String = getCurrency(selectedValue1)
                var currency2: String = getCurrency(selectedValue2)
                var tmp1: Double? = convertCurrency(amount,currency1,currency2)
                anotherEditText?.setText(tmp1.toString())
                Log.d("CurrencyConverter", "Da nhap")
            }
        }

    }

    fun convertCurrency(amount: Double, fromCurrency: String, toCurrency: String): Double {
        // Bảng tỷ giá quy đổi sang USD
        val exchangeRates = mapOf(
            "VND" to 23185.0,   // 1 USD = 23,185 VND
            "Yuan" to 7.1,      // 1 USD = 7.1 Yuan
            "Yen" to 146.5,     // 1 USD = 146.5 Yen
            "Pound" to 0.79,    // 1 USD = 0.79 Pound
            "Dollar" to 1.0     // 1 USD = 1 USD
        )


        // Kiểm tra nếu loại tiền hợp lệ
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw IllegalArgumentException("Loại tiền tệ không hợp lệ")
        }

        // Chuyển đổi số tiền từ loại tiền nguồn về USD
        val amountInUSD = amount / exchangeRates[fromCurrency]!!

        // Chuyển đổi từ USD sang loại tiền đích
        return amountInUSD * exchangeRates[toCurrency]!!
    }



    private fun getCurrency(fullText: String): String {
        return fullText.substringAfter("-").trim()
    }
}


