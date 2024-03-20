package one.win.casino.rt145.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
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
import one.win.casino.rt145.ui.state.MainEventRt145
import one.win.casino.rt145.ui.state.RemoteCategoryRt145
import one.win.casino.rt145.ui.state.ScreenStateRt145
import one.win.casino.rt145.ui.theme.blackRt145
import one.win.casino.rt145.ui.theme.redRt145
import one.win.casino.rt145.ui.theme.whiteRt145


@Composable
fun CategoryScreenRt145(
    modifier: Modifier = Modifier,
    remoteCategoryRt145: RemoteCategoryRt145,
    onEvent: (MainEventRt145) -> Unit
) {
    BackHandler {
        onEvent(MainEventRt145.OnSetScreenState(ScreenStateRt145.EnterStateRt145))
    }
    Scaffold(
        modifier = modifier,
        topBar = {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = whiteRt145)
            ) {
                Text(
                    modifier = modifier
                        .align(alignment = Alignment.Center)
                        .fillMaxWidth(),
                    text = stringResource(id = R.string.choose_category),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        textAlign = TextAlign.Center,
                        color = blackRt145
                    )
                )
            }

        }
    ) { paddings ->
        Column(
            modifier = modifier
                .padding(paddings)
                .fillMaxSize()
                .background(color = whiteRt145)
                .padding(horizontal = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth(),
            ) {
                Image(
                    modifier = modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.ct_football),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
                RadioButton(
                    modifier = modifier
                        .align(alignment = Alignment.TopStart)
                        .padding(20.dp),
                    selected = remoteCategoryRt145 == RemoteCategoryRt145.FOOTBALL,
                    onClick = {
                        onEvent(MainEventRt145.OnSetRemoteCategory(RemoteCategoryRt145.FOOTBALL))
                    }
                )
            }
            Spacer(modifier = modifier.height(25.dp))
            Box(
                modifier = modifier
                    .fillMaxWidth(),
            ) {
                Image(
                    modifier = modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.ct_basketball),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
                RadioButton(
                    modifier = modifier
                        .align(alignment = Alignment.TopStart)
                        .padding(20.dp),
                    selected = remoteCategoryRt145 == RemoteCategoryRt145.BASKETBALL,
                    onClick = {
                        onEvent(MainEventRt145.OnSetRemoteCategory(RemoteCategoryRt145.BASKETBALL))
                    }
                )
            }
            Spacer(modifier = modifier.height(25.dp))
            Box(
                modifier = modifier
                    .fillMaxWidth(),
            ) {
                Image(
                    modifier = modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.ct_hockey),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
                RadioButton(
                    modifier = modifier
                        .align(alignment = Alignment.TopStart)
                        .padding(20.dp),
                    selected = remoteCategoryRt145 == RemoteCategoryRt145.HOCKEY,
                    onClick = {
                        onEvent(MainEventRt145.OnSetRemoteCategory(RemoteCategoryRt145.HOCKEY))
                    }
                )
            }
            Spacer(modifier = modifier.height(25.dp))
            Button(
                modifier = modifier
                    .padding(horizontal = 45.dp, vertical = 40.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = redRt145
                ),
                contentPadding = PaddingValues(vertical = 12.dp),
                onClick = {
                    onEvent(MainEventRt145.OnSetScreenState(ScreenStateRt145.ScheduleStateRt145))
                }
            ) {
                Text(
                    text = stringResource(id = R.string.confirm),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        textAlign = TextAlign.Center,
                        color = whiteRt145
                    )
                )
            }
        }
    }
}