package com.kotlin.aplaza.mvpkotlin.ui.utils

/**
 * Created by pla on 15/04/2018.
 */
fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
        Array<out Pair<K, V>> = map({ Pair(it.key, it.value!!) }).toTypedArray()