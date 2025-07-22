package com.flashpay.ui.msdk.sample.domain.ui.recurrent

import com.flashpay.ui.msdk.sample.domain.ui.base.ViewIntents
import com.flashpay.ui.msdk.sample.domain.entities.RecurrentData

sealed interface RecurrentViewIntents : ViewIntents {
    data class ChangeField(val recurrentData: RecurrentData) : RecurrentViewIntents
    object ChangeCheckbox: RecurrentViewIntents
    object Exit : RecurrentViewIntents
    object ResetData : RecurrentViewIntents
    object FillMockData : RecurrentViewIntents
}