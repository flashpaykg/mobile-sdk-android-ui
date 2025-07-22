package kg.flashpay.ui.msdk.sample.domain.mappers

import kg.flashpay.msdk.ui.EcmpRecurrentData
import kg.flashpay.ui.msdk.sample.domain.entities.RecurrentData

internal fun RecurrentData.map(): EcmpRecurrentData = EcmpRecurrentData(
    register = register,
    type = type?.ifEmpty { null },
    expiryDay = expiryDay?.ifEmpty { null },
    expiryMonth = expiryMonth?.ifEmpty { null },
    expiryYear = expiryYear?.ifEmpty { null },
    period = period?.ifEmpty { null },
    interval = interval,
    time = time?.ifEmpty { null },
    startDate = startDate?.ifEmpty { null },
    scheduledPaymentID = scheduledPaymentID?.ifEmpty { null },
    amount = amount,
    schedule = schedule?.map { it.map() }
)