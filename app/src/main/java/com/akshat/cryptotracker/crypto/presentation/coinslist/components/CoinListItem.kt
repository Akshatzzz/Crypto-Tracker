package com.akshat.cryptotracker.crypto.presentation.coinslist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akshat.cryptotracker.crypto.domain.Coin
import com.akshat.cryptotracker.crypto.presentation.models.CoinUi
import com.akshat.cryptotracker.crypto.presentation.models.toCoinUI
import com.akshat.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun CoinListItem(
    modifier: Modifier = Modifier, coinUi: CoinUi, onClick: () -> Unit
) = with(coinUi) {
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(iconRes),
            contentDescription = name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(85.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = symbol,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = contentColor
            )
            Text(
                text = name,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = contentColor
            )
        }

        Column {
            Text(
                text = "$${priceUsd.formattedValue}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = contentColor
            )

            Spacer(modifier = Modifier.height(8.dp))

            ChangeItem(
                displayableNumber = changePercentage24Hrs
            )
        }
    }
}


@Preview
@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun CoinPreview() {
    CryptoTrackerTheme {
        CoinListItem(
            coinUi = previewCoin.toCoinUI(),
            onClick = {},
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}


internal val previewCoin = Coin(
    id = "1",
    rank = 1,
    name = "Bitcoin",
    symbol = "BTC",
    marketCapUsd = 1284233974328.32,
    priceUsd = 32134532.51,
    changePercentage24Hrs = -0.1,
)