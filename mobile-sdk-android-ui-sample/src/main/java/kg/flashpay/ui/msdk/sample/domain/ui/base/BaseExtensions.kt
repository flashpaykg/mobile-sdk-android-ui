package kg.flashpay.ui.msdk.sample.domain.ui.base

import kg.flashpay.ui.msdk.sample.domain.ui.navigation.NavigationViewIntents

fun BaseViewUC<*, *>.back() {
    pushExternalIntent(NavigationViewIntents.Back())
}