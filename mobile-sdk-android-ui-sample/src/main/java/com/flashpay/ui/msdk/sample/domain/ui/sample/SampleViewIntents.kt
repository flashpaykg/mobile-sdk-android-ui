package com.flashpay.ui.msdk.sample.domain.ui.sample

import com.flashpay.ui.msdk.sample.domain.ui.base.MessageUI
import com.flashpay.ui.msdk.sample.domain.ui.base.ViewIntents

sealed interface SampleViewIntents : ViewIntents {
    data class ShowMessage(val uiMessage: MessageUI) : SampleViewIntents
    object StartPaymentSDK : SampleViewIntents
    data class CopyInClipboard(val text: String, val textToast: String) : SampleViewIntents
}
