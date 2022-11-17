package com.ffescara.noteapp.network

import com.ffescara.noteapp.model.NoteModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://belajarandroid.dancok.me/v1/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiServicee {
    @GET("data.php")
    suspend fun GetNotes(): NoteModel

}

object Api {
    val ApiService: ApiServicee by lazy {
        retrofit.create(ApiServicee::class.java)
    }
}