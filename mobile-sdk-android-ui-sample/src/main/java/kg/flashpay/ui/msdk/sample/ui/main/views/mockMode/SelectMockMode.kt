package kg.flashpay.ui.msdk.sample.ui.main.views.mockMode

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kg.flashpay.msdk.ui.EcmpPaymentSDK
import kg.flashpay.ui.msdk.sample.domain.ui.main.MainViewIntents
import kg.flashpay.ui.msdk.sample.domain.ui.main.MainViewState

@Composable
internal fun SelectMockMode(
    viewState: MainViewState,
    intentListener: (MainViewIntents) -> Unit,
) {
    EcmpPaymentSDK.EcmpMockModeType.values()
        .forEach { mockModeType ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    modifier = Modifier
                        .testTag("${mockModeType.name.lowercase()}MockModeRadioButton"),
                    selected = mockModeType == viewState.selectedMockModeType,
                    onClick = {
                        intentListener(
                            MainViewIntents.SelectMockMode(
                                mockModeType = mockModeType
                            )
                        )
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = mockModeType.name)
            }
        }
    Spacer(modifier = Modifier.size(10.dp))
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .testTag("resetMockModeButton"),
        onClick = {
            intentListener(
                MainViewIntents.SelectMockMode(
                    mockModeType = EcmpPaymentSDK.EcmpMockModeType.DISABLED
                )
            )
        }) {
        Text(text = "Reset mock mode type", color = Color.White, fontSize = 18.sp)
    }
    Spacer(modifier = Modifier.size(10.dp))
}