package com.bonarmada.kotlearn.data.dao

import android.arch.lifecycle.LiveData
import io.realm.RealmChangeListener
import io.realm.RealmModel
import io.realm.RealmResults


/**
 * Created by bonbonme on 1/3/2018.
 */

class LiveRealmData<T: RealmModel>(private val realmResults: RealmResults<T>) : LiveData<RealmResults<T>>() {
    private val listener = RealmChangeListener<RealmResults<T>> { results -> value = results }


    override fun onActive() {
        realmResults.addChangeListener(listener)
    }

    override fun onInactive() {
        realmResults.addChangeListener(listener)
    }


}
