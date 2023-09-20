package com.socket.producer.features

import net.soti.xtsocket.transform.enums.FeatureType
import net.soti.xtsocket.transform.enums.ReturnType
import net.soti.xtsocket.transform.models.Feature

object DataList {
    fun get(): List<Feature> {
        val features = ArrayList<Feature>()

        features.add(
            Feature("ratedCap", ReturnType.INTEGER, featureType = FeatureType.POLL)
        )
        features.add(
            Feature("btyInfo", ReturnType.STRING, featureType = FeatureType.POLL)
        )
        features.add(
            Feature("appInfo", ReturnType.STRING, featureType = FeatureType.POLL)
        )

        return features
    }
}
