package kg.paymentpage.msdk.ui.presentation.main

import androidx.compose.runtime.Immutable
import kg.paymentpage.msdk.ui.base.mvi.UiEvent
import kg.paymentpage.msdk.ui.base.mvi.UiState
import kg.paymentpage.msdk.ui.presentation.main.screens.paymentMethods.models.UIPaymentMethod

@Immutable
internal sealed interface PaymentMethodsUiEvent : UiEvent {
    data class SetCurrentMethod(val method: UIPaymentMethod?) : PaymentMethodsUiEvent
    data class SetPaymentMethods(val paymentMethods: List<UIPaymentMethod>?) : PaymentMethodsUiEvent
}

@Immutable
internal data class PaymentMethodsState(
    val currentMethod: UIPaymentMethod? = null,
    val paymentMethods: List<UIPaymentMethod>? = null
) : UiState