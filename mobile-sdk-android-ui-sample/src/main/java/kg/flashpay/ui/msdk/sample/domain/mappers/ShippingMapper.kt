package kg.flashpay.ui.msdk.sample.domain.mappers

import kg.flashpay.msdk.ui.threeDSecure.EcmpThreeDSecureShippingInfo
import kg.flashpay.ui.msdk.sample.data.storage.entities.threeDSecure.customer.Shipping

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