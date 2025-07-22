package kg.flashpay.msdk.ui.mappers

import kg.flashpay.msdk.ui.EcmpPaymentSDK.EcmpMockModeType
import kg.paymentpage.msdk.ui.SDKMockModeType

internal fun EcmpMockModeType.map(): SDKMockModeType =
    when(this) {
        EcmpMockModeType.DISABLED -> SDKMockModeType.DISABLED
        EcmpMockModeType.SUCCESS -> SDKMockModeType.SUCCESS
        EcmpMockModeType.DECLINE -> SDKMockModeType.DECLINE
    }