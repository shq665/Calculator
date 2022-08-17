package com.example.myapplication

import java.util.*

object Calculator {
    private fun expressionToRpn(expr: String): String {
        var current = ""
        val stack = Stack<Char>()
        for (i in 0 until expr.length) {
            val priority = getPriority(expr[i])
            if (priority == 0) current += expr[i]
            if (priority == 1) stack.push(expr[i])
            if (priority > 1) {
                current += ' '
                while (!stack.empty()) {
                    current += if (getPriority(stack.peek()) >= priority) stack.pop() else break
                }
                stack.push(expr[i])
            }
            if (priority == -1) {
                current += ' '
                while (getPriority(stack.peek()) != 1) current += stack.pop()
                stack.pop()
            }
        }
        while (!stack.empty()) {
            current += stack.pop()
        }
        return current
    }

    private fun rpnToAnswer(rpn: String): Double {
        var oper = String()
        val stack = Stack<Double>()
        var i = 0
        while (i < rpn.length) {
            if (rpn[i] == ' ') {
                i++
                continue
            }
            if (getPriority(rpn[i]) == 0) {
                while (rpn[i] != ' ' && getPriority(rpn[i]) == 0) {
                    oper += rpn[i++]
                    if (i == rpn.length) break
                }
                stack.push(oper.toDouble())
                oper = String()
            }
            if (getPriority(rpn[i]) > 1) {
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

    private fun getPriority(token: Char): Int {
        return when (token) {
            '*', '/' -> 3
            '+', '-' -> 2
            '(' -> 1
            ')' -> -1
            else -> 0
        }
    }

    fun result(string: String): String {
        try {
            return rpnToAnswer(expressionToRpn(string)).toString()
        } catch (e: EmptyStackException) {
            return ""
        }
    }
}
