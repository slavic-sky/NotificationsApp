package com.example.notificationapp.utils.extensions

import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.format.ResolverStyle
import java.util.*

class DateValidatorUsingDateTimeFormatter(private val dateFormatter: DateTimeFormatter) {
    fun isValid(dateStr: CharSequence): Boolean {
        try {
            dateFormatter.parse(dateStr)
        } catch (e: DateTimeParseException) {
            return false
        }
        return true
    }
}


