package com.example.myapplication

import com.example.myapplication.Calculator
import java.util.*

object Calculator {
    fun ExpressionToRpn(expr: String): String {
        var current = ""
        val stack = Stack<Char>()
        var priority: Int
        for (i in 0 until expr.length) {
            priority = getP(expr[i])
            if (priority == 0) current += expr[i]
            if (priority == 1) stack.push(expr[i])
            if (priority > 1) {
                current += ' '
                while (!stack.empty()) {
                    current += if (getP(stack.peek()) >= priority) stack.pop() else break
                }
                stack.push(expr[i])
            }
            if (priority == -1) {
                current += ' '
                while (getP(stack.peek()) != 1) current += stack.pop()
                stack.pop()
            }
        }
        while (!stack.empty()) current += stack.pop()
        return current
    }

    fun RpnToAnswer(rpn: String): Double {
        var oper = String()
        val stack = Stack<Double>()
        var i = 0
        while (i < rpn.length) {
            if (rpn[i] == ' ') {
                i++
                continue
            }
            if (getP(rpn[i]) == 0) {
                while (rpn[i] != ' ' && getP(rpn[i]) == 0) {
                    oper += rpn[i++]
                    if (i == rpn.length) break
                }
                stack.push(oper.toDouble())
                oper = String()
            }
            if (getP(rpn[i]) > 1) {
                val x = stack.pop()
                val y = stack.pop()
                if (rpn[i] == '+') stack.push(y + x)
                if (rpn[i] == '-') stack.push(y - x)
                if (rpn[i] == '*') stack.push(y * x)
                if (rpn[i] == '/') stack.push(y / x)
            }
            i++
        }
        return stack.pop()
    }

    private fun getP(token: Char): Int {
        return if (token == '*' || token == '/') 3
        else if (token == '+' || token == '-') 2
        else if (token == '(') 1
        else if (token == ')') -1
        else 0
    }
}
