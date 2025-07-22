package com.flashpay.ui.msdk.sample.domain.mappers

import com.flashpay.msdk.ui.threeDSecure.EcmpThreeDSecureCustomerInfo
import com.flashpay.msdk.ui.threeDSecure.EcmpThreeDSecureInfo
import com.flashpay.ui.msdk.sample.data.storage.entities.threeDSecure.ThreeDSecureInfoModel


internal fun ThreeDSecureInfoModel.map(): EcmpThreeDSecureInfo =
    EcmpThreeDSecureInfo(
        ecmpThreeDSecureCustomerInfo = EcmpThreeDSecureCustomerInfo(
            addressMatch = addressMatch,
            homePhone = homePhone,
            workPhone = workPhone,
            billingRegionCode = billingRegionCode,
            ecmpThreeDSecureAccountInfo = customerAccountInfo?.customer?.account?.map(),
            ecmpThreeDSecureShippingInfo = customerShipping?.customer?.shipping?.map(),
            ecmpThreeDSecureMpiResultInfo = customerMpiResult?.customer?.mpiResult?.map()
        ),
        ecmpThreeDSecurePaymentInfo = paymentMerchantRisk?.payment?.map()
    )