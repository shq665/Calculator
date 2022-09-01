package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentCalculatorBinding


class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding: FragmentCalculatorBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentCalculatorBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            button0.setOnClickListener {
                with(binding) { textView.append((button0.text))}
            }
            button1.setOnClickListener {
                with(binding) { textView.append(button1.text) }
            }
            button2.setOnClickListener {
                with(binding) { textView.append(button2.text) }
            }
            button3.setOnClickListener {
                with(binding) { textView.append(button3.text) }
            }
            button4.setOnClickListener {
                with(binding) { textView.append(button4.text) }
            }
            button5.setOnClickListener {
                with(binding) { textView.append(button5.text) }
            }
            button6.setOnClickListener {
                with(binding) { textView.append(button6.text) }
            }
            button7.setOnClickListener {
                with(binding) { textView.append(button7.text) }
            }
            button8.setOnClickListener {
                with(binding) { textView.append(button8.text) }
            }
            button9.setOnClickListener {
                with(binding) { textView.append(button9.text) }
            }
            buttonBracketLeft.setOnClickListener {
                with(binding) { textView.append(buttonBracketLeft.text) }
            }
            buttonBracketRight.setOnClickListener {
                with(binding) { textView.append(buttonBracketRight.text) }
            }
            buttonAc.setOnClickListener {
                null.also { binding.textView.text = it }
            }
            buttonDelete.setOnClickListener {
                val string: String = binding.textView.text.toString()
                binding.textView.text.substring(0, string.length - 1)
                    .also { binding.textView.text = it }
            }
            buttonDivide.setOnClickListener {
                with(binding) { textView.append(buttonDivide.text) }
            }
            buttonMultiply.setOnClickListener {
                with(binding) { textView.append(buttonMultiply.text) }
            }
            buttonMinus.setOnClickListener {
                with(binding) { textView.append(buttonMinus.text) }
            }
            buttonPlus.setOnClickListener {
                with(binding) { textView.append(buttonPlus.text) }
            }
            buttonDot.setOnClickListener {
                with(binding) { textView.append(buttonDot.text) }
            }
            buttonEquals.setOnClickListener {
                val result: String = Calculator.result(binding.textView.text.toString())
                binding.textView.text = result
                if (result == "") {
                    Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}