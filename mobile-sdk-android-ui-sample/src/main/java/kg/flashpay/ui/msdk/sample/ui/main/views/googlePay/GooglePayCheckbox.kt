package kg.flashpay.ui.msdk.sample.ui.main.views.googlePay

import androidx.compose.runtime.Composable
import kg.flashpay.ui.msdk.sample.ui.components.SDKCheckbox

@Composable
internal fun GooglePayCheckbox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    SDKCheckbox(
        text = "Change Google pay params",
        isChecked = isChecked,
        onCheckedChange = onCheckedChange
    )
}