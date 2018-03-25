package com.coderdeer.contactmessaging

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_message.*
import android.content.pm.PackageManager
import android.util.Log


class ComposeMessage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)


        val extras = intent.extras

        name_tv.text = if (savedInstanceState == null) {
            extras.getString("Name")
        } else {
            savedInstanceState.getSerializable("Name") as String
        }
        val otp_number = (100000..999999).random()

        val number = if (savedInstanceState == null) {
            extras.getString("number")
        } else {
            savedInstanceState.getSerializable("number") as String
        }

        message_et.setText("Hi. Your OTP is:$otp_number", TextView.BufferType.EDITABLE)


        val smsManager = SmsManager.getDefault()
        button_send_message.setOnClickListener{

            val PERMISSION_REQUEST_CODE = 1

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

                if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {

                    Log.d("permission", "permission denied to SEND_SMS - requesting it")
                    val permissions = arrayOf<String>(Manifest.permission.SEND_SMS)

                    requestPermissions(permissions, PERMISSION_REQUEST_CODE)
                    //smsManager.sendTextMessage(number, null, message_et.text.toString(), null, null)

                }

            }else{
                smsManager.sendTextMessage(number, null, message_et.text.toString(), null, null)
            }
        }

    }
}
