package ru.fefu.activitytracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.fefu.activitytracker.databinding.ActivityHelloScreenBinding

class HelloScreen : AppCompatActivity() {
    private lateinit var binding: ActivityHelloScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initHandlers()
    }

    private fun initHandlers() {
        binding.regButton.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }
        binding.gotoLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}