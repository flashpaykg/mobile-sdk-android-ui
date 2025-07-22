package kg.flashpay.ui.msdk.sample.domain.ui.sample

import kg.flashpay.ui.msdk.sample.domain.ui.base.MessageUI
import kg.flashpay.ui.msdk.sample.domain.ui.base.ViewState

data class SampleViewState(
    val uiMessage: MessageUI = MessageUI.Empty
) : ViewState
