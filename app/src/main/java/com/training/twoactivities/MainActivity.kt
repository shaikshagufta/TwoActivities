package com.training.twoactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.content.Intent
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var mMessageEditText: EditText? = null
    private var mReplyHeadTextView: TextView? = null
    private var mReplyTextView: TextView? = null

    // Called when the activity is first created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("TAG", "CREATED1")
        Toast.makeText(applicationContext , "CREATED1",Toast.LENGTH_SHORT).show()

        // Initialize all the view variables.
        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)
    }

    fun launchSecondActivity(view: View?) {
        Log.e(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText!!.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST);
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int, data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data!!.getStringExtra(SecondActivity.EXTRA_REPLY)
                mReplyHeadTextView!!.visibility = View.VISIBLE
                mReplyTextView!!.text = reply
                mReplyTextView!!.visibility = View.VISIBLE
            }
        }
    }

    // Called when the activity is about to become visible.
    override fun onStart() {
        super.onStart()
        Log.e("TAG", "STARTED1")
        Toast.makeText(applicationContext, "STARTED1",Toast.LENGTH_SHORT).show()
    }

    // Called when the activity has become visible.
    override fun onResume() {
        super.onResume()
        Log.e("TAG", "RESUMED1")
        Toast.makeText(applicationContext, "RESUMED1",Toast.LENGTH_SHORT).show()
    }

    // Called when another activity is taking focus.
    override fun onPause() {
        super.onPause()
        Log.e("TAG", "PAUSED1")
        Toast.makeText(applicationContext, "PAUSED1",Toast.LENGTH_SHORT).show()
    }

    // Called when the activity is no longer visible.
    override fun onStop() {
        super.onStop()
        Log.e("TAG", "STOPPED1")
        Toast.makeText(applicationContext, "STOPPED1",Toast.LENGTH_SHORT).show()
    }

    // Called just before the activity is destroyed.
    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "DESTROYED1")
        Toast.makeText(applicationContext, "DESTROYED1",Toast.LENGTH_SHORT).show()
    }

    // Called when the activity is about to become visible after it was stopped.
    override fun onRestart() {
        super.onRestart()
        Log.e("TAG", "RESTARTED1")
        Toast.makeText(applicationContext, "RESTARTED1",Toast.LENGTH_SHORT).show()
    }

    companion object {
        // Class name for Log tag
        private val LOG_TAG = MainActivity::class.java.simpleName

        // Unique tag required for the intent extra
        const val EXTRA_MESSAGE = "com.example.android.activities.extra.MESSAGE"

        // Unique tag for the intent reply
        const val TEXT_REQUEST = 1
    }
}
/*1. onCreate()

2. onStart()

3. onResume()

4. onPause()

5. onStop()

6. onDestroy()*/