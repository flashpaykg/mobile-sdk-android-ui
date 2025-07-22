package com.flashpay.ui.msdk.sample.domain.ui.base

import com.flashpay.ui.msdk.sample.domain.ui.navigation.NavigationViewIntents

fun BaseViewUC<*, *>.back() {
    pushExternalIntent(NavigationViewIntents.Back())
}