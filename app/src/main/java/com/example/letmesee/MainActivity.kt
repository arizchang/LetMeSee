package com.example.letmesee

import android.media.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

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

            soundStreamIdLms = if (soundStreamIdLms == 0) {
                soundPool.play(soundIdLms, 1F, 1F, 0, 0, 1F)
            } else {
                soundPool.pause(soundStreamIdLms)
                0
            }
            soundStreamIdLms = 0
        }

        btDattebayo.setOnClickListener {
            Log.i(TAG, "dattebayo")

            soundStreamIdDattebayo = if (soundStreamIdDattebayo == 0) {
                soundPool.play(soundIdDattebayo, 1F, 1F, 0, 0, 1F)
            } else {
                soundPool.pause(soundStreamIdDattebayo)
                0
            }
            soundStreamIdDattebayo = 0

        }
    }


}