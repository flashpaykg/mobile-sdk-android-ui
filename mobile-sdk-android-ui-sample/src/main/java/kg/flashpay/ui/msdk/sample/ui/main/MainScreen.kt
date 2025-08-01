package kg.flashpay.ui.msdk.sample.ui.main

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kg.flashpay.ui.msdk.sample.domain.ui.base.viewUseCase
import kg.flashpay.ui.msdk.sample.domain.ui.main.MainViewIntents
import kg.flashpay.ui.msdk.sample.domain.ui.main.MainViewState
import kg.flashpay.ui.msdk.sample.domain.ui.main.MainViewUC
import kg.flashpay.ui.msdk.sample.domain.ui.navigation.MainHostScreens
import kg.flashpay.ui.msdk.sample.ui.base.ComposeViewState
import kg.flashpay.ui.msdk.sample.ui.components.SDKButton
import kg.flashpay.ui.msdk.sample.ui.components.SDKCheckbox
import kg.flashpay.ui.msdk.sample.ui.main.views.PaymentFields
import kg.flashpay.ui.msdk.sample.ui.main.views.ProjectSettings
import kg.flashpay.ui.msdk.sample.ui.main.views.VersionInfo
import kg.flashpay.ui.msdk.sample.ui.main.views.apiHost.ApiHostFields
import kg.flashpay.ui.msdk.sample.ui.main.views.customization.CustomizationFields
import kg.flashpay.ui.msdk.sample.ui.main.views.googlePay.GooglePayFields
import kg.flashpay.ui.msdk.sample.ui.main.views.mockMode.SelectMockMode
import kg.flashpay.ui.msdk.sample.ui.main.views.screenDisplayMode.SelectScreenDisplayMode

@Composable
internal fun MainState(
    route: MainHostScreens.MainScreen,
    viewUseCase: MainViewUC = viewUseCase(route.toString()) {
        MainViewUC()
    }
) {
    ComposeViewState(
        viewUseCase = viewUseCase
    ) { viewState, intentListener ->
        MainScreen(
            viewState = viewState,
            intentListener = intentListener
        )
    }
}

@Composable
fun MainScreen(
    viewState: MainViewState,
    intentListener: (MainViewIntents) -> Unit,
) {
    val paymentData = viewState.paymentData
    val padding = 10.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        VersionInfo()
        Spacer(Modifier.size(padding))
        ProjectSettings(
            paymentData = paymentData,
            intentListener = intentListener
        )
        Spacer(Modifier.size(padding))
        PaymentFields(
            paymentData = paymentData,
            intentListener = intentListener
        )
        Spacer(Modifier.size(padding))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("storedCardTypeTextField"),
            value = viewState.storedCardType?.toString() ?: "",
            onValueChange = { changingString ->
                if (changingString.isBlank() || changingString.length == 1) {
                    intentListener(
                        MainViewIntents.ChangeStoredCardType(
                            storedCardType = changingString
                        )
                    )
                }
            },
            label = { Text(text = "Stored card type (0-6)") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(Modifier.size(padding))
        SDKButton(
            modifier = Modifier
                .testTag("additionalFieldsButton"),
            text = "Additional fields",
            listener = {
                intentListener(MainViewIntents.AdditionalFields)
            }
        )
        Spacer(Modifier.size(padding))
        SDKButton(
            modifier = Modifier
                .testTag("recurrentDataButton"),
            text = "Recurrent Data",
            listener = {
                intentListener(MainViewIntents.Recurrent)
            }
        )
        Spacer(Modifier.size(padding))
        SDKButton(
            modifier = Modifier
                .testTag("recipientDataButton"),
            text = "Recipient Data",
            listener = {
                intentListener(MainViewIntents.Recipient)
            }
        )
        Spacer(Modifier.size(padding))
        SDKButton(
            modifier = Modifier
                .testTag("threeDSecureButton"),
            text = "3DS params",
            listener = {
                intentListener(MainViewIntents.ThreeDSecure)
            }
        )
        Spacer(Modifier.size(padding))
        SDKCheckbox(
            modifier = Modifier
                .testTag("hideSavedWalletsCheckbox"),
            text = "Hide saved wallets",
            isChecked = paymentData.hideSavedWallets,
            onCheckedChange = {
                intentListener(
                    MainViewIntents.ChangeField(
                        paymentData = paymentData.copy(
                            hideSavedWallets = it
                        )
                    )
                )
            }
        )
        Spacer(Modifier.size(padding))
        SDKCheckbox(
            modifier = Modifier
                .testTag("hideScanningCardsCheckbox"),
            text = "Hide scanning cards",
            isChecked = viewState.hideScanningCards,
            onCheckedChange = {
                intentListener(MainViewIntents.ChangeHideScanningCardsCheckbox)
            }
        )
        Spacer(Modifier.size(padding))
        SDKCheckbox(
            modifier = Modifier
                .testTag("customizationCheckbox"),
            text = "Custom brand color and logo",
            isChecked = viewState.isVisibleCustomizationFields,
            onCheckedChange = {
                intentListener(MainViewIntents.ChangeCustomizationCheckbox)
            }
        )
        if (viewState.isVisibleCustomizationFields) {
            CustomizationFields(
                viewState = viewState,
                intentListener = intentListener
            )
        }
        Spacer(Modifier.size(padding))
        SDKCheckbox(
            modifier = Modifier
                .testTag("apiHostCheckbox"),
            text = "Change Api Host",
            isChecked = viewState.isVisibleApiHostFields,
            onCheckedChange = {
                intentListener(MainViewIntents.ChangeApiHostCheckBox)
            }
        )
        if (viewState.isVisibleApiHostFields) {
            ApiHostFields(
                paymentData = paymentData,
                intentListener = intentListener
            )
        }
        Spacer(Modifier.size(padding))

        SDKCheckbox(
            modifier = Modifier
                .testTag("googlePayCheckbox"),
            text = "Change Google pay params",
            isChecked = viewState.isVisibleGooglePayFields,
            onCheckedChange = {
                intentListener(MainViewIntents.ChangeGooglePayCheckBox)
            }
        )
        if (viewState.isVisibleGooglePayFields) {
            GooglePayFields(
                paymentData = paymentData,
                intentListener = intentListener
            )
        }
        Spacer(Modifier.size(padding))



        SDKCheckbox(
            modifier = Modifier
                .testTag("mockModeCheckbox"),
            text = "Custom mock mode",
            isChecked = viewState.isVisibleMockModeType,
            onCheckedChange = {
                intentListener(MainViewIntents.ChangeMockModeCheckbox)
            }
        )

        if (viewState.isVisibleMockModeType) {
            Spacer(Modifier.size(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.LightGray)
                    .padding(horizontal = 10.dp),
                content = {
                    Spacer(modifier = Modifier.size(10.dp))
                    SelectMockMode(viewState, intentListener)
                    Spacer(modifier = Modifier.size(10.dp))
                }
            )
        }

        Spacer(Modifier.size(padding))

        SDKCheckbox(
            modifier = Modifier
                .testTag("screenDisplayModeCheckbox"),
            text = "Screen display mode",
            isChecked = viewState.isVisibleScreenDisplayMode,
            onCheckedChange = {
                intentListener(MainViewIntents.ChangeScreenDisplayModeCheckbox)
            }
        )

        if (viewState.isVisibleScreenDisplayMode) {
            Spacer(Modifier.size(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.LightGray)
                    .padding(horizontal = 10.dp),
                content = {
                    Spacer(modifier = Modifier.size(10.dp))
                    SelectScreenDisplayMode(viewState, intentListener)
                    Spacer(modifier = Modifier.size(10.dp))
                }
            )
        }


        Spacer(Modifier.size(padding))

        SDKButton(
            modifier = Modifier
                .testTag("saleButton"),
            text = "Sale",
            listener = {
                intentListener(MainViewIntents.Sale)
            }
        )

        Spacer(Modifier.size(padding))

        SDKButton(
            modifier = Modifier
                .testTag("authButton"),
            text = "Auth",
            listener = {
                intentListener(MainViewIntents.Auth)
            }
        )

        Spacer(Modifier.size(padding))

        SDKButton(
            modifier = Modifier
                .testTag("verifyButton"),
            text = "Verify",
            listener = {
                intentListener(MainViewIntents.Verify)
            }
        )

        Spacer(Modifier.size(padding))

        SDKButton(
            modifier = Modifier
                .testTag("tokenizeButton"),
            text = "Tokenize",
            listener = {
                intentListener(MainViewIntents.Tokenize)
            }
        )
    }
}