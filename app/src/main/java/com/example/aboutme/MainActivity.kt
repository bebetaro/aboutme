package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("bebetaro")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        findViewById<Button>(R.id.done).setOnClickListener { addNickName(it) }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.done.setOnClickListener { addNickName(it) }
        binding.myName = myName
    }

    private fun addNickName(view: View) {
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)
        binding.apply {
//        binding.nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = binding.nicknameEdit.text.toString()
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.done.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }


//        nickNameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nickNameTextView.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
