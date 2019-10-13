package com.aim2u.submissionbeginnerdicodingaldi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvAsmaulHusna: RecyclerView
    private var list: ArrayList<AsmaulHusna> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAsmaulHusna = findViewById(R.id.rv_asmaulhusna)
        rvAsmaulHusna.setHasFixedSize(true)

        list.addAll(AsmaulHusnaData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvAsmaulHusna.layoutManager = LinearLayoutManager(this)
        val listAsmaulHusnaAdapter = ListAsmaulHusnaAdapter(list)
        rvAsmaulHusna.adapter = listAsmaulHusnaAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflaterMenu = menuInflater
        inflaterMenu.inflate(R.menu.about, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.about_menu -> {
                title = "Tentang Developer"
                startActivity(Intent(this, AboutActivity::class.java))
            }
        }
    }
}
