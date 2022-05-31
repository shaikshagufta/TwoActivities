package com.training.twoactivities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


import android.widget.TextView
import android.widget.EditText
import android.content.Intent
import android.util.Log
import android.widget.Toast


class SecondActivity : AppCompatActivity() {
    private var mReply: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.e("TAG", "CREATED2")
        Toast.makeText(applicationContext, "CREATED2", Toast.LENGTH_SHORT).show()

        mReply = findViewById(R.id.editText_second)
        val intent = intent
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message
    }

    fun returnReply(view: View?) {
        val reply = mReply!!.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }
    companion object {
        val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    }
}