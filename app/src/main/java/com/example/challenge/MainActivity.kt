package com.example.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Character(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String

)
interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>
}

data class CharacterResponse(
    val results: List<Character>
)


class MainActivity : AppCompatActivity() {
    val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)


    val adapter = CharacterAdapter()

    class CharacterAdapter {

    }
    recyclerView.adapter = adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}