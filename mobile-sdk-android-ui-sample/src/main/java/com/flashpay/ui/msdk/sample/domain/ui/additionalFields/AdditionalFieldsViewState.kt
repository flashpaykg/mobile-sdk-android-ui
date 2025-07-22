package com.flashpay.ui.msdk.sample.domain.ui.additionalFields

import com.flashpay.msdk.ui.EcmpAdditionalField
import com.flashpay.ui.msdk.sample.domain.ui.base.ViewState

data class AdditionalFieldsViewState(
    val additionalFields: List<EcmpAdditionalField> = emptyList(),
) : ViewState
