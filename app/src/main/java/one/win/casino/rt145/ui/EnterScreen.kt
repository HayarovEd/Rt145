package one.win.casino.rt145.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import one.win.casino.rt145.R
import one.win.casino.rt145.ui.theme.red
import one.win.casino.rt145.ui.theme.white

@Preview
@Composable
fun EnterScreen(
    modifier: Modifier = Modifier
) {
    BackHandler {
        //////////
    }
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.base_background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(21.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.men),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = modifier.height(35.dp))
            Button(
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = red
                ),
                contentPadding = PaddingValues(
                    horizontal = 45.dp, vertical = 12.dp
                ),
                onClick = {
                    //////////////
                }
            ) {
                Text(
                    text = stringResource(id = R.string.es_enter),
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight(700),
                        textAlign = TextAlign.Center,
                        color = white
                    )
                )
            }
        }
        Button(
            modifier = modifier
                .padding(bottom = 100.dp)
                .align(alignment = Alignment.BottomCenter),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = white
            ),
            contentPadding = PaddingValues(
                horizontal = 45.dp, vertical = 12.dp
            ),
            onClick = {
                //////////////
            }
        ) {
            Text(
                text = stringResource(id = R.string.es_match_schedule),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = red
                )
            )
        }
    }
}