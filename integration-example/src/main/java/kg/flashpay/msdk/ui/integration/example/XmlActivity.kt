package kg.flashpay.msdk.ui.integration.example

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kg.flashpay.msdk.ui.*
import kg.flashpay.msdk.ui.integration.example.utils.CommonUtils
import kg.flashpay.msdk.ui.integration.example.utils.SignatureGenerator
import com.paymentpage.msdk.core.domain.entities.payment.Payment
import kotlinx.serialization.json.Json

class XmlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml)

        //1. Create EcmpPaymentInfo object
        val ecmpPaymentInfo = EcmpPaymentInfo(
            //required fields
            projectId = BuildConfig.PROJECT_ID, //Unique project Id
            paymentId = CommonUtils.getRandomPaymentId(),
            paymentAmount = 100, //1.00
            paymentCurrency = "USD",
            //optional fields
//            paymentDescription = "Test description",
//            customerId = "12",
//            regionCode = "",
//            token = "",
//            languageCode = "en",
//            receiptData = "",
//            hideSavedWallets = false,
//            forcePaymentMethod = "card",
//            ecmpThreeDSecureInfo = EcmpThreeDSecureInfo()
        )

        //2. Sign it
        ecmpPaymentInfo.signature = SignatureGenerator.generateSignature(
            paramsToSign = ecmpPaymentInfo.getParamsForSignature(),
            secret = BuildConfig.PROJECT_SECRET_KEY
        )

        //3. Configure SDK
        val paymentOptions = paymentOptions {
            //Required object for payment
            paymentInfo = ecmpPaymentInfo

            //Optional objects for payment
            //EcmpActionType.Sale by default
            actionType = EcmpActionType.Sale
            //GooglePay options
            isTestEnvironment = true
            merchantId = BuildConfig.GPAY_MERCHANT_ID
            merchantName = "Example Merchant Name"
            additionalFields {
                field {
                    EcmpAdditionalField(
                        EcmpAdditionalFieldType.CUSTOMER_EMAIL,
                        "mail@mail.com"
                    )
                }
                field {
                    EcmpAdditionalField(
                        EcmpAdditionalFieldType.CUSTOMER_FIRST_NAME,
                        "firstName"
                    )
                }
            }
            screenDisplayModes {
                mode(EcmpScreenDisplayMode.HIDE_SUCCESS_FINAL_SCREEN)
                mode(EcmpScreenDisplayMode.HIDE_DECLINE_FINAL_SCREEN)
            }
            recurrentData = EcmpRecurrentData()
            recipientInfo = EcmpRecipientInfo()

            //Parameter to enable hiding or displaying scanning cards feature
            hideScanningCards = false

            //Custom theme
            isDarkTheme = false
            brandColor = "#000000" //#RRGGBB
            //Any bitmap image
            logoImage = BitmapFactory.decodeResource(
                resources,
                R.drawable.example_logo
            )
        }

        //4. Create sdk object
        val sdk = EcmpPaymentSDK(
            context = applicationContext,
            paymentOptions = paymentOptions,
            mockModeType = EcmpPaymentSDK.EcmpMockModeType.SUCCESS
        )

        //5. Open it
        startActivityForResult.launch(sdk.intent)
    }

    //6. Handle result
    private val startActivityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val data = result.data
            when (result.resultCode) {
                EcmpPaymentSDK.RESULT_SUCCESS -> {
                    val payment =
                        Json.decodeFromString<Payment?>(
                            data?.getStringExtra(
                                EcmpPaymentSDK.EXTRA_PAYMENT
                            ).toString()
                        )
                    when {
                        payment?.token != null -> {
                            Toast.makeText(
                                this,
                                "Tokenization was finished successfully. Your token is ${payment.token}",
                                Toast.LENGTH_SHORT
                            ).show()
                            Log.d(
                                "PaymentSDK",
                                "Tokenization was finished successfully. Your token is ${payment.token}"
                            )
                        }
                        else -> {
                            Toast.makeText(
                                this,
                                "Payment was finished successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                            Log.d("PaymentSDK", "Payment was finished successfully")
                        }
                    }

                }
                EcmpPaymentSDK.RESULT_CANCELLED -> {
                    Toast.makeText(this, "Payment was cancelled", Toast.LENGTH_SHORT).show()
                    Log.d("PaymentSDK", "Payment was cancelled")
                }
                EcmpPaymentSDK.RESULT_DECLINE -> {
                    Toast.makeText(this, "Payment was declined", Toast.LENGTH_SHORT).show()
                    Log.d("PaymentSDK", "Payment was declined")
                }
                EcmpPaymentSDK.RESULT_ERROR -> {
                    val errorCode = data?.getStringExtra(EcmpPaymentSDK.EXTRA_ERROR_CODE)
                    val message = data?.getStringExtra(EcmpPaymentSDK.EXTRA_ERROR_MESSAGE)
                    Toast.makeText(
                        this,
                        "Payment was interrupted. See logs",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d(
                        "PaymentSDK",
                        "Payment was interrupted. Error code: $errorCode. Message: $message"
                    )
                }
            }
        }
}