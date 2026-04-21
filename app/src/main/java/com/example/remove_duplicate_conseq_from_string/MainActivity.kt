package com.example.remove_duplicate_conseq_from_string

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Stack

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets // IMPORTANT
        }

        val inputText = findViewById<EditText>(R.id.inputText)
        val btnStringBuilder = findViewById<Button>(R.id.btnStringBuilder)
        val btnStack = findViewById<Button>(R.id.btnStack)
        val outputText = findViewById<TextView>(R.id.outputText)

        // StringBuilder Approach
        btnStringBuilder.setOnClickListener {
            val input = inputText.text.toString()

            if (input.isEmpty()) {
                Toast.makeText(this, "Enter a string", Toast.LENGTH_SHORT).show()
            } else {
                val result = removeDuplicatesUsingStringBuilder(input)
                outputText.text = result
            }
        }

        // Stack Approach
        btnStack.setOnClickListener {
            val input = inputText.text.toString()

            if (input.isEmpty()) {
                Toast.makeText(this, "Enter a string", Toast.LENGTH_SHORT).show()
            } else {
                val result = removeDuplicatesUsingStack(input)
                outputText.text = result
            }
        }
    }

    // ✅ Approach 1: StringBuilder
    private fun removeDuplicatesUsingStringBuilder(input: String): String {
        val result = StringBuilder()

        for (ch in input) {
            if (result.isEmpty() || result[result.length - 1] != ch) {
                result.append(ch)
            }
        }

        return result.toString()
    }

    // ✅ Approach 2: Stack
    private fun removeDuplicatesUsingStack(input: String): String {
        val stack = Stack<Char>()

        for (ch in input) {
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch)
            }
        }

        val result = StringBuilder()
        for (ch in stack) {
            result.append(ch)
        }

        return result.toString()
    }
}