package com.example.jitsi_meetinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jitsi_meetinexample.databinding.ActivityMeetBinding
import org.jitsi.meet.sdk.JitsiMeetActivity

class MeetActivity : JitsiMeetActivity() {

    lateinit var binding: ActivityMeetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMeetBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}