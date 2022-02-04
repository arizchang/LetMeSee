package com.example.letmesee

import android.media.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var btPlay: Button
    private lateinit var soundPool: SoundPool
    private var soundStreamId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btPlay = findViewById(R.id.btPlay)
        soundPool = SoundPool.Builder().build()
        val soundId = soundPool.load(this, R.raw.let_me_see, 1)

        btPlay.setOnClickListener {
            Log.i(TAG, "clicked test")

            soundStreamId = if (soundStreamId == 0) {
                soundPool.play(soundId, 1F, 1F, 0, 0, 1F)
            } else {
                soundPool.pause(soundStreamId)
                0
            }

        }
    }


}