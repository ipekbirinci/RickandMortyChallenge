package com.example.challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
    private lateinit var logo: ImageView
    private lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logo = findViewById(R.id.splash_logo)
        text = findViewById(R.id.splash_text)
        // SharedPreferences kullanarak kullanıcının uygulamayı ilk kez açıp açmadığını kontrol edin
        val prefs = getSharedPreferences("prefs", MODE_PRIVATE)
        val firstStart = prefs.getBoolean("firstStart", true)

        // İlk açılışta karşılama mesajını "Welcome!" olarak ayarlayın
        if (firstStart) {
            text.text = "Welcome!"
            val editor = prefs.edit()
            editor.putBoolean("firstStart", false)
            editor.apply()
        } else {
            // İkinci ve sonraki açılışlarda karşılama mesajını "Hello!" olarak ayarlayın
            text.text = "Hello!"
        }

        // 2 saniye sonra MainActivity'ye geçiş yapın
        Handler().postDelayed({
            //MainActivity gelecek
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)


    }
}