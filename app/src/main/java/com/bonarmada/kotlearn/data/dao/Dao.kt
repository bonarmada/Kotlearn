package com.bonarmada.kotlearn.data.dao

import io.realm.RealmModel


/**
 * Created by bonbonme on 12/7/2017.
 */

interface Dao<T> {

    val id: Int?

    fun get(): List<T>

    fun get(id: Int): T?

    fun save(item: T): RealmModel

    fun save(items: Collection<T>)

    fun clear()

    fun delete(id: Int)

    fun delete(items: Collection<T>)

    fun count(): Int?
}
