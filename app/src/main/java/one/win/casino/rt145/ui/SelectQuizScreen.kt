package one.win.casino.rt145.ui

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import one.win.casino.rt145.R
import one.win.casino.rt145.ui.state.SelectorQuizRt145
import one.win.casino.rt145.ui.theme.black
import one.win.casino.rt145.ui.theme.red
import one.win.casino.rt145.ui.theme.white

@Preview
@Composable
fun SelectQuizScreen(
    modifier: Modifier = Modifier,
    selectorQuizRt145: SelectorQuizRt145 = SelectorQuizRt145.BASKETBALL_QUIZ,
    size: Int = 10,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = white)
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
                        color = black
                    )
                )
                IconButton(
                    modifier = modifier.align(alignment = Alignment.CenterStart),
                    onClick = {
                        ////////
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                        contentDescription = "",
                        tint = black
                    )
                }
            }

        }
    ) { paddings ->
        Box(
            modifier = modifier
                .padding(paddings)
                .fillMaxSize()
                .background(color = white)
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
                            containerColor = white,
                        ),
                        onClick = {
                            //////////
                        }) {
                        Text(
                            text = stringResource(id = R.string.football),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                color = if (selectorQuizRt145 == SelectorQuizRt145.FOOTBALL_QUIZ) red else black,
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
                            containerColor = white
                        ),
                        shape = RoundedCornerShape(8.dp),
                        onClick = {
                            //////////
                        }) {
                        Text(
                            text = stringResource(id = R.string.basketball),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                color = if (selectorQuizRt145 == SelectorQuizRt145.BASKETBALL_QUIZ) red else black,
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
                            containerColor = white
                        ),
                        shape = RoundedCornerShape(8.dp),
                        onClick = {
                            //////////
                        }) {
                        Text(
                            text = stringResource(id = R.string.hockey),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                color = if (selectorQuizRt145 == SelectorQuizRt145.HOCKEY_QUIZ) red else black,
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
                            containerColor = white
                        ),
                        shape = RoundedCornerShape(8.dp),
                        onClick = {
                            //////////
                        }) {
                        Text(
                            text = stringResource(id = R.string.volleyball),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                color = if (selectorQuizRt145 == SelectorQuizRt145.VOLLEYBALL_QUIZ) red else black,
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
                            containerColor = white
                        ),
                        shape = RoundedCornerShape(8.dp),
                        onClick = {
                            //////////
                        }) {
                        Text(
                            text = stringResource(id = R.string.tennis),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                color = if (selectorQuizRt145 == SelectorQuizRt145.TENNIS_QUIZ) red else black,
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
                            containerColor = white
                        ),
                        shape = RoundedCornerShape(8.dp),
                        onClick = {
                            //////////
                        }) {
                        Text(
                            text = stringResource(id = R.string.boxing),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                color = if (selectorQuizRt145 == SelectorQuizRt145.BOXING_QUIZ) red else black,
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
                Text(
                    text = "${stringResource(id = R.string.categoty)} $category",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        textAlign = TextAlign.Center,
                        color = black,
                    )
                )
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    text = "${stringResource(id = R.string.all_in_category)} $size ${stringResource(id = R.string.questions)}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        textAlign = TextAlign.Center,
                        color = black,
                    )
                )
                Spacer(modifier = modifier.height(25.dp))
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
                        text = stringResource(id = R.string.go_to_quiz),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight(600),
                            textAlign = TextAlign.Center,
                            color = white
                        )
                    )
                }
            }
        }
    }
}