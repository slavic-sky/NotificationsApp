package com.example.notificationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.notificationapp.api.RepositoryProvider
import com.example.notificationapp.data.MessageBody
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import java.util.*

class MainActivity : AppCompatActivity() {

    private var dateIsValid : Boolean = false
    private val API_KEY = "a8qnicp2ny9edeptyjcfxr1uxekfqa"
    private val USER_KEY = "uzhy6h56hb3ok79jpdkexbc8d83ggi"
    private val DEVICE_NAME = "device_real"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTimeDate = et_time_date as EditText
        val editTextMessage = et_message as EditText
        val editTextTitle = et_title as EditText
        val buttonSend = btn_send as Button
        val textView = tv_greeting as TextView

        val messageBody = MessageBody(
            message = editTextMessage.text.toString(),
            title = editTextTitle.text.toString(),
            user = USER_KEY,
            device = DEVICE_NAME,
            token = API_KEY
        )

        buttonSend.setOnClickListener {
            if (messageBody.message != null) {
                if (dateIsValid) {
                    RepositoryProvider.sendMessageToDate(messageBody, editTextTimeDate.text as Date)
                } else {
                    RepositoryProvider.sendMessage(messageBody)
                }
            }
        }
    }
}
