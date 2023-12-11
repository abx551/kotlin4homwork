package com.example.kotlin4homwork
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        }

    private lateinit var watssap: ImageView
    private lateinit var telefon: EditText
    private lateinit var buttonw: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        watssap = this.findViewById(R.id.watssap)
        telefon = this.findViewById(R.id.telefon)
        buttonw = this.findViewById(R.id.buttonw)

        goTowatssap()
    }

    private fun goTowatssap() {
        buttonw.setOnClickListener {
            val watssapNumber = telefon.text.toString().trim()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$watssapNumber")
            startActivity(intent)
        }
        watssap.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        getContent.launch("watssap/*")
    }
}

