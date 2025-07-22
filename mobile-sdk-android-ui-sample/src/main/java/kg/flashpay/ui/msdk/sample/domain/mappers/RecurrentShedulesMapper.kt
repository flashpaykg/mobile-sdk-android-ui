package kg.flashpay.ui.msdk.sample.domain.mappers

import kg.flashpay.msdk.ui.EcmpRecurrentDataSchedule
import kg.flashpay.ui.msdk.sample.domain.entities.RecurrentDataSchedule

internal fun RecurrentDataSchedule.map(): EcmpRecurrentDataSchedule =
    EcmpRecurrentDataSchedule(
        date = date?.ifEmpty { null },
        amount = amount
    )