package com.example.notificationapp.utils.extensions

import java.time.format.DateTimeFormatter
import java.time.format.ResolverStyle
import java.util.*

fun CharSequence.isValidDateTime() : Boolean {

    val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm")
            .withResolverStyle(ResolverStyle.STRICT)
    val validator = DateValidatorUsingDateTimeFormatter(dateFormatter)
    return validator.isValid(this)
}
