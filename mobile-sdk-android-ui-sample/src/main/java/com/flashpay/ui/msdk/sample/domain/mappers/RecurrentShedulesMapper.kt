package com.flashpay.ui.msdk.sample.domain.mappers

import com.flashpay.msdk.ui.EcmpRecurrentDataSchedule
import com.flashpay.ui.msdk.sample.domain.entities.RecurrentDataSchedule

internal fun RecurrentDataSchedule.map(): EcmpRecurrentDataSchedule =
    EcmpRecurrentDataSchedule(
        date = date?.ifEmpty { null },
        amount = amount
    )