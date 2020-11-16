package com.example.moviemvvm.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val API_KEY = "6e63c2317fbe963d76c3bdc2b785f6d1"
const val BASE_URL = "https://api.themoviedb.org/3/"

//poster_patch bilgisini alabileceğimiz link, bu linkin sonuna poster path
//ekleyerek posteri elde ederiz
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500/"

const val FIRST_PAGE = 1
const val POST_PER_PAGE = 20

object TheMovieDBClient {

    fun getClient(): TheMovieDBInterface{
        val requestInterceptor = Interceptor{chain ->
            //use a interceptor to put our API_KEY to our URL
            //Interceptor take only one argument which is a lambda function so
            //parenthesis can be omitted

            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request) //explicitly return a value
            // from whit @ annotation. lambda always returns the value of the last expression implicitly
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheMovieDBInterface::class.java)
    }

}