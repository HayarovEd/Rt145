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
fun ResultScreenRt145(
    modifier: Modifier = Modifier,
    selectorQuizRt145: SelectorQuizRt145,
    size: Int,
    countGood: Int,
    onEvent: (MainEventRt145) -> Unit
) {
    val category = when (selectorQuizRt145) {
        SelectorQuizRt145.FOOTBALL_QUIZ -> stringResource(id = R.string.football)
        SelectorQuizRt145.BASKETBALL_QUIZ -> stringResource(id = R.string.basketball)
        SelectorQuizRt145.HOCKEY_QUIZ -> stringResource(id = R.string.hockey)
        SelectorQuizRt145.VOLLEYBALL_QUIZ -> stringResource(id = R.string.volleyball)
        SelectorQuizRt145.TENNIS_QUIZ -> stringResource(id = R.string.tennis)
        SelectorQuizRt145.BOXING_QUIZ -> stringResource(id = R.string.boxing)
    }
    val image = if (countGood >= size / 2) {
        painterResource(id = R.drawable.good)
    } else {
        painterResource(id = R.drawable.bad)
    }
    val titleRt145 = if (countGood >= size / 2) {
        stringResource(id = R.string.good)
    } else {
        stringResource(id = R.string.bad)
    }
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
                    text = "${stringResource(id = R.string.quiz)} $category",
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
                        onEvent(MainEventRt145.OnSetScreenState(ScreenStateRt145.EnterStateRt145))
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
                modifier = modifier
                    .align(alignment = Alignment.Center)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = modifier
                        .fillMaxWidth(),
                ) {
                    Image(
                        modifier = modifier
                            .fillMaxWidth(),
                        painter = image,
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        modifier = modifier
                            .align(alignment = Alignment.Center)
                            .fillMaxWidth(),
                        text = "$countGood / $size",
                        style = TextStyle(
                            fontSize = 78.sp,
                            fontWeight = FontWeight(700),
                            textAlign = TextAlign.Center,
                            color = whiteRt145
                        )
                    )
                }
                Spacer(modifier = modifier.height(18.dp))
                Text(
                    modifier = modifier
                        .fillMaxWidth(),
                    text = titleRt145,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        textAlign = TextAlign.Center,
                        color = blackRt145
                    )
                )
            }
            Button(
                modifier = modifier
                    .align(alignment = Alignment.BottomCenter)
                    .padding(horizontal = 45.dp, vertical = 40.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = redRt145
                ),
                contentPadding = PaddingValues(vertical = 12.dp),
                onClick = {
                    onEvent(MainEventRt145.OnSetScreenState(ScreenStateRt145.RemoteCategoryStateRt145))
                }
            ) {
                Text(
                    text = stringResource(id = R.string.back),
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