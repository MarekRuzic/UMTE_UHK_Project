package cz.uhk.fim.cryptoapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cz.uhk.fim.cryptoapp.R
import cz.uhk.fim.cryptoapp.items.CryptoItem
import cz.uhk.fim.cryptoapp.viewmodels.FavouriteCryptoViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavouriteCryptoScreen(navController: NavController, viewModel: FavouriteCryptoViewModel = koinViewModel()) {

    val favouriteList by viewModel.favouriteCryptoList.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Favourite Crypto Screen")

        if(favouriteList.isEmpty())
        {
            Text(text = stringResource(R.string.no_favourite_crypto))
        }
        else
        {
            LazyColumn {
                itemsIndexed(favouriteList) {
                    index, item ->

                    CryptoItem(crypto = item, navController, isFavourite = true)
                }
            }
        }
    }
}