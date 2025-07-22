package com.flashpay.ui.msdk.sample.domain.mappers

import com.flashpay.msdk.ui.threeDSecure.EcmpThreeDSecureGiftCardInfo
import com.flashpay.ui.msdk.sample.data.storage.entities.threeDSecure.payment.GiftCard

internal fun GiftCard.map(): EcmpThreeDSecureGiftCardInfo =
    EcmpThreeDSecureGiftCardInfo(
        amount = amount,
        currency = currency,
        count = count
    )