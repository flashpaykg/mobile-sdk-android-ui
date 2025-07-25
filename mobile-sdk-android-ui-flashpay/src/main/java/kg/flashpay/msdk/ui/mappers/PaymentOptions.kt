package kg.flashpay.msdk.ui.mappers

import kg.flashpay.msdk.ui.EcmpAdditionalField
import kg.flashpay.msdk.ui.EcmpAdditionalFieldType
import kg.flashpay.msdk.ui.EcmpPaymentOptions
import kg.flashpay.msdk.ui.EcmpRecipientInfo
import kg.flashpay.msdk.ui.EcmpScreenDisplayMode
import com.paymentpage.msdk.core.domain.entities.RecipientInfo
import com.paymentpage.msdk.core.domain.interactors.pay.googlePay.GooglePayEnvironment
import kg.paymentpage.msdk.ui.SDKActionType
import kg.paymentpage.msdk.ui.SDKAdditionalField
import kg.paymentpage.msdk.ui.SDKAdditionalFieldType
import kg.paymentpage.msdk.ui.SDKPaymentOptions
import kg.paymentpage.msdk.ui.SDKScreenDisplayMode

internal fun EcmpPaymentOptions.map(): SDKPaymentOptions =
    SDKPaymentOptions(
        //payment configuration
        paymentInfo = paymentInfo,
        recurrentInfo = recurrentData,
        recipientInfo = recipientInfo?.map(),
        actionType = SDKActionType.valueOf(actionType.name),
        screenDisplayModes = screenDisplayModes.map(),
        additionalFields = additionalFields.map { additionalField ->
            SDKAdditionalField(
                type = additionalField.type?.map(),
                value = additionalField.formattedValue()
            )
        },
        hideScanningCards = hideScanningCards,
        //google pay configuration
        merchantId = merchantId,
        merchantName = merchantName,
        merchantEnvironment = if (isTestEnvironment) GooglePayEnvironment.TEST else GooglePayEnvironment.PROD,
        //theme customization
        isDarkTheme = isDarkTheme,
        logoImage = logoImage,
        brandColor = brandColor,
        footerImage = footerImage,
        footerLabel = footerLabel,
        //stored card type
        storedCardType = storedCardType
    )

/**
 * This removes all prohibited characters from field values
 */
internal fun EcmpAdditionalField.formattedValue() =
    when(type) {
        EcmpAdditionalFieldType.CUSTOMER_PHONE -> value?.filter { it.isDigit() }
        else -> value
    }

internal fun EcmpAdditionalFieldType.map(): SDKAdditionalFieldType? =
    SDKAdditionalFieldType.values().find { it.value == value }

internal fun EcmpScreenDisplayMode.map(): SDKScreenDisplayMode? =
    SDKScreenDisplayMode.values().find { it.name == name }

internal fun List<EcmpScreenDisplayMode>.map(): List<SDKScreenDisplayMode> =
    mapNotNull { it.map() }

internal fun EcmpRecipientInfo.map(): RecipientInfo =
    RecipientInfo(
        walletOwner = walletOwner,
        walletId = walletId,
        country = country,
        pan = pan,
        cardHolder = cardHolder,
        address = address,
        city = city,
        stateCode = stateCode,
        firstName = null,
        lastName = null
    )