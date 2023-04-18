package com.example.taller_0202

import org.json.JSONException
import org.json.JSONObject
import java.util.*

class MyLocation(var fecha: Date, var latitud: Double, var
longitud: Double) {
    fun toJSON(): JSONObject {
        val obj = JSONObject()
        try {
            obj.put("latitud", latitud)
            obj.put("longitud", longitud)
            obj.put("date", fecha)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return obj
    }
}