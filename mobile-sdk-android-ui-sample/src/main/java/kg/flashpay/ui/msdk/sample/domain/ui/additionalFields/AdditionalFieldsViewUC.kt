package kg.flashpay.ui.msdk.sample.domain.ui.additionalFields

import kg.flashpay.ui.msdk.sample.data.ProcessRepository
import kg.flashpay.ui.msdk.sample.domain.ui.base.BaseViewUC
import kg.flashpay.ui.msdk.sample.domain.ui.base.back

class AdditionalFieldsViewUC : BaseViewUC<AdditionalFieldsViewIntents, AdditionalFieldsViewState>(
    AdditionalFieldsViewState()
) {
    init {
        updateState(
            newState = AdditionalFieldsViewState(
                additionalFields = ProcessRepository.additionalFields
            )
        )
    }

    override suspend fun reduce(viewIntent: AdditionalFieldsViewIntents) {
        when (viewIntent) {
            is AdditionalFieldsViewIntents.ChangeField -> {
                ProcessRepository.additionalFields = viewIntent.viewData.additionalFields
                updateState(viewIntent.viewData)
            }
            is AdditionalFieldsViewIntents.Exit -> {
                back()
            }
        }
    }
}

