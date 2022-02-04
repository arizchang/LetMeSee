package com.example.letmesee

import android.media.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var btPlay: Button
    private lateinit var btDattebayo: Button
    private lateinit var soundPool: SoundPool
    private var soundStreamIdLms: Int = 0
    private var soundStreamIdDattebayo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btPlay = findViewById(R.id.btPlay)
        btDattebayo = findViewById(R.id.btDattebayo)
        soundPool = SoundPool.Builder().build()
        val soundIdLms = soundPool.load(this, R.raw.let_me_see, 1)
        val soundIdDattebayo = soundPool.load(this, R.raw.dattebayo, 1)

        btPlay.setOnClickListener {
            Log.i(TAG, "let me see")

            if (soundStreamIdLms == 0) {
                soundStreamIdLms = soundPool.play(soundIdLms, 1F, 1F, 0, 0, 1F)
                Toast.makeText(this.applicationContext, "Xiao Wei Xiao speaking...", Toast.LENGTH_SHORT).show()
            }
            else {
                soundPool.pause(soundStreamIdLms)
                0
            }
            soundStreamIdLms = 0
        }

        btDattebayo.setOnClickListener {
            Log.i(TAG, "dattebayo")

            if (soundStreamIdDattebayo == 0) {
                soundStreamIdDattebayo = soundPool.play(soundIdDattebayo, 1F, 1F, 0, 0, 1F)
                Toast.makeText(this.applicationContext, "Naruto speaking...", Toast.LENGTH_SHORT).show()
            }
            else {
                soundPool.pause(soundStreamIdDattebayo)
                0
            }
            soundStreamIdDattebayo = 0

        }
    }


}