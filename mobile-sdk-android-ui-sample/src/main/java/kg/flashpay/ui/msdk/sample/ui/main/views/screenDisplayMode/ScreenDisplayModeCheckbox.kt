package kg.flashpay.ui.msdk.sample.ui.main.views.screenDisplayMode

import androidx.compose.runtime.Composable
import kg.flashpay.ui.msdk.sample.ui.components.SDKCheckbox

@Composable
internal fun ScreenDisplayModeCheckbox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    SDKCheckbox(
        text = "Screen display mode",
        isChecked = isChecked,
        onCheckedChange = onCheckedChange
    )
}