package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

fun main() {
    val str = readln()
    println(Calculator.RpnToAnswer(Calculator.ExpressionToRpn(str)))
}