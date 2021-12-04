package Util

import android.content.Context
import android.widget.Toast

fun Context.shortToast(messege: String) {
    Toast.makeText(this,messege,Toast.LENGTH_SHORT).show()
}

