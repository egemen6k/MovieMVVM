package com.example.moviemvvm.data.api

import com.example.moviemvvm.data.vo.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDBInterface {

    // https://api.themoviedb.org/3/movie/340102?api_key=460236bbc97ef75f090c333564bf3b16
    // https://api.themoviedb.org/3/movie/popular?api_key=460236bbc97ef75f090c333564bf3b16
    // https://api.themoviedb.org/3/

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id")id: Int) : Single<MovieDetails>
}