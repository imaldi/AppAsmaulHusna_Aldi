package com.aim2u.submissionbeginnerdicodingaldi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_detail_asmaul_husna.*

class DetailAsmaulHusnaActivity : AppCompatActivity() {
    private lateinit var imageAsmaulHusna: ImageView
    private lateinit var textAsmaulHusna: TextView
    private lateinit var textTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_asmaul_husna)

        imageAsmaulHusna = findViewById(R.id.image_asmaul_husna)
        textAsmaulHusna = findViewById(R.id.tvContent)
        textAsmaulHusna.setText(intent.getStringExtra("detail"))
        textTitle = findViewById(R.id.judul_halaman)
        textTitle.setText(intent.getStringExtra("nama"))
        //toolbar = findViewById(R.id.toolbar)
        //appbar_title = findViewById(R.id.title_toolbar)

        //setSupportActionBar(toolbar)
        //supportActionBar?.title = ""
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)


        //val appBar_title = intent.getStringExtra("nama")
        val imgURL:String = intent.getStringExtra("img_url")
        Glide.with(this)
            .load(imgURL)
            .apply(RequestOptions().override(800,800))
            .into(imageAsmaulHusna)

        //appbar_title.setText(appBar_title)
    }
}
