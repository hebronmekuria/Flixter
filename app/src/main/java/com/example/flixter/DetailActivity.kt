package com.example.flixter

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    private lateinit var Title : TextView
    private lateinit var Desc : TextView
    private lateinit var Image : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

        Title = findViewById(R.id.mvTitle)
        Desc = findViewById(R.id.mvDescription)
        Image = findViewById(R.id.mvPoster)

        //Toast.makeText(this@DetailActivity, "You clicked on the item", Toast.LENGTH_SHORT).show()
        val bundle : Bundle? = intent.extras

        val title = bundle!!.getString("MovieTitle")
        val desc = bundle!!.getString("MovieOverview")
        val image = bundle!!.getString("MovieImage")

        Title.text = title
        Desc.text = desc

        Glide.with(this).load(IMAGE_BASE + image).into(Image)


    }
}
