package Util

import android.content.Context
import android.view.View
import android.widget.Toast
import kotlin.math.roundToInt

fun Context.shortToast(messege: String) {
    Toast.makeText(this, messege, Toast.LENGTH_SHORT).show()
}

fun View.px(dp: Int) {
    (dp * resources.displayMetrics.density).roundToInt()
}