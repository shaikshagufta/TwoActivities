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
    override fun onStart() {
        super.onStart()
        Log.d("TAG", "STARTED2")
        Toast.makeText(applicationContext, "STARTED2",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "RESUMED2")
        Toast.makeText(applicationContext, "RESUMED2",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "PAUSED2")
        Toast.makeText(applicationContext, "PAUSED2",Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Log.d("TAG", "STOPPED2")
        Toast.makeText(applicationContext, "STOPPED2",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "DESTROYED2")
        Toast.makeText(applicationContext, "DESTROYED2",Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("TAG", "RESTARTED2")
        Toast.makeText(applicationContext, "RESTARTED2",Toast.LENGTH_SHORT).show()
    }
    companion object {
        val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    }
}