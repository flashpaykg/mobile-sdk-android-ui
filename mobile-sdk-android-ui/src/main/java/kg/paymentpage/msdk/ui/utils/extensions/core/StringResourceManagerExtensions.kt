package kg.paymentpage.msdk.ui.utils.extensions.core

import kg.paymentpage.msdk.ui.PaymentActivity

internal fun getStringOverride(key: String): String =
    PaymentActivity.stringResourceManager.getStringByKey(key) ?: key