package com.socket.producer.controllers

import android.content.Context
import android.util.Log
import net.soti.xtsocket.error.exceptions.SchemaException
import net.soti.xtsocket.transform.feature.FeatureDirectory
import com.socket.producer.features.DataList

object XtsBuilder {
    /*** Build schema based on provided version, [DataList.get] etc. */
    fun build(context: Context) {
        try {
            FeatureDirectory.Builder(context)
                .version(2)
//                .disableDataValidation()
                .advertiseDataList(DataList.get())
                .build(CollectionController())
        } catch (e: SchemaException) {
            Log.e("Socket", "build: $e")
        }
    }
}
