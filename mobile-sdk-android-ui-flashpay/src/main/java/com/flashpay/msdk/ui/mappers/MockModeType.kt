package com.flashpay.msdk.ui.mappers

import com.flashpay.msdk.ui.EcmpPaymentSDK.EcmpMockModeType
import com.paymentpage.msdk.ui.SDKMockModeType

internal fun EcmpMockModeType.map(): SDKMockModeType =
    when(this) {
        EcmpMockModeType.DISABLED -> SDKMockModeType.DISABLED
        EcmpMockModeType.SUCCESS -> SDKMockModeType.SUCCESS
        EcmpMockModeType.DECLINE -> SDKMockModeType.DECLINE
    }