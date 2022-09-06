package com.sebqv97.myselfpromoteapp

import android.content.Intent
import android.content.Intent.ACTION_SENDTO
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview_message_actity.*

class PreviewMessageActivity : AppCompatActivity() {
   private lateinit var  messageGenerated:Message
    private lateinit var messageTemplate:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview_message_actity)

        displayMessage()

        setupButton()

    }

    private fun setupButton() {
       button_send_message.setOnClickListener {
           val sendMessageIntent = Intent(Intent.ACTION_SENDTO).apply {
               data = Uri.parse("smsto: ${messageGenerated.ContactNumber}")
               putExtra("sms_body",messageTemplate)
           }
           startActivity(sendMessageIntent)
       }
    }

    private fun displayMessage() {
         messageGenerated = intent.getSerializableExtra("Message") as Message
         messageTemplate = """
                Hi ${messageGenerated.ContactName},
                
                My name is ${messageGenerated.DisplayName}, I am ${messageGenerated.getFullJobDescription()}.
                
                I have a portfolio of apps to demonstrate my technical skills that I can show on request.
                
                I am able to start a position ${messageGenerated.getAvailability()}.
                
                Please let me know if you have any suitable role for me. 
                     Thanks, 
                            ${messageGenerated.DisplayName}
            """.trimIndent()

        text_view_message.text = messageTemplate
    }
}