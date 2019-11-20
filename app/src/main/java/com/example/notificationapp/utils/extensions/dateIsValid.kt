package com.example.notificationapp.utils.extensions

import java.time.format.DateTimeFormatter
import java.time.format.ResolverStyle
import java.util.*

fun Date.dateIsValid(date : String?) : Boolean {
    val dateFormatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern("uuuu-MM-dd hh:mm", Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT)
    var validator = DateValidatorUsingDateTimeFormatter(dateFormatter)
    return validator.isValid(date)
}
