package kg.flashpay.msdk.ui

import kg.paymentpage.msdk.ui.base.PaymentOptionsDsl

@PaymentOptionsDsl
enum class EcmpScreenDisplayMode {
    HIDE_SUCCESS_FINAL_SCREEN,
    HIDE_DECLINE_FINAL_SCREEN,
    DEFAULT
}

@PaymentOptionsDsl
class EcmpScreenDisplayModes : ArrayList<EcmpScreenDisplayMode>() {
    fun mode(mode: EcmpScreenDisplayMode) {
        add(mode)
    }
}