package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button




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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

}

