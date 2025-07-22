package kg.flashpay.ui.msdk.sample.domain.mappers

import kg.flashpay.msdk.ui.threeDSecure.EcmpThreeDSecurePaymentInfo
import kg.flashpay.ui.msdk.sample.data.storage.entities.threeDSecure.payment.Payment


internal fun Payment.map(): EcmpThreeDSecurePaymentInfo =
    EcmpThreeDSecurePaymentInfo(
        reorder = reorder,
        preorderPurchase = preorderPurchase,
        preorderDate = preorderDate,
        challengeIndicator = challengeIndicator,
        challengeWindow = challengeWindow,
        giftCard = giftCard?.map()
    )