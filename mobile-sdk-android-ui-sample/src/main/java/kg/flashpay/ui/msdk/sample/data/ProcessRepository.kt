package kg.flashpay.ui.msdk.sample.data

import android.graphics.Bitmap
import kg.flashpay.msdk.ui.EcmpActionType
import kg.flashpay.msdk.ui.EcmpAdditionalField
import kg.flashpay.msdk.ui.EcmpAdditionalFieldType
import kg.flashpay.msdk.ui.EcmpPaymentSDK
import kg.flashpay.msdk.ui.EcmpScreenDisplayMode
import kg.flashpay.ui.msdk.sample.data.storage.entities.CommonJson
import kg.flashpay.ui.msdk.sample.domain.entities.PaymentData
import kg.flashpay.ui.msdk.sample.domain.entities.RecipientData
import kg.flashpay.ui.msdk.sample.domain.entities.RecurrentData

object ProcessRepository {
    var additionalFields: List<EcmpAdditionalField> =
        EcmpAdditionalFieldType.values().map { EcmpAdditionalField(type = it) }
    var mockModeType: EcmpPaymentSDK.EcmpMockModeType = EcmpPaymentSDK.EcmpMockModeType.DISABLED
    var actionType: EcmpActionType = EcmpActionType.Sale
    var screenDisplayModes: List<EcmpScreenDisplayMode> = listOf(EcmpScreenDisplayMode.DEFAULT)
    var paymentData: PaymentData = PaymentData()
    var hideScanningCards: Boolean = false
    var storedCardType: Int? = null

    //Recurrent
    var recurrentData: RecurrentData? = null
    var isEnabledRecurrent: Boolean = false

    //Recipient
    var recipientData: RecipientData? = null
    var isEnabledRecipient: Boolean = false

    //3DS
    var jsonThreeDSecureInfo: String? = null
    var commonJson: CommonJson? = null
    var isEnabledThreeDSecure: Boolean = false

    //Theme
    var brandColor: String? = null
    var bitmap: Bitmap? = null
    var isDarkTheme: Boolean = false
}