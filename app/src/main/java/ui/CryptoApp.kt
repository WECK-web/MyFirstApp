package com.example.hercryptoapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.hercryptoapp.data.model.CryptoModel
import com.example.hercryptoapp.viewmodel.CryptoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit
) {
    TextField(
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = { Text("Search cryptocurrencies...") },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    )
}

@Composable
fun CryptoApp(viewModel: CryptoViewModel) {
    val cryptoList by viewModel.cryptoList
    val searchQuery by viewModel.searchQuery

    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar(
            searchQuery = searchQuery,
            onSearchQueryChange = { viewModel.updateSearchQuery(it) }
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(cryptoList) { crypto ->
                CryptoListItem(crypto)
            }
        }
    }
}

@Composable
fun CryptoListItem(crypto: CryptoModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = crypto.image,
                contentDescription = "${crypto.name} icon",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 16.dp),
                contentScale = ContentScale.Fit
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = crypto.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = crypto.symbol.uppercase(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "$${String.format("%,.2f", crypto.current_price)}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "${String.format("%.2f", crypto.price_change_percentage_24h)}%",
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (crypto.price_change_percentage_24h >= 0)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.error
                )
            }
        }
    }
}