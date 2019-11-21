package com.example.notificationapp.utils.extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser
import ru.tinkoff.decoro.watchers.FormatWatcher
import ru.tinkoff.decoro.watchers.MaskFormatWatcher

fun EditText.hangAFormatWatcher(mask: String) {
    val slots = UnderscoreDigitSlotsParser().parseSlots(mask)
    val formatWatcher: FormatWatcher = MaskFormatWatcher(
        MaskImpl.createTerminated(slots)
    )
    formatWatcher.installOn(this)
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

