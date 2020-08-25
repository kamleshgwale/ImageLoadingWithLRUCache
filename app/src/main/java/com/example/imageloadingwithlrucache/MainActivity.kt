package com.example.imageloadingwithlrucache

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      btn_lru.setOnClickListener {
          startActivity(Intent(this, ImageLoadLRUCache::class.java).apply {
              putExtra("check", "LRUAdapter")
          })
      }

        btn_glide.setOnClickListener {
            startActivity(Intent(this, ImageLoadLRUCache::class.java).apply {
                putExtra("check", "Glide")
            })
        }

        btn_coil.setOnClickListener {
            startActivity(Intent(this, ImageLoadLRUCache::class.java).apply {
                putExtra("check", "Coil")
            })
        }
    }
}