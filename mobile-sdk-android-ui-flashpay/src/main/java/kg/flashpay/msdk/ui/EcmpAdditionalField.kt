@file:Suppress("unused")

package kg.flashpay.msdk.ui

import kg.paymentpage.msdk.ui.base.PaymentOptionsDsl

@PaymentOptionsDsl
class EcmpAdditionalField(
    var type: EcmpAdditionalFieldType? = null,
    var value: String? = null,
)

@PaymentOptionsDsl
class EcmpAdditionalFields : ArrayList<EcmpAdditionalField>() {
    fun field(block: EcmpAdditionalField.() -> Unit) {
        add(EcmpAdditionalField().apply(block))
    }
}