package com.example.moviemvvm.data.repository

import androidx.paging.PageKeyedDataSource
import com.example.moviemvvm.data.api.TheMovieDBInterface
import com.example.moviemvvm.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable

//we used this class because we need to load data based on page number
class MovieDataSource
    (private val apiService : TheMovieDBInterface,
     private val compositeDisposable: CompositeDisposable):
    PageKeyedDataSource<Int, Movie>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {

    }
}