package kg.flashpay.ui.msdk.sample.ui.main.views.button

import androidx.compose.runtime.Composable
import kg.flashpay.ui.msdk.sample.ui.components.SDKButton

@Composable
internal fun VerifyButton(listener: () -> Unit) {
    SDKButton(
        text = "Verify",
        listener = listener
    )
}