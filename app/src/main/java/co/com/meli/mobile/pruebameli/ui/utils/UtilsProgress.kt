package co.com.meli.mobile.pruebameli.ui.utils

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import co.com.meli.mobile.pruebameli.R

class UtilsProgress {

    companion object {


        fun dialogProgressDialog(context: Context?): Dialog {
            val dialog = Dialog(context!!)
            val inflate = LayoutInflater.from(context).inflate(R.layout.progress, null)
            dialog.setContentView(inflate)
            dialog.setCancelable(false)

            return dialog

        }
    }
}