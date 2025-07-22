package kg.paymentpage.msdk.ui.presentation.main.screens.customerFields

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import kg.paymentpage.msdk.ui.LocalPaymentOptions
import kg.paymentpage.msdk.ui.OverridesKeys
import kg.paymentpage.msdk.ui.SDKActionType
import kg.paymentpage.msdk.ui.TestTagsConstants
import kg.paymentpage.msdk.ui.utils.extensions.amountToCoins
import kg.paymentpage.msdk.ui.utils.extensions.core.getStringOverride
import kg.paymentpage.msdk.ui.views.button.PayButton
import kg.paymentpage.msdk.ui.views.button.SDKButton
import kg.paymentpage.msdk.ui.views.recurring.RecurringAgreements


@Composable
internal fun CustomerFieldsButton(
    actionType: SDKActionType,
    isEnabled: Boolean,
    onClick: () -> Unit,
) {
    when (actionType) {
        SDKActionType.Sale,
        SDKActionType.Auth -> {
            PayButton(
                modifier = Modifier
                    .testTag(TestTagsConstants.PAY_BUTTON),
                payLabel = getStringOverride(OverridesKeys.BUTTON_PAY),
                amount = LocalPaymentOptions.current.paymentInfo.paymentAmount.amountToCoins(),
                currency = LocalPaymentOptions.current.paymentInfo.paymentCurrency.uppercase(),
                isEnabled = isEnabled,
                onClick = onClick
            )
        }
        SDKActionType.Tokenize -> {
            SDKButton(
                modifier = Modifier
                    .testTag(TestTagsConstants.SAVE_BUTTON),
                label = getStringOverride(OverridesKeys.BUTTON_TOKENIZE),
                isEnabled = isEnabled,
                onClick = onClick
            )
        }
        SDKActionType.Verify -> {
            SDKButton(
                modifier = Modifier
                    .testTag(TestTagsConstants.AUTHORIZE_BUTTON),
                label = getStringOverride(OverridesKeys.BUTTON_AUTHORIZE),
                isEnabled = isEnabled,
                onClick = onClick
            )
            RecurringAgreements()
        }
    }
}