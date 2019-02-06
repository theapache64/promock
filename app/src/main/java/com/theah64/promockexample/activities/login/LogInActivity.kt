package com.theah64.promockexample.activities.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.theah64.promock.ProMock
import com.theah64.promockexample.R
import kotlinx.android.synthetic.main.activity_login.*

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Setting mock values
        til_username.editText!!.setText(ProMock.getString(R.id.username))
        til_password.editText!!.setText(ProMock.getString(R.id.password))

        b_login.setOnClickListener {
            val message = "Username : ${til_username.editText!!.text}\n Password : ${til_password.editText!!.text}"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
