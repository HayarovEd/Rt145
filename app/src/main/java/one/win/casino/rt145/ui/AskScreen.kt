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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import one.win.casino.rt145.R
import one.win.casino.rt145.ui.theme.red
import one.win.casino.rt145.ui.theme.white

@Composable
fun AskScreen(
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
                .padding(top = 70.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.is_quiz),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = white
                )
            )
            Spacer(modifier = modifier.height(40.dp))
            Button(
                modifier = modifier
                    .padding(horizontal = 77.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = red
                ),
                contentPadding = PaddingValues(vertical = 12.dp),
                onClick = {
                    //////////////
                }
            ) {
                Text(
                    text = stringResource(id = R.string.go_to_quiz),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        textAlign = TextAlign.Center,
                        color = white
                    )
                )
            }
            Spacer(modifier = modifier.height(30.dp))
            Button(
                modifier = modifier
                    .padding(horizontal = 77.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = white
                ),
                contentPadding = PaddingValues(vertical = 12.dp),
                onClick = {
                    //////////////
                }
            ) {
                Text(
                    text = stringResource(id = R.string.skip),
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
}