package cz.uhk.fim.cryptoapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cz.uhk.fim.cryptoapp.items.CryptoItem
import cz.uhk.fim.cryptoapp.repository.CryptoRepository
import cz.uhk.fim.cryptoapp.viewmodels.FavouriteCryptoViewModel
import org.koin.androidx.compose.koinViewModel
import org.w3c.dom.Text


@Composable
fun CryptoListScreen(navController: NavController, viewModel: FavouriteCryptoViewModel = koinViewModel()) {
    //todo získat list kryptoměn a jednotlivé kryptoměny vykreslit
    val cryptoList = CryptoRepository.getCryptoList()
    val favourites = viewModel.favouriteCryptoList.collectAsState()
    Column(modifier = Modifier.padding(16.dp))
    {
        Text("Favourite screen")
        Spacer(modifier = Modifier.height(16.dp))
        cryptoList.forEach {
            crypto ->
            val isFavourite = favourites.value.contains(crypto)
            CryptoItem(crypto, navController)
        }
    }
}
