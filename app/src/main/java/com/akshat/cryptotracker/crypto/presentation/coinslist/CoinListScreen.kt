package com.akshat.cryptotracker.crypto.presentation.coinslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.akshat.cryptotracker.crypto.presentation.coinslist.components.CoinListItem
import com.akshat.cryptotracker.crypto.presentation.coinslist.components.previewCoin
import com.akshat.cryptotracker.crypto.presentation.models.CoinsListState
import com.akshat.cryptotracker.crypto.presentation.models.toCoinUI
import com.akshat.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun CoinListScreen(
    modifier: Modifier = Modifier, coinsListState: CoinsListState
) = with(coinsListState) {
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(coins) {
                CoinListItem(
                    coinUi = it
                ) { TODO("handle click") }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun CoinListPrev() {
    CryptoTrackerTheme {
        CoinListScreen(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            coinsListState = CoinsListState(
                false, coins = List(100) { previewCoin.toCoinUI().copy(id = it.toString()) }
            )
        )
    }
}