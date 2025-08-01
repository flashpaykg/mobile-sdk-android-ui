package kg.flashpay.ui.msdk.sample.ui.main.views.button

import androidx.compose.runtime.Composable
import kg.flashpay.ui.msdk.sample.ui.components.SDKButton

@Composable
internal fun RecurrentButton(listener: () -> Unit) {
    SDKButton(
        text = "Recurrent Data",
        listener = listener
    )
}