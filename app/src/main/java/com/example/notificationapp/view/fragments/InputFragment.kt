package com.example.notificationapp.view.fragments

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.notificationapp.NotificationApp
import com.example.notificationapp.R
import com.example.notificationapp.api.networking.RepositoryProvider
import com.example.notificationapp.model.MessageBody
import com.example.notificationapp.utils.extensions.hangAFormatWatcher
import com.example.notificationapp.utils.extensions.isValidDateTime
import com.example.notificationapp.utils.extensions.toast
import kotlinx.android.synthetic.main.fragment_input.*
import java.util.*


class InputFragment : Fragment() {

    private var dateIsValid: Boolean = false
    private val INPUT_MASK = "__/__/__, __:__"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        val contextThemeWrapper: Context = ContextThemeWrapper(activity, R.style.AppTheme)
        // clone the inflater using the ContextThemeWrapper
        // clone the inflater using the ContextThemeWrapper
        val localInflater = inflater.cloneInContext(contextThemeWrapper)
        return localInflater.inflate(R.layout.fragment_input, container, false)
    }

    companion object {
        private const val ARG_PARAM1 = "page number"
        private const val ARG_PARAM2 = "title"

        fun newInstance(page: Int, title: String): Fragment {
            val fragment = InputFragment()
            val args = Bundle()
            args.putInt(ARG_PARAM1, page)
            args.putString(ARG_PARAM2, title)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        val messageBody = MessageBody()

        buttonSend.setOnClickListener {
            messageBody.message = editTextMessage.text.toString()
            messageBody.title = editTextTitle.text.toString()

            if (messageBody.message.isEmpty()) {
                NotificationApp.context.toast("type something!")
            }
            if (dateIsValid) {
                RepositoryProvider.sendMessageToDate(
                    messageBody,
                    editTextTimeDate.text as Date
                )
            } else {
                RepositoryProvider.sendMessage(messageBody)
            }
        }

    }


}