package com.asimodabas.compose_notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asimodabas.compose_notes.model.CryptoModel
import com.asimodabas.compose_notes.service.CryptoAPI
import com.asimodabas.compose_notes.ui.theme.ComposeNotesTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNotesTheme {
                mainScreen()
            }
        }
    }
}

@Composable
fun mainScreen() {

    var cryptoModels  = remember { mutableStateListOf<CryptoModel>() }

    val BASE_URL = "https://raw.githubusercontent.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CryptoAPI::class.java)

    val call = retrofit.getData()
    call.enqueue(object : Callback<List<CryptoModel>> {
        override fun onResponse(
            call: Call<List<CryptoModel>>,
            response: Response<List<CryptoModel>>
        ) {
            if (response.isSuccessful) {
                response.body()?.let {
                    cryptoModels.addAll(it)
                }
            }
        }

        override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
            t.printStackTrace()
        }

    })

    Scaffold(topBar = { AppBar() }) {
        CryList(cryptos = cryptoModels)
    }
}

@Composable
fun CryList(cryptos: List<CryptoModel>) {
    LazyColumn() {
        items(cryptos) { crypto ->
            CryptorRow(cryptoName = crypto)
        }
    }
}

@Composable
fun CryptorRow(cryptoName: CryptoModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.surface)
    ) {
        Text(
            text = cryptoName.currency,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = cryptoName.price,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold
        )

    }
}


@Composable
fun AppBar() {
    TopAppBar(contentPadding = PaddingValues(5.dp)) {
        Text(
            text = "Crypto Tracking",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeNotesTheme {
        CryptorRow(cryptoName = CryptoModel("BTC", "123456"))
    }
}

