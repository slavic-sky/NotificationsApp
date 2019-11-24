package com.example.notificationapp.view.pages

import com.example.notificationapp.R

/**
 * Created by Gokul on 2/11/2018.
 */

enum class Model(val titleResId: Int, val layoutResId: Int) {
    INPUT(R.string.one, R.layout.fragment_input),
    LIST(R.string.two, R.layout.fragment_list)
}