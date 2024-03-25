package com.timme.sports.qui.zisob.tsqz.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timme.sports.qui.zisob.tsqz.R
import com.timme.sports.qui.zisob.tsqz.domain.model.GameDataRt145
import com.timme.sports.qui.zisob.tsqz.ui.state.MainEventRt145
import com.timme.sports.qui.zisob.tsqz.ui.state.RemoteCategoryRt145
import com.timme.sports.qui.zisob.tsqz.ui.state.ApplicationStRt145
import com.timme.sports.qui.zisob.tsqz.ui.theme.blackRt145
import com.timme.sports.qui.zisob.tsqz.ui.theme.redRt145
import com.timme.sports.qui.zisob.tsqz.ui.theme.roseRt145
import com.timme.sports.qui.zisob.tsqz.ui.theme.whiteRt145


@Composable
fun ScheduleScreenRt145(
    modifier: Modifier = Modifier,
    remoteCategoryRt145: RemoteCategoryRt145,
    footballData: List<GameDataRt145>,
    basketballData: List<GameDataRt145>,
    hockeyData: List<GameDataRt145>,
    onEvent: (MainEventRt145) -> Unit
) {
    BackHandler {
        onEvent(MainEventRt145.OnSetScreenState(ApplicationStRt145.RemoteCategoryRt145))
    }
    val remoteRt145 = when (remoteCategoryRt145) {
        RemoteCategoryRt145.FOOTBALL -> footballData
        RemoteCategoryRt145.BASKETBALL -> basketballData
        RemoteCategoryRt145.HOCKEY -> hockeyData
    }
    val icon = when (remoteCategoryRt145) {
        RemoteCategoryRt145.FOOTBALL -> ImageVector.vectorResource(id = R.drawable.sports_soccer_fill0_wght400_grad0_opsz48)
        RemoteCategoryRt145.BASKETBALL -> ImageVector.vectorResource(id = R.drawable.baseline_sports_basketball_24)
        RemoteCategoryRt145.HOCKEY -> ImageVector.vectorResource(id = R.drawable.baseline_sports_hockey_24)
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
                    text = stringResource(id = R.string.es_match_schedule),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        textAlign = TextAlign.Center,
                        color = blackRt145
                    )
                )
                IconButton(
                    modifier = modifier.align(alignment = Alignment.CenterStart),
                    onClick = {
                        onEvent(MainEventRt145.OnSetScreenState(ApplicationStRt145.RemoteCategoryRt145))
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                        contentDescription = "",
                        tint = blackRt145
                    )
                }
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
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = if (remoteCategoryRt145 == RemoteCategoryRt145.FOOTBALL) 10.dp else 2.dp,
                    ),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = whiteRt145,
                    ),
                    onClick = {
                        onEvent(MainEventRt145.OnSetRemoteCategory(RemoteCategoryRt145.FOOTBALL))
                    }) {
                    Text(
                        text = stringResource(id = R.string.football),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500),
                            textAlign = TextAlign.Center,
                            color = if (remoteCategoryRt145 == RemoteCategoryRt145.FOOTBALL) redRt145 else blackRt145,
                        )
                    )
                }
                Spacer(modifier = modifier.width(5.dp))
                Button(
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = if (remoteCategoryRt145 == RemoteCategoryRt145.BASKETBALL) 10.dp else 2.dp,
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = whiteRt145
                    ),
                    shape = RoundedCornerShape(8.dp),
                    onClick = {
                        onEvent(MainEventRt145.OnSetRemoteCategory(RemoteCategoryRt145.BASKETBALL))
                    }) {
                    Text(
                        text = stringResource(id = R.string.basketball),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500),
                            textAlign = TextAlign.Center,
                            color = if (remoteCategoryRt145 == RemoteCategoryRt145.BASKETBALL) redRt145 else blackRt145,
                        )
                    )
                }
                Spacer(modifier = modifier.width(5.dp))
                Button(
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = if (remoteCategoryRt145 == RemoteCategoryRt145.HOCKEY) 10.dp else 2.dp,
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = whiteRt145
                    ),
                    shape = RoundedCornerShape(8.dp),
                    onClick = {
                        onEvent(MainEventRt145.OnSetRemoteCategory(RemoteCategoryRt145.HOCKEY))
                    }) {
                    Text(
                        text = stringResource(id = R.string.hockey),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500),
                            textAlign = TextAlign.Center,
                            color = if (remoteCategoryRt145 == RemoteCategoryRt145.HOCKEY) redRt145 else blackRt145,
                        )
                    )
                }
            }

            if (remoteRt145.isEmpty()) {
                Spacer(modifier = modifier.height(100.dp))
                Text(
                    text = stringResource(R.string.check_internet),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(500),
                        textAlign = TextAlign.Center,
                        color = blackRt145,
                    )
                )
            } else {
                Spacer(modifier = modifier.height(25.dp))
                LazyColumn(
                    modifier = modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                ) {
                    items(remoteRt145) { remote ->
                        Card(
                            modifier = modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 10.dp
                            ),
                            colors = CardDefaults.cardColors(
                                containerColor = whiteRt145
                            )
                        ) {
                            Column(
                                modifier = modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 17.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = "",
                                        tint = remote.homeColor
                                    )
                                    Spacer(modifier = modifier.width(10.dp))
                                    Text(
                                        text = "${remote.homeScoreRt145} : ${remote.awayScoreRt145}",
                                        style = TextStyle(
                                            fontSize = 34.sp,
                                            fontWeight = FontWeight(600),
                                            textAlign = TextAlign.Center,
                                            color = blackRt145
                                        )
                                    )
                                    Spacer(modifier = modifier.width(10.dp))
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = "",
                                        tint = remote.awayColor
                                    )
                                }
                                Spacer(modifier = modifier.height(10.dp))
                                Row(
                                    modifier = modifier
                                        .clip(RoundedCornerShape(22.dp))
                                        .background(color = redRt145)
                                        .padding(vertical = 5.dp, horizontal = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Icon(
                                        imageVector = ImageVector.vectorResource(R.drawable.baseline_circle_24),
                                        contentDescription = "",
                                        tint = whiteRt145
                                    )
                                    Spacer(modifier = modifier.width(5.dp))
                                    Text(
                                        text = remote.statusGameRt145,
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight(500),
                                            textAlign = TextAlign.Center,
                                            color = whiteRt145
                                        )
                                    )
                                }
                                Spacer(modifier = modifier.height(10.dp))
                                Row(
                                    modifier = modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceAround,
                                ) {
                                    Text(
                                        text = remote.homeNameRt145,
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight(600),
                                            textAlign = TextAlign.Center,
                                            color = blackRt145
                                        )
                                    )
                                    Text(
                                        text = remote.awayNameRt145,
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight(600),
                                            textAlign = TextAlign.Center,
                                            color = blackRt145
                                        )
                                    )
                                }
                                Spacer(modifier = modifier.height(10.dp))
                                Text(
                                    text = remote.dateTimeRt145,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(600), textAlign = TextAlign.Center,
                                        color = roseRt145
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}