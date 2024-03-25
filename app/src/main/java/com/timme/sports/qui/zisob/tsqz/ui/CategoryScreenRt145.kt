package com.timme.sports.qui.zisob.tsqz.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import com.timme.sports.qui.zisob.tsqz.R
import com.timme.sports.qui.zisob.tsqz.ui.state.MainEventRt145
import com.timme.sports.qui.zisob.tsqz.ui.state.RemoteCategoryRt145
import com.timme.sports.qui.zisob.tsqz.ui.state.ApplicationStRt145
import com.timme.sports.qui.zisob.tsqz.ui.theme.blackRt145
import com.timme.sports.qui.zisob.tsqz.ui.theme.redRt145
import com.timme.sports.qui.zisob.tsqz.ui.theme.whiteRt145


@Composable
fun CategoryScreenRt145(
    modifier: Modifier = Modifier,
    remoteCategoryRt145: RemoteCategoryRt145,
    onEvent: (MainEventRt145) -> Unit
) {
    BackHandler {
        onEvent(MainEventRt145.OnSetScreenState(ApplicationStRt145.EnterRt145))
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
                .padding(horizontal = 15.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth(),
            ) {
                Image(
                    modifier = modifier
                        .fillMaxWidth()
                        .clickable {
                            onEvent(MainEventRt145.OnSetRemoteCategory(RemoteCategoryRt145.FOOTBALL))
                        },
                    painter = painterResource(id = R.drawable.ct_football),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
                RadioButton(
                    modifier = modifier
                        .align(alignment = Alignment.TopStart)
                        .padding(20.dp),
                    colors = RadioButtonDefaults.colors(
                        selectedColor = whiteRt145,
                        unselectedColor = whiteRt145
                    ),
                    selected = remoteCategoryRt145 == RemoteCategoryRt145.FOOTBALL,
                    onClick = {
                        onEvent(MainEventRt145.OnSetRemoteCategory(RemoteCategoryRt145.FOOTBALL))
                    }
                )
            }
            Box(
                modifier = modifier
                    .fillMaxWidth(),
            ) {
                Image(
                    modifier = modifier
                        .fillMaxWidth()
                        .clickable {
                            onEvent(MainEventRt145.OnSetRemoteCategory(RemoteCategoryRt145.BASKETBALL))
                        },
                    painter = painterResource(id = R.drawable.ct_basketball),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
                RadioButton(
                    modifier = modifier
                        .align(alignment = Alignment.TopStart)
                        .padding(20.dp),
                    colors = RadioButtonDefaults.colors(
                        selectedColor = whiteRt145,
                        unselectedColor = whiteRt145
                    ),
                    selected = remoteCategoryRt145 == RemoteCategoryRt145.BASKETBALL,
                    onClick = {
                        onEvent(MainEventRt145.OnSetRemoteCategory(RemoteCategoryRt145.BASKETBALL))
                    }
                )
            }
            Box(
                modifier = modifier
                    .fillMaxWidth(),
            ) {
                Image(
                    modifier = modifier
                        .fillMaxWidth()
                        .clickable {
                            onEvent(MainEventRt145.OnSetRemoteCategory(RemoteCategoryRt145.HOCKEY))
                        },
                    painter = painterResource(id = R.drawable.ct_hockey),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
                RadioButton(
                    modifier = modifier
                        .align(alignment = Alignment.TopStart)
                        .padding(20.dp),
                    colors = RadioButtonDefaults.colors(
                        selectedColor = whiteRt145,
                        unselectedColor = whiteRt145
                    ),
                    selected = remoteCategoryRt145 == RemoteCategoryRt145.HOCKEY,
                    onClick = {
                        onEvent(MainEventRt145.OnSetRemoteCategory(RemoteCategoryRt145.HOCKEY))
                    }
                )
            }
            Button(
                modifier = modifier
                    .padding(horizontal = 45.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = redRt145
                ),
                contentPadding = PaddingValues(vertical = 12.dp),
                onClick = {
                    onEvent(MainEventRt145.OnSetScreenState(ApplicationStRt145.ScheduleRt145))
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