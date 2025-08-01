package kg.flashpay.ui.msdk.sample.ui.main.views.mockMode

import androidx.compose.runtime.Composable
import kg.flashpay.ui.msdk.sample.ui.components.SDKCheckbox

@Composable
internal fun MockModeCheckbox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    SDKCheckbox(
        text = "Custom mock mode",
        isChecked = isChecked,
        onCheckedChange = onCheckedChange
    )
}