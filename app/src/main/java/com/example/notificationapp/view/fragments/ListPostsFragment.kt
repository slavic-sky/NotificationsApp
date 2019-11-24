package com.example.notificationapp.view.fragments

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class ListPostsFragment : Fragment() {
    companion object {
        private val ARG_PARAM1 = "page number"
        private val ARG_PARAM2 = "title"

        fun newInstance(page: Int, title: String): Fragment {
            val fragment = ListPostsFragment()
            val args = Bundle()
            args.putInt(ARG_PARAM1, page)
            args.putString(ARG_PARAM2, title)
            fragment.arguments = args
            return fragment
        }
    }
}