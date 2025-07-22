package com.flashpay.ui.msdk.sample.domain.mappers

import com.flashpay.msdk.ui.threeDSecure.EcmpThreeDSecureShippingInfo
import com.flashpay.ui.msdk.sample.data.storage.entities.threeDSecure.customer.Shipping

internal fun Shipping.map(): EcmpThreeDSecureShippingInfo =
    EcmpThreeDSecureShippingInfo(
        type = type,
        deliveryTime = deliveryTime,
        deliveryEmail = deliveryEmail,
        addressUsageIndicator = addressUsageIndicator,
        addressUsage = addressUsage,
        city = city,
        country = country,
        address = address,
        postal = postal,
        regionCode = regionCode,
        nameIndicator = nameIndicator
    )