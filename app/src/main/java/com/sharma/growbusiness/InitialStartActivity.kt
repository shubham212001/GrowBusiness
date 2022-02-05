package com.sharma.growbusiness

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_initial_start.*


class InitialStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial_start)
        supportActionBar?.hide()

  save_and_next.setOnClickListener {

      var pref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
      var editor = pref.edit()
      var firm_name_variable=FirmName.text.toString()
      editor.putString("FirmName",firm_name_variable)
      editor.apply()
      val intent= Intent(this,dashBoard::class.java)
      startActivity(intent)
      finish()
  }


        }
    }
