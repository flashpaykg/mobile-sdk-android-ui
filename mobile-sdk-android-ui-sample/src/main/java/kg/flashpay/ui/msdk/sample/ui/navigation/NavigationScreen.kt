package kg.flashpay.ui.msdk.sample.ui.navigation

import androidx.compose.runtime.Composable
import kg.flashpay.ui.msdk.sample.domain.ui.navigation.MainHostScreens
import kg.flashpay.ui.msdk.sample.domain.ui.navigation.NavRoutes
import kg.flashpay.ui.msdk.sample.domain.ui.navigation.NavigationViewIntents
import kg.flashpay.ui.msdk.sample.domain.ui.navigation.NavigationViewState
import kg.flashpay.ui.msdk.sample.ui.additionalFields.AdditionalFieldsState
import kg.flashpay.ui.msdk.sample.ui.main.MainState
import kg.flashpay.ui.msdk.sample.ui.recipient.RecipientState
import kg.flashpay.ui.msdk.sample.ui.recurrent.RecurrentState
import kg.flashpay.ui.msdk.sample.ui.threeDSecure.ThreeDSecureState
import kotlin.system.exitProcess

@Composable
fun NavigationScreen(
    viewState: NavigationViewState,
    listener: (NavigationViewIntents) -> Unit
) {
    when (val currentRoute = viewState.currentRoute) {
        is MainHostScreens.MainScreen -> MainState(route = currentRoute)
        is MainHostScreens.AdditionalFields -> AdditionalFieldsState(route = currentRoute)
        is MainHostScreens.Recurrent -> RecurrentState(route = currentRoute)
        is MainHostScreens.Recipient -> RecipientState(route = currentRoute)
        is MainHostScreens.ThreeDSecure -> ThreeDSecureState(route = currentRoute)
        is NavRoutes.Exit -> exitProcess(0)
    }
}