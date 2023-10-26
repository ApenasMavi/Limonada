package com.example.limonada

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.limonada.ui.theme.LimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Limonada() {
    var Clicar by remember{mutableStateOf(1)}
    var Imagem =1
    var text= 1
    var onClickImagem = {}
    var QTDClick by remember{ mutableStateOf(0) }

    when (Clicar) {
        1 -> {
            Imagem = R.drawable.limoeiro
            text = R.string.limoeiro
            onClickImagem = {
                Clicar = 2
                QTDClick = (2..4).random()
            }
        }

        2 -> {
            Imagem = R.drawable.limao
            text = R.string.limao
            onClickImagem = {
                if (QTDClick>0)
                    QTDClick--
                else
                Clicar = 3
            }
        }

        3 -> {
            Imagem = R.drawable.copo_limonada
            text = R.string.limonada
            onClickImagem = { Clicar = 4
            }
        }

        else -> {
            Imagem = R.drawable.copo
            text = R.string.copo
            onClickImagem = { Clicar = 1
            }
        }


    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = Imagem),
            contentDescription = null,
            modifier = Modifier
                .clickable (onClick = onClickImagem),

        )
        Text(
            text = stringResource(text)
        )


    }
}

