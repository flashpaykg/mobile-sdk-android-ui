package kg.paymentpage.msdk.ui.presentation.main.screens.result.views.decline

import androidx.compose.runtime.Composable
import com.paymentpage.msdk.core.domain.entities.payment.Payment
import kg.paymentpage.msdk.ui.LocalMainViewModel
import kg.paymentpage.msdk.ui.LocalPaymentOptions
import kg.paymentpage.msdk.ui.OverridesKeys
import kg.paymentpage.msdk.ui.base.ErrorResult
import kg.paymentpage.msdk.ui.utils.extensions.core.getStringOverride
import kg.paymentpage.msdk.ui.views.common.alertDialog.ConfirmAlertDialog

@Composable
internal fun ResultDeclineTokenizeContent(
    onClose: (Payment) -> Unit,
    onError: (ErrorResult, Boolean) -> Unit
) {
    val viewModel = LocalMainViewModel.current
    val payment =
        viewModel.payment ?: throw IllegalStateException("Not found payment in State")
    val paymentOptions = LocalPaymentOptions.current
    ConfirmAlertDialog(
        message = getStringOverride(OverridesKeys.TITLE_RESULT_ERROR_TOKENIZE),
        onConfirmButtonClick = { onClose(payment) },
        confirmButtonText = getStringOverride(OverridesKeys.BUTTON_OK),
        onDismissRequest = { onClose(payment) },
        brandColor = paymentOptions.brandColor
    )
}