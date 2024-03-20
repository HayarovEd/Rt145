package one.win.casino.rt145.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import one.win.casino.rt145.R
import one.win.casino.rt145.ui.state.MainEventRt145
import one.win.casino.rt145.ui.state.ScreenStateRt145
import one.win.casino.rt145.ui.state.SelectorQuizRt145
import one.win.casino.rt145.ui.theme.blackRt145
import one.win.casino.rt145.ui.theme.redRt145
import one.win.casino.rt145.ui.theme.whiteRt145


@Composable
fun SelectQuizScreen(
    modifier: Modifier = Modifier,
    selectorQuizRt145: SelectorQuizRt145,
    size: Int,
    onEvent: (MainEventRt145) -> Unit
) {
    BackHandler {
        onEvent(MainEventRt145.OnSetScreenState(ScreenStateRt145.AskState))
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
                        onEvent(MainEventRt145.OnSetScreenState(ScreenStateRt145.AskState))
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
        Box(
            modifier = modifier
                .padding(paddings)
                .fillMaxSize()
                .background(color = whiteRt145)
                .padding(horizontal = 15.dp)
        ) {
            Column(
                modifier = modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Button(
                        modifier = modifier.weight(1f),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = if (selectorQuizRt145 == SelectorQuizRt145.FOOTBALL_QUIZ) 10.dp else 2.dp,
                        ),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = whiteRt145,
                        ),
                        onClick = {
                            onEvent(MainEventRt145.OnSetTypeQuizState(SelectorQuizRt145.FOOTBALL_QUIZ))
                        }) {
                        Text(
                            text = stringResource(id = R.string.football),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                color = if (selectorQuizRt145 == SelectorQuizRt145.FOOTBALL_QUIZ) redRt145 else blackRt145,
                            )
                        )
                    }
                    Spacer(modifier = modifier.width(5.dp))
                    Button(
                        modifier = modifier.weight(1f),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = if (selectorQuizRt145 == SelectorQuizRt145.BASKETBALL_QUIZ) 10.dp else 2.dp,
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = whiteRt145
                        ),
                        shape = RoundedCornerShape(8.dp),
                        onClick = {
                            onEvent(MainEventRt145.OnSetTypeQuizState(SelectorQuizRt145.BASKETBALL_QUIZ))
                        }) {
                        Text(
                            text = stringResource(id = R.string.basketball),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                color = if (selectorQuizRt145 == SelectorQuizRt145.BASKETBALL_QUIZ) redRt145 else blackRt145,
                            )
                        )
                    }
                    Spacer(modifier = modifier.width(5.dp))
                    Button(
                        modifier = modifier.weight(1f),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = if (selectorQuizRt145 == SelectorQuizRt145.HOCKEY_QUIZ) 10.dp else 2.dp,
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = whiteRt145
                        ),
                        shape = RoundedCornerShape(8.dp),
                        onClick = {
                            onEvent(MainEventRt145.OnSetTypeQuizState(SelectorQuizRt145.HOCKEY_QUIZ))
                        }) {
                        Text(
                            text = stringResource(id = R.string.hockey),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                color = if (selectorQuizRt145 == SelectorQuizRt145.HOCKEY_QUIZ) redRt145 else blackRt145,
                            )
                        )
                    }
                }
                Spacer(modifier = modifier.height(10.dp))
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Button(
                        modifier = modifier.weight(1f),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = if (selectorQuizRt145 == SelectorQuizRt145.VOLLEYBALL_QUIZ) 10.dp else 2.dp,
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = whiteRt145
                        ),
                        shape = RoundedCornerShape(8.dp),
                        onClick = {
                            onEvent(MainEventRt145.OnSetTypeQuizState(SelectorQuizRt145.VOLLEYBALL_QUIZ))
                        }) {
                        Text(
                            text = stringResource(id = R.string.volleyball),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                color = if (selectorQuizRt145 == SelectorQuizRt145.VOLLEYBALL_QUIZ) redRt145 else blackRt145,
                            )
                        )
                    }
                    Spacer(modifier = modifier.width(5.dp))
                    Button(
                        modifier = modifier.weight(1f),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = if (selectorQuizRt145 == SelectorQuizRt145.TENNIS_QUIZ) 10.dp else 2.dp,
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = whiteRt145
                        ),
                        shape = RoundedCornerShape(8.dp),
                        onClick = {
                            onEvent(MainEventRt145.OnSetTypeQuizState(SelectorQuizRt145.TENNIS_QUIZ))
                        }) {
                        Text(
                            text = stringResource(id = R.string.tennis),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                color = if (selectorQuizRt145 == SelectorQuizRt145.TENNIS_QUIZ) redRt145 else blackRt145,
                            )
                        )
                    }
                    Spacer(modifier = modifier.width(5.dp))
                    Button(
                        modifier = modifier.weight(1f),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = if (selectorQuizRt145 == SelectorQuizRt145.BOXING_QUIZ) 10.dp else 2.dp,
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = whiteRt145
                        ),
                        shape = RoundedCornerShape(8.dp),
                        onClick = {
                            onEvent(MainEventRt145.OnSetTypeQuizState(SelectorQuizRt145.BOXING_QUIZ))
                        }) {
                        Text(
                            text = stringResource(id = R.string.boxing),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                color = if (selectorQuizRt145 == SelectorQuizRt145.BOXING_QUIZ) redRt145 else blackRt145,
                            )
                        )
                    }
                }
            }
            Column(
                modifier = modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val category = when (selectorQuizRt145) {
                    SelectorQuizRt145.FOOTBALL_QUIZ -> stringResource(id = R.string.football)
                    SelectorQuizRt145.BASKETBALL_QUIZ -> stringResource(id = R.string.basketball)
                    SelectorQuizRt145.HOCKEY_QUIZ -> stringResource(id = R.string.hockey)
                    SelectorQuizRt145.VOLLEYBALL_QUIZ -> stringResource(id = R.string.volleyball)
                    SelectorQuizRt145.TENNIS_QUIZ -> stringResource(id = R.string.tennis)
                    SelectorQuizRt145.BOXING_QUIZ -> stringResource(id = R.string.boxing)
                }
                val image = when (selectorQuizRt145) {
                    SelectorQuizRt145.FOOTBALL_QUIZ -> painterResource(id = R.drawable.football)
                    SelectorQuizRt145.BASKETBALL_QUIZ -> painterResource(id = R.drawable.basketball)
                    SelectorQuizRt145.HOCKEY_QUIZ -> painterResource(id = R.drawable.hokkey)
                    SelectorQuizRt145.VOLLEYBALL_QUIZ -> painterResource(id = R.drawable.volleyball)
                    SelectorQuizRt145.TENNIS_QUIZ -> painterResource(id = R.drawable.tennis)
                    SelectorQuizRt145.BOXING_QUIZ -> painterResource(id = R.drawable.boxing)
                }
                Image(
                    modifier = modifier.fillMaxWidth(),
                    painter = image,
                    contentDescription = category,
                    contentScale = ContentScale.FillWidth
                )
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    text = "${stringResource(id = R.string.categoty)} $category",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        textAlign = TextAlign.Center,
                        color = blackRt145,
                    )
                )
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    text = "${stringResource(id = R.string.all_in_category)} $size ${
                        stringResource(
                            id = R.string.questions
                        )
                    }",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        textAlign = TextAlign.Center,
                        color = blackRt145,
                    )
                )
                Spacer(modifier = modifier.height(25.dp))
                Button(
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = redRt145
                    ),
                    contentPadding = PaddingValues(
                        horizontal = 45.dp, vertical = 12.dp
                    ),
                    onClick = {
                        onEvent(MainEventRt145.OnSetScreenState(ScreenStateRt145.QuizState))
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.go_to_quiz),
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
}