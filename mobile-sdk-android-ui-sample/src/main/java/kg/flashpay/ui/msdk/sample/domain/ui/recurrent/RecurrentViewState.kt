package kg.flashpay.ui.msdk.sample.domain.ui.recurrent

import kg.flashpay.ui.msdk.sample.domain.ui.base.ViewState
import kg.flashpay.ui.msdk.sample.domain.entities.RecurrentData

data class RecurrentViewState(
    val recurrentData: RecurrentData = RecurrentData(),
    val isEnabledRecurrent: Boolean = false
) : ViewState
