package com.example.notificationapp.view.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notificationapp.databinding.FragmentListBinding
import com.example.notificationapp.utils.InjectorUtils
import com.example.notificationapp.view.adapters.ListPostsAdapter
import com.example.notificationapp.viewmodel.PostsViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListPostsFragment : Fragment() {

    companion object {
        private const val ARG_PARAM1 = "page number"
        private const val ARG_PARAM2 = "title"

        fun newInstance(page: Int, title: String): Fragment {
            val fragment = ListPostsFragment()
            val args = Bundle()
            args.putInt(ARG_PARAM1, page)
            args.putString(ARG_PARAM2, title)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBinding.inflate(inflater, container, false)
        context ?: binding.root

        val adapter = ListPostsAdapter()
        binding.listNotifications.layoutManager = LinearLayoutManager(activity)
        binding.listNotifications.adapter = adapter
        postsViewModel.getPostsLiveData().observe(this, Observer(adapter::loadNotification))
        return binding.root
    }

    val LOG_TAG = "myLogs"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(LOG_TAG, "Fragment2 onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "Fragment2 onCreate")
    }

    private fun initRecycler() {
       val adapter = ListPostsAdapter()
        list_notifications.layoutManager = LinearLayoutManager(activity)
        list_notifications.adapter = adapter

        postsViewModel.getPostsLiveData().observe(this, Observer {
            adapter.loadNotification(it)
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(LOG_TAG, "Fragment2 onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "Fragment2 onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "Fragment2 onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "Fragment2 onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "Fragment2 onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LOG_TAG, "Fragment2 onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "Fragment2 onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(LOG_TAG, "Fragment2 onDetach")
    }
}