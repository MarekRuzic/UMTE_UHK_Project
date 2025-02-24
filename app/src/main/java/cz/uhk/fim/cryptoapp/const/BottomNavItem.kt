package cz.uhk.fim.cryptoapp.const

import android.media.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector, val screenRoute: String) {
    object CryptoList : BottomNavItem("Home", Icons.Filled.Home, Routes.CryptoList)
    object FavouriteCrypto : BottomNavItem("Favourite", Icons.Filled.FavoriteBorder, Routes.FavouriteCrypto)
}