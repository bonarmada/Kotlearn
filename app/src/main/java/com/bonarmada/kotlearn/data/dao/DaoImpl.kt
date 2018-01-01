package com.bonarmada.kotlearn.data.dao

import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmObject


/**
 * Created by bonbonme on 12/7/2017.
 */


open class DaoImpl<Type : RealmObject>(private val type: Class<Type>) : Dao<Type> {
    private val realm = Realm.getDefaultInstance()

    override val id: Int?
        get() {
            val nextId = realm.where(type).max("id")

            nextId?.let {
                return it.toInt()
            }
            return null
        }

    override fun get(): List<Type> {
        val all = realm.where(type).findAll()
        return all.subList(0, all.size)
    }

    override fun get(id: Int): Type? {
        return realm.where(type).equalTo("id", id).findFirst();
    }

    override fun save(item: Type): RealmModel {
        realm.beginTransaction()
        val result = realm.copyToRealmOrUpdate(item);
        realm.commitTransaction()

        return result
    }

    override fun save(items: Collection<Type>) {
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(items)
        realm.commitTransaction()
    }

    override fun clear() {
        realm.beginTransaction()
        val all = realm.where(type).findAll()
        all.deleteAllFromRealm()
        realm.commitTransaction()
    }

    override fun delete(id: Int) {
        realm.executeTransaction { realm ->
            val all = realm.where(type).equalTo("id", id).findAll()
            all.deleteAllFromRealm()
        }
    }

    override fun delete(items: Collection<Type>) {
        realm.executeTransaction { realm ->
            val all = realm.where(type).findAll()
            all.deleteAllFromRealm()
        }
    }

    override fun count(): Int? {
        return get().size
    }
}