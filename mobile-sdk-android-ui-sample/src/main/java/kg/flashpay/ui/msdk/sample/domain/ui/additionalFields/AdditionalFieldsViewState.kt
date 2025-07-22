package kg.flashpay.ui.msdk.sample.domain.ui.additionalFields

import kg.flashpay.msdk.ui.EcmpAdditionalField
import kg.flashpay.ui.msdk.sample.domain.ui.base.ViewState

data class AdditionalFieldsViewState(
    val additionalFields: List<EcmpAdditionalField> = emptyList(),
) : ViewState
