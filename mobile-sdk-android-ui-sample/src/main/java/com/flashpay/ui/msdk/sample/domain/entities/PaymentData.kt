package com.flashpay.ui.msdk.sample.domain.entities

import com.flashpay.ui.msdk.sample.BuildConfig
import java.util.UUID

data class PaymentData(
    val projectId: Int = 146971,
    val paymentId: String = "sdk_sample_ui_${UUID.randomUUID().toString().take(8)}",
    val paymentAmount: Long =  11001,
    val paymentCurrency: String = "USD",
    val customerId: String? = "12",
    val paymentDescription: String? = "Test payment",
    val languageCode: String? = null,
    val regionCode: String? = null,
    val forcePaymentMethod: String? = null,
    val token: String? = null,
    val hideSavedWallets: Boolean = false,
    val secretKey: String = "b3755a0ec107a36ca9548520c7c469812d1a54bc229701d3c3f72a14d762e25c114f06a10ee7e0a5fa082caa88f286ff8917cd67d6fbef43fe96ec60741f2239",
    val apiHost: String = BuildConfig.API_HOST,
    val wsApiHost: String = BuildConfig.WS_API_HOST,
    val merchantId: String = "BCR2DN6TZ75OBLTH",
    val merchantName: String = "Example Merchant",
)
