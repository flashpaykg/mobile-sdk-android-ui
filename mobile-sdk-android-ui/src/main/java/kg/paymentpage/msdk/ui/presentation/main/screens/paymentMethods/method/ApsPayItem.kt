package kg.paymentpage.msdk.ui.presentation.main.screens.paymentMethods.method

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kg.paymentpage.msdk.ui.LocalMainViewModel
import kg.paymentpage.msdk.ui.LocalPaymentMethodsViewModel
import kg.paymentpage.msdk.ui.LocalPaymentOptions
import kg.paymentpage.msdk.ui.OverridesKeys
import kg.paymentpage.msdk.ui.TestTagsConstants
import kg.paymentpage.msdk.ui.presentation.main.screens.paymentMethods.method.expandable.ExpandablePaymentMethodItem
import kg.paymentpage.msdk.ui.presentation.main.screens.paymentMethods.models.UIPaymentMethod
import kg.paymentpage.msdk.ui.presentation.main.showAps
import kg.paymentpage.msdk.ui.theme.SDKTheme
import kg.paymentpage.msdk.ui.utils.extensions.amountToCoins
import kg.paymentpage.msdk.ui.utils.extensions.core.getStringOverride
import kg.paymentpage.msdk.ui.utils.extensions.customColor
import kg.paymentpage.msdk.ui.views.button.PayButton

@Composable
internal fun ApsPayItem(
    method: UIPaymentMethod.UIApsPaymentMethod,
    isOnlyOneMethodOnScreen: Boolean = false,
) {
    val mainViewModel = LocalMainViewModel.current
    val paymentMethodsViewModel = LocalPaymentMethodsViewModel.current
    val paymentOptions = LocalPaymentOptions.current
    ExpandablePaymentMethodItem(
        method = method,
        isOnlyOneMethodOnScreen = isOnlyOneMethodOnScreen,
        fallbackIcon = painterResource(id = SDKTheme.images.apsDefaultLogoResId),
        //default aps icon color
        iconColor = ColorFilter.tint(
            color = customColor(paymentOptions.brandColor)
        ),
    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Column(Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag(TestTagsConstants.APS_PAYMENT_DISCLAIMER_TEXT),
                text = getStringOverride(OverridesKeys.APS_PAYMENT_DISCLAIMER),
                style = SDKTheme.typography.s14Light,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.size(20.dp))
            PayButton(
                modifier = Modifier
                    .testTag(TestTagsConstants.PAY_BUTTON),
                payLabel = getStringOverride(OverridesKeys.BUTTON_PAY),
                amount = LocalPaymentOptions.current.paymentInfo.paymentAmount.amountToCoins(),
                currency = LocalPaymentOptions.current.paymentInfo.paymentCurrency.uppercase(),
                isEnabled = true,
                showRecurringAgreement = false
            ) {
                paymentMethodsViewModel.setCurrentMethod(method)
                mainViewModel.showAps(method = method)
            }
        }
    }
}