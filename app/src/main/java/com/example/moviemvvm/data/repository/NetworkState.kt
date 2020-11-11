package com.example.moviemvvm.data.repository

//An enum is a special "class"
// that represents a group of constants (unchangeable variables, like final variables).
enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

class NetworkState(val status: Status, val msg:String) {
    //we use companion object when smt to be static
    //we can call these 3 variables without creating an instance of this class
    companion object{

        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState

        init{
            LOADED = NetworkState(Status.SUCCESS, "Success")

            LOADING = NetworkState(Status.RUNNING,"Running")

            ERROR = NetworkState(Status.FAILED,"Something went wrong")
        }
    }
}