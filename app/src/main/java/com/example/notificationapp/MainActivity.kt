package com.example.notificationapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.notificationapp.NotificationApp.Companion.context
import com.example.notificationapp.api.RepositoryProvider
import com.example.notificationapp.data.MessageBody
import com.example.notificationapp.utils.extensions.isValidDateTime
import com.example.notificationapp.utils.extensions.hangAFormatWatcher
import com.example.notificationapp.utils.extensions.toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var dateIsValid: Boolean = false
    private val API_KEY = "anxi4nfo3ur8dzuahcnfzus1siq24x"
    private val USER_KEY = "ukc9feoz1ivwneckmrnt1qyq8amhm2"
    private val DEVICE_NAME = "Nex5emul"
    private val INPUT_MASK = "__/__/__, __:__"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTimeDate = et_time_date as EditText
        val editTextMessage = et_message as EditText
        val editTextTitle = et_title as EditText
        val buttonSend = btn_send as Button
        val textView = tv_greeting as TextView

        editTextTimeDate.run {
            hangAFormatWatcher(INPUT_MASK)
            addTextChangedListener { charSequence ->
                charSequence!!.isValidDateTime()
            }
        }

        val messageBody = MessageBody(
            user = USER_KEY,
            device = DEVICE_NAME,
            token = API_KEY
        )

        buttonSend.setOnClickListener {
            messageBody.message = editTextMessage.text.toString()
            messageBody.title = editTextTitle.text.toString()

            if (messageBody.message!!.isEmpty()) {
                context.toast("type something!")
            }
            if (dateIsValid) {
                RepositoryProvider.sendMessageToDate(messageBody, editTextTimeDate.text as Date)
            } else {
                RepositoryProvider.sendMessage(messageBody)
            }
        }
    }
}

