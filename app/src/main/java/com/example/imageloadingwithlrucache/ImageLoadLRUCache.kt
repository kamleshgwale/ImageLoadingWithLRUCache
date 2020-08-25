package com.example.imageloadingwithlrucache

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.bumptech.glide.Glide
import com.example.imageloadingwithlrucache.imageloader.ImageLoader

class ImageLoadLRUCache : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null


    private val imageList = arrayListOf(
        "https://images.pexels.com/photos/1722183/pexels-photo-1722183.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1920",
        "https://images.pexels.com/photos/1667580/pexels-photo-1667580.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1920",
        "https://images.pexels.com/photos/1470405/pexels-photo-1470405.jpeg?dl&fit=crop&crop=entropy&w=1280&h=853",
        "https://images.pexels.com/photos/1005417/pexels-photo-1005417.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1600",
        "https://images.pexels.com/photos/1294671/pexels-photo-1294671.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1920",
        "https://images.pexels.com/photos/1040893/pexels-photo-1040893.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1919",
        "https://images.pexels.com/photos/1956974/pexels-photo-1956974.jpeg?dl&fit=crop&crop=entropy&w=1280&h=853",
        "https://images.pexels.com/photos/1374064/pexels-photo-1374064.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1706",
        "https://images.pexels.com/photos/1931142/pexels-photo-1931142.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1919",
        "https://images.pexels.com/photos/1295036/pexels-photo-1295036.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1707",
        "https://images.pexels.com/photos/1320684/pexels-photo-1320684.jpeg?dl&fit=crop&crop=entropy&w=1920&h=1440",
        "https://images.pexels.com/photos/1908677/pexels-photo-1908677.jpeg?dl&fit=crop&crop=entropy&w=1280&h=1706"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_load_l_r_u_cache)
        var checkValue: String? = intent.getStringExtra("check")
        println("Kamlesh $checkValue")

        if(checkValue.equals("LRUAdapter"))
        {
            setTitle("LRU Cache Image Loader")
        }else if(checkValue.equals("Glide"))
        {
            setTitle("Glide Image Loader")
        }else if(checkValue.equals("Coil"))
        {
            setTitle("Coil Image Loader")
        }
        recyclerView = findViewById(R.id.recyclerView)

        // recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = GridLayoutManager(this, 2)
        recyclerView?.adapter = ImageAdapter(imageList, this,checkValue)
    }
}