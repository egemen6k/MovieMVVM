package com.example.moviemvvm.data.repository

//An enum is a special "class"
// that represents a group of constants (unchangeable variables, like final variables).
//3 tane statik değer tutan ve isimleri aşağıda yazan bir class tipi
//Status.RUNNING diyerek bu constant değere ulaşabiliyoruz
enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

class NetworkState(val status: Status, val msg:String) {
    //we use companion object when smt to be static
    //we can call these 3 variables without creating an instance of this class
    //singleton object
    companion object{

        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState
        val ENDOFLIST: NetworkState

        init{
            LOADED = NetworkState(Status.SUCCESS, "Success")

            LOADING = NetworkState(Status.RUNNING,"Running")

            ERROR = NetworkState(Status.FAILED,"Something went wrong")

            ENDOFLIST = NetworkState(Status.FAILED,"You have reached the end")
        }
    }
}