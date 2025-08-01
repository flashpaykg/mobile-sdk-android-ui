package kg.flashpay.ui.msdk.sample.data.storage.entities.threeDSecure.payment

import kotlinx.serialization.Serializable

@Serializable
data class GiftCard(
    val amount: Int? = null,
    val currency: String? = null,
    val count: Int? = null
) {
    companion object {
        val default = GiftCard(
            amount = 12345,
            currency = "USD",
            count = 1,
        )
    }
}
