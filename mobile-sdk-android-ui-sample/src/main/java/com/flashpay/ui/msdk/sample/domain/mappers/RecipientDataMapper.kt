package com.flashpay.ui.msdk.sample.domain.mappers

import com.flashpay.msdk.ui.EcmpRecipientInfo
import com.flashpay.ui.msdk.sample.domain.entities.RecipientData

internal fun RecipientData.map(): EcmpRecipientInfo = EcmpRecipientInfo(
    walletOwner = walletOwner,
    walletId = walletId,
    country = country,
    pan = pan,
    cardHolder = cardHolder,
    address = address,
    city = city,
    stateCode = stateCode
)