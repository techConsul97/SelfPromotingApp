package com.sebqv97.myselfpromoteapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //set clickListener for SeePreview button
        button_see_preview.setOnClickListener {
            seePreview()

        }

        //creating a spinner
        val jobTitles :Array<String> = arrayOf("Software Engineer","Android Developer")
        val spinnerAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,jobTitles)
        spinner_job_title.adapter = spinnerAdapter

    }

    private fun seePreview() {
        startActivity(createIntent())
    }

    private fun createIntent(): Intent {
        val previewActivityIntent = Intent(this, PreviewMessageActivity::class.java).apply {
            this.putExtra(
                "Message", Message(
                    edit_text_contact_name.text.toString(),
                    edit_text_contact_number.text.toString(),
                    edit_text_displayed_name.text.toString(),
                    checkbox_include_junior.isChecked,
                    spinner_job_title.selectedItem?.toString(),
                    checkbox_available_now.isChecked,
                    edit_text_available_from.text?.toString()
                )
            )
        }
        return previewActivityIntent
    }


}