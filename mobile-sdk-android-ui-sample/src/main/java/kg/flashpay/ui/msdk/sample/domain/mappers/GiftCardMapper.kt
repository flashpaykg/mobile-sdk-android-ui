package kg.flashpay.ui.msdk.sample.domain.mappers

import kg.flashpay.msdk.ui.threeDSecure.EcmpThreeDSecureGiftCardInfo
import kg.flashpay.ui.msdk.sample.data.storage.entities.threeDSecure.payment.GiftCard

internal fun GiftCard.map(): EcmpThreeDSecureGiftCardInfo =
    EcmpThreeDSecureGiftCardInfo(
        amount = amount,
        currency = currency,
        count = count
    )