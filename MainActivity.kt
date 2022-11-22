package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNumber=""
    var newNumber=""
    var op="+"
    var op1="-"
    var op2="*"
    var op3="/"
    var op4="%"
    var isMinus = true
    var isDot= true
    lateinit var tvShowNumber:TextView
    lateinit var buAC:Button
    lateinit var bu2:Button
    lateinit var bu16:Button
    lateinit var bu12:Button
    lateinit var bu8:Button
    lateinit var bu4:Button
    lateinit var bu3:Button
    lateinit var buDot:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
    }

    fun buNumberEvent(view: View) {
        if (isNewOp) {
            tvShowNumber.text=""

        }
        isNewOp = false
     var buSelect = view as Button
     var tvNumber:String =tvShowNumber.text.toString()
     when(buSelect.id) {
         buAC.id -> tvNumber=""
         bu2.id ->{if(isMinus) {
             tvNumber+="-"+tvNumber
             isMinus= false
         }}
         buDot.id ->{
             if(isDot){
                 tvNumber+= buSelect.text.toString()
                 isDot=false
             }}



            else -> tvNumber+= buSelect.text.toString()
    }

    }

    fun buOpEvent(view:View) {
        oldNumber = tvShowNumber.text.toString()
        isNewOp = true
        isDot= true
        isMinus= true
        var buselect = view as Button
        when (buselect.id) {
            bu16.id -> op = "+"
            bu12.id -> op1 = "-"
            bu8.id -> op2 = "*"
            bu4.id -> op3 = "/"
            bu3.id -> op4 = "%"

        }
    }
    fun buEquelVent(view:View) {
        newNumber = tvShowNumber.text.toString()
        var resultNumber: Double? = null

        when (op) {
            "+" -> resultNumber = oldNumber.toDouble() + newNumber.toDouble()
            "*" -> resultNumber = oldNumber.toDouble() * newNumber.toDouble()
            "-" -> resultNumber = oldNumber.toDouble() - newNumber.toDouble()
            "/" -> resultNumber = oldNumber.toDouble() / newNumber.toDouble()

        }
        tvShowNumber.text = resultNumber.toString()
        isNewOp=true
    }
    private fun initializeViews() {
        tvShowNumber= findViewById(R.id.tvShowNumber)
        buAC=findViewById(R.id.buAC)
        bu2=findViewById(R.id.bu2)
        bu16=findViewById(R.id.bu16)
        bu12=findViewById(R.id.bu12)
        bu8=findViewById(R.id.bu8)
        bu4=findViewById(R.id.bu4)
        bu3=findViewById(R.id.bu3)
    }

}

