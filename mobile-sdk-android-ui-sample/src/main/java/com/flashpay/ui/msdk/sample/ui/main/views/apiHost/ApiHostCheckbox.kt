package com.flashpay.ui.msdk.sample.ui.main.views.apiHost

import androidx.compose.runtime.Composable
import com.flashpay.ui.msdk.sample.ui.components.SDKCheckbox

@Composable
internal fun ApiHostCheckbox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    SDKCheckbox(
        text = "Change Api Host",
        isChecked = isChecked,
        onCheckedChange = onCheckedChange
    )
}