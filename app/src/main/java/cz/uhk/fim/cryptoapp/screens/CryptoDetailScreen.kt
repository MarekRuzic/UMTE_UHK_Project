import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cz.uhk.fim.cryptoapp.R
import cz.uhk.fim.cryptoapp.model.Crypto
import cz.uhk.fim.cryptoapp.repository.CryptoRepository
import cz.uhk.fim.cryptoapp.ui.theme.Purple80


@Composable
fun CryptoDetailScreen(navController: NavController, cryptoId: String) {
    //todo získat kryptoměnu podle ID a zobrazit její podrobnosti, pokud není žádná nalezena zobrazit chybovou hlášku
    val crypto: Crypto? = CryptoRepository.getCryptoById(cryptoId)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        if (crypto != null)  {

            Image(painter = painterResource(R.drawable.coin), contentDescription = "Crypto coin", modifier = Modifier.size(100.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = crypto.name, fontWeight = FontWeight.Bold, color = Purple80, style = TextStyle(
                fontSize = 48.sp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Symbol: ${crypto.symbol}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Price: ${crypto.priceUSD} USD")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Change 24h: ${crypto.changePercent24Hr}",
                color = if (crypto.changePercent24Hr.toDouble() >= 0) Color.Green else Color.Red
            )
            Spacer(modifier = Modifier.height(24.dp))
            IconButton(onClick = {
                //todo add to favourite
            }) {
                Icon(Icons.Filled.FavoriteBorder, contentDescription = "Add to favourite")
            }
        }

        // Tlačítko pro návrat zpět
        Button(onClick = { navController.popBackStack() }) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Go Back")
            Text("Go Back")
        }
    }
}