package kg.flashpay.ui.msdk.sample.domain.mappers

import kg.flashpay.msdk.ui.threeDSecure.EcmpThreeDSecureMpiResultInfo
import kg.flashpay.ui.msdk.sample.data.storage.entities.threeDSecure.customer.MpiResult

internal fun MpiResult.map(): EcmpThreeDSecureMpiResultInfo =
    EcmpThreeDSecureMpiResultInfo(
        acsOperationId = acsOperationId,
        authenticationFlow = authenticationFlow,
        authenticationTimestamp = authenticationTimestamp
    )