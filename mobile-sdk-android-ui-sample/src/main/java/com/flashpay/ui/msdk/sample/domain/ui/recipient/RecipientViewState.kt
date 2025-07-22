package com.flashpay.ui.msdk.sample.domain.ui.recipient

import com.flashpay.ui.msdk.sample.domain.entities.RecipientData
import com.flashpay.ui.msdk.sample.domain.ui.base.ViewState

data class RecipientViewState(
    val recipientData: RecipientData = RecipientData(),
    val isEnabledRecipient: Boolean = false
) : ViewState
