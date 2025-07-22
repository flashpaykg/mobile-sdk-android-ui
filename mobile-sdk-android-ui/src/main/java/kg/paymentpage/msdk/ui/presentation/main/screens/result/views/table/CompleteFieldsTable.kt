package kg.paymentpage.msdk.ui.presentation.main.screens.result.views.table

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.paymentpage.msdk.core.domain.entities.completefield.CompleteField
import kg.paymentpage.msdk.ui.theme.SDKTheme
import kg.paymentpage.msdk.ui.utils.extensions.core.getStringOverride
import kg.paymentpage.msdk.ui.views.common.SDKTable

@Composable
internal fun CompleteFieldsTable(
    completeFields: List<CompleteField>
) {
    val completeFieldsMap = completeFields.associate { field ->
        val translation =
            field.name?.let { getStringOverride(it) }
                ?: field.defaultLabel
        translation to field.value
    }

    SDKTable(
        tableMap = completeFieldsMap,
        labelTextStyle = SDKTheme.typography.s14Light.copy(color = SDKTheme.colors.grey),
        valueTextStyle = SDKTheme.typography.s14Normal,
        spaceBetweenItems = 15.dp
    )
}