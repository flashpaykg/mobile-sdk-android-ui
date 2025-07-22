package com.flashpay.ui.msdk.sample.domain.mappers

import com.flashpay.msdk.ui.threeDSecure.EcmpThreeDSecureMpiResultInfo
import com.flashpay.ui.msdk.sample.data.storage.entities.threeDSecure.customer.MpiResult

internal fun MpiResult.map(): EcmpThreeDSecureMpiResultInfo =
    EcmpThreeDSecureMpiResultInfo(
        acsOperationId = acsOperationId,
        authenticationFlow = authenticationFlow,
        authenticationTimestamp = authenticationTimestamp
    )