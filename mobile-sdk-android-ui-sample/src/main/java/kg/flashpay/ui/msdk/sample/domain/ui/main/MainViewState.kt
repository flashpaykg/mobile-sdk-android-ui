package kg.flashpay.ui.msdk.sample.domain.ui.main

import android.graphics.Bitmap
import android.net.Uri
import kg.flashpay.msdk.ui.EcmpPaymentSDK
import kg.flashpay.msdk.ui.EcmpScreenDisplayMode
import kg.flashpay.ui.msdk.sample.domain.entities.PaymentData
import kg.flashpay.ui.msdk.sample.domain.ui.base.ViewState

data class MainViewState(
    val paymentData: PaymentData = PaymentData(),
    val hideScanningCards: Boolean = false,
    val isVisibleForcePaymentMethodFields: Boolean = false,
    val isVisibleApiHostFields: Boolean = false,
    val isVisibleGooglePayFields: Boolean = false,
    val isVisibleCustomizationFields: Boolean = false,
    val isVisibleMockModeType: Boolean = false,
    val isVisibleScreenDisplayMode: Boolean = false,
    val selectedResourceImageId: Int = -1,
    val selectedForcePaymentMethodId: Int = -1,
    val selectedMockModeType: EcmpPaymentSDK.EcmpMockModeType = EcmpPaymentSDK.EcmpMockModeType.DISABLED,
    val selectedScreenDisplayModes: List<EcmpScreenDisplayMode> = listOf(EcmpScreenDisplayMode.DEFAULT),
    val localImageUri: Uri? = null,
    val bitmap: Bitmap? = null,
    val brandColor: String = "#00579E",
    val isDarkTheme: Boolean = false,
    val storedCardType: Int? = null
) : ViewState