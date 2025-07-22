package kg.flashpay.ui.msdk.sample.domain.ui.threeDSecure

import kg.flashpay.ui.msdk.sample.domain.ui.base.ViewState

data class ThreeDSecureViewState(
    val jsonThreeDSecureInfo: String = "",
    val isEnabledThreeDSecure: Boolean = false
) : ViewState