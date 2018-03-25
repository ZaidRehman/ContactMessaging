package com.coderdeer.contactmessaging

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val extras = intent.extras

        val Fname = if (savedInstanceState == null) {
             extras.getString("Fname")
        } else {
             savedInstanceState.getSerializable("Fname") as String
        }
        val Lname = if (savedInstanceState == null) {
            extras.getString("Lname")
        } else {
            savedInstanceState.getSerializable("Lname") as String
        }
        val number = if (savedInstanceState == null) {
            extras.getString("number")
        } else {
            savedInstanceState.getSerializable("number") as String
        }

        fname_tv.text = Fname
        lname_tv.text = Lname
        number_tv.text = number

        button.setOnClickListener {
            val intent = Intent(this, ComposeMessage::class.java)
            intent.putExtra("Name", Fname + " " + Lname)
            intent.putExtra("number", number)
            startActivity(intent)
        }



    }
}
