package com.kotlin.aplaza.mvpkotlin.domain

/**
 * Created by pla on 30/03/2018.
 */
public interface Command<out T> {
    fun execute(): T
}