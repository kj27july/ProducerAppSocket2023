package com.socket.producer.controllers

import android.os.Build
import android.util.Log
import com.socket.producer.utils.SmartBatteryUtil
import net.soti.xtsocket.ipc.model.Request
import net.soti.xtsocket.transform.interfaces.IType
import net.soti.xtsocket.transform.interfaces.PollFeature
import net.soti.xtsocket.transform.models.XTSType
import org.json.JSONArray
import org.json.JSONObject

class CollectionController : PollFeature() {
    override fun getData(request: Request): IType {
        Log.d("FLAG", "getData: $request")
        /*val batteriesInfo = JSONArray()
        val batteryInfo = JSONObject()
        batteryInfo.put("serialNo", 1122)*/

        return when (request.key) {
            "btyInfo" -> XTSType(Build.MODEL)
            "appInfo" -> XTSType("SampleProducer")
            "ratedCap" -> XTSType(SmartBatteryUtil.getBatteryCapacity())
            else -> XTSType(null)
        }
    }

    override fun getInfo(uniqueId: String): JSONObject {
        val configJson = JSONObject()
        configJson.put("btyInfo", Build.MODEL)
        configJson.put("appInfo", "SampleProducer")
        return configJson
    }
}
