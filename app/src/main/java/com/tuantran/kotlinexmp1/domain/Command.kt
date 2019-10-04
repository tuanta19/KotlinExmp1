package com.tuantran.kotlinexmp1.domain

public interface Command<out T>{
    fun execute(): T
}