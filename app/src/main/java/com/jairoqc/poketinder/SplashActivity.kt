package com.jairoqc.poketinder
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.jairoqc.poketinder.databinding.ActivitySplashBinding
import com.rommansabbir.animationx.Attention
import com.rommansabbir.animationx.animationXAttention



class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        showAnimationLogo()
        runPostDelayed()
    }

    private fun showAnimationLogo() {
        Handler(Looper.getMainLooper()).postDelayed({
            binding.imvLogo.animationXAttention(Attention.ATTENTION_RUBERBAND)
        }, 1000)
    }


    private fun runPostDelayed() {
        Handler(Looper.getMainLooper()).postDelayed({
            goLoginActivity()
        }, 4000)
    }

    private fun goLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
