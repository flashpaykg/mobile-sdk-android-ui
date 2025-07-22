package kg.flashpay.ui.msdk.sample.ui.main.views.button

import androidx.compose.runtime.Composable
import kg.flashpay.ui.msdk.sample.ui.components.SDKButton

@Composable
internal fun ThreeDSecureButton(listener: () -> Unit) {
    SDKButton(
        text = "3DS params",
        listener = listener
    )
}