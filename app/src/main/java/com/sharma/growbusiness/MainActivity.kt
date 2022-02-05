package com.sharma.growbusiness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        var pref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        var editor = pref.edit()
        editor.putInt("IsFirstTimeOpen", 1);
        editor.apply()
        val checker = pref.getInt("IsFirstTimeOpen", 0)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            //Delay block of 2 sec or 2000 msec
//if(checker==1){
//    val intent= Intent(this,MainActivity::class.java)
//    startActivity(intent)
//}else{
            val intent= Intent(this,InitialStartActivity::class.java)
            startActivity(intent)
//}

            finish()
        }, 600)




    }

}
