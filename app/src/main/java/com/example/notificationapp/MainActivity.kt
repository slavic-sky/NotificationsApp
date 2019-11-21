package com.example.notificationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.notificationapp.api.RepositoryProvider
import com.example.notificationapp.data.MessageBody
import com.example.notificationapp.utils.extensions.isValidDateTime
import com.example.notificationapp.utils.extensions.hangAFormatWatcher
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var dateIsValid : Boolean = false
    private val API_KEY = "a8qnicp2ny9edeptyjcfxr1uxekfqa"
    private val USER_KEY = "uzhy6h56hb3ok79jpdkexbc8d83ggi"
    private val DEVICE_NAME = "device_real"
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
            addTextChangedListener { charSequence -> charSequence!!.isValidDateTime()
            }
        }

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
