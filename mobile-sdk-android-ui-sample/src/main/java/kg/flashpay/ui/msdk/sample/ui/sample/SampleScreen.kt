package kg.flashpay.ui.msdk.sample.ui.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kg.flashpay.ui.msdk.sample.domain.ui.base.MessageUI
import kg.flashpay.ui.msdk.sample.domain.ui.navigation.MainHostScreens
import kg.flashpay.ui.msdk.sample.domain.ui.sample.SampleViewActions
import kg.flashpay.ui.msdk.sample.domain.ui.sample.SampleViewIntents
import kg.flashpay.ui.msdk.sample.domain.ui.sample.SampleViewState
import kg.flashpay.ui.msdk.sample.domain.ui.sample.SampleViewUC
import kg.flashpay.ui.msdk.sample.ui.base.ComposeViewState
import kg.flashpay.ui.msdk.sample.ui.components.SDKInfoDialog
import kg.flashpay.ui.msdk.sample.ui.components.SDKToast
import kg.flashpay.ui.msdk.sample.ui.navigation.NavigationState
import kg.flashpay.ui.msdk.sample.utils.extensions.copyInClipBoard

@Composable
internal fun SampleActivity.SampleState(
    viewUseCase: SampleViewUC
) {
    ComposeViewState(
        viewUseCase = viewUseCase,
        actionListener = { viewAction ->
            when (viewAction) {
                is SampleViewActions.StartPaymentSDK -> startPaymentPage()
                is SampleViewActions.CopyInClipboard -> copyInClipBoard(text = viewAction.text, textToast = viewAction.textToast)
            }
        }
    ) { viewState, intentListener ->
        SampleScreen(viewState, intentListener)
    }
}

@Composable
fun SampleScreen(
    viewState: SampleViewState,
    intentListener: (SampleViewIntents) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
    ) {
        NavigationState(
            startRoute = MainHostScreens.MainScreen
        )
    }

    with(viewState.uiMessage) {
        when (this) {
            is MessageUI.Toast -> SDKToast(message)
            is MessageUI.Dialogs.CancelYes -> {}
            is MessageUI.Dialogs.Info.SuccessTokenize -> {
                SDKInfoDialog(
                    iconID = iconID,
                    title = title,
                    message = message,
                    buttonText = buttonText
                ) {
                    intentListener(SampleViewIntents.ShowMessage(MessageUI.Empty))
                    intentListener(SampleViewIntents.CopyInClipboard(text = message, textToast = "Token was copied"))
                }
            }
            is MessageUI.Dialogs.Info -> {
                SDKInfoDialog(
                    iconID = iconID,
                    title = title,
                    message = message,
                    buttonText = buttonText
                ) {
                    intentListener(SampleViewIntents.ShowMessage(MessageUI.Empty))
                }
            }
            is MessageUI.Empty -> Unit
        }
    }

}
