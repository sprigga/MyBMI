package com.example.mybmi


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Double.parseDouble
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setListener()
    }

    lateinit var button: Button
    lateinit var fieldheight: EditText
    lateinit var fieldweight: EditText
    var height:Double = 0.0
    var weight :Double = 0.0
    var bmiValue: Double =0.0
    lateinit var result: TextView
    lateinit var fieldsuggest:TextView

    private fun  initView()
    {
        fieldheight = findViewById(R.id.editText1)
        fieldweight = findViewById(R.id.editText2)
        button = findViewById(R.id.button1)
        result = findViewById(R.id.textView4)
    }

    private fun setListener()
    {
        button.setOnClickListener(calcBMI)
    }

    private val calcBMI = OnClickListener {
        val nf = DecimalFormat("0.00")
        //身高
        height = parseDouble(fieldheight.text.toString()) / 100
        //體重
        weight = parseDouble(fieldweight.text.toString())
        //計算出BMI值
        bmiValue = weight / (height * height)
        println("${height * height}")
        //結果
        result.text = getText(R.string.bmi_result).toString() + nf.format(bmiValue)
        //建議
        fieldsuggest = findViewById(R.id.textView5)
        when {
            bmiValue > 25
                //太重了
            -> fieldsuggest.setText(R.string.advice_heavy)
            bmiValue < 20
                //太輕了
            -> fieldsuggest.setText(R.string.advice_light)
            else
                //剛剛好
            -> fieldsuggest.setText(R.string.advice_average)
        }
    }

}

