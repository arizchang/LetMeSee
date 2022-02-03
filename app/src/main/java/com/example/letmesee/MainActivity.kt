package com.example.letmesee

import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var btPlay: Button
    private lateinit var soundPool: SoundPool
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btPlay = findViewById(R.id.btPlay)
        soundPool = SoundPool(1, AudioManager.STREAM_MUSIC, 0)
        val sound = soundPool.load(this, R.raw.let_me_see, 1)
        btPlay.setOnClickListener {
            Log.i(TAG, "clicked")
            soundPool.play(sound, 1F, 1F, 0, 0, 1F)
        }
    }


}