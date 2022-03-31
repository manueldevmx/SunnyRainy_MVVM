package com.manueldevmx.sunnyrainy_mvvm.core

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesInstance {

    //Se declara la instancia
    val sharedPref = SharedPreferencesInstance

    //Se declara la variable para obtener las preferencias
    lateinit var sharedPreferences: SharedPreferences

    //Se declara el editor
    lateinit var editor: SharedPreferences.Editor

    //Se manda a llamar la instancia del objeto
    fun obtenerInstancia(context: Context) : SharedPreferencesInstance{
        sharedPreferences = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        return sharedPref
    }
    //Se limpian los registros
    fun limpiarPreferencias() {
        editor.clear()
        editor.apply()
    }
}