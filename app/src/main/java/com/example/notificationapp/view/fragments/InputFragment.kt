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
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.notificationapp.NotificationApp
import com.example.notificationapp.R
import com.example.notificationapp.data.model.NotificationMessage
import com.example.notificationapp.utils.INPUT_MASK
import com.example.notificationapp.utils.extensions.hangAFormatWatcher
import com.example.notificationapp.utils.extensions.isValidDateTime
import com.example.notificationapp.utils.extensions.toast
import com.example.notificationapp.viewmodel.PostListViewModel
import kotlinx.android.synthetic.main.fragment_input.*
import timber.log.Timber
import javax.inject.Inject

class InputFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var dateIsValid: Boolean = false

    val postListViewModel: PostListViewModel by viewModels{
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contextThemeWrapper: Context = ContextThemeWrapper(activity, R.style.AppTheme)
        val localInflater = inflater.cloneInContext(contextThemeWrapper)
        return localInflater.inflate(R.layout.fragment_input, container, false)
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

        val messageBody = NotificationMessage()

        buttonSend.setOnClickListener {
            messageBody.message = editTextMessage.text.toString()
            messageBody.title = editTextTitle.text.toString()

            if (messageBody.message.isNotEmpty()) {
                postListViewModel.sendMessage(messageBody)
            } else {
                NotificationApp.context.toast("type something!")
            }

/*            if (dateIsValid) {
                RepositoryProvider.sendMessageToDate(
                    messageBody,
                    editTextTimeDate.text as Date
                )
            } else {*/
            //}
        }
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

    val LOG_TAG = "myLogs"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.tag(LOG_TAG).d("Fragment1 onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "Fragment1 onCreate")
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(LOG_TAG, "Fragment1 onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "Fragment1 onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "Fragment1 onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "Fragment1 onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "Fragment1 onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LOG_TAG, "Fragment1 onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "Fragment1 onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(LOG_TAG, "Fragment1 onDetach")
    }

}