package com.example.notificationapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notificationapp.databinding.FragmentListBinding
import com.example.notificationapp.view.adapters.ListPostsAdapter
import com.example.notificationapp.viewmodel.PostsViewModel
import com.example.notificationapp.viewmodel.Status
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

class ListPostsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val postsViewModel: PostsViewModel by viewModels {
        viewModelFactory
    }

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
        postsViewModel.getPostsLiveData().observe(this, Observer {
            when (it.status){
                Status.LOADING -> toast("loading")
                Status.SUCCESS -> adapter.loadNotification(it.data)
                Status.ERROR -> it.error?.let { toast("an error occured") }
            }
        })
        return binding.root
    }

/*    private fun initRecycler() {
       val adapter = ListPostsAdapter()
        list_notifications.layoutManager = LinearLayoutManager(activity)
        list_notifications.adapter = adapter

        postsViewModel.getPostsLiveData().observe(this, Observer {
            adapter.loadNotification(it)
        })
    }*/
}