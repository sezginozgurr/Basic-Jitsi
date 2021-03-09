package com.example.jitsi_meetinexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jitsi_meetinexample.databinding.ActivityMainBinding
import com.facebook.react.modules.core.PermissionListener
import org.jitsi.meet.sdk.*
import java.net.URL

class MainActivity : AppCompatActivity(),JitsiMeetActivityInterface {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnJoin.setOnClickListener {
            val view = JitsiMeetView(this@MainActivity)
            val option = JitsiMeetConferenceOptions.Builder()
                .setServerURL(URL("https://meet.jit.si"))
                .setRoom("https://meet.jit.si/ObviousTroublesFoldWrong") //jitsiden link almayı unutma
                .setVideoMuted(true)
                .setAudioMuted(true)
                .setAudioOnly(true)
                .setWelcomePageEnabled(false)
                .build()
            view.join(option)
            setContentView(view)
        }
    }

    override fun onResume() {
        super.onResume()
        JitsiMeetActivityDelegate.onHostResume(this);
    }

    override fun onStop() {
        super.onStop()
        JitsiMeetActivityDelegate.onHostPause(this);
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        JitsiMeetActivityDelegate.onNewIntent(intent)
    }

    override fun requestPermissions(p0: Array<out String>?, p1: Int, p2: PermissionListener?) {
        //
    }
}