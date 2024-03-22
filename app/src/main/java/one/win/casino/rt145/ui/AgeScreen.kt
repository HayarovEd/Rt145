package one.win.casino.rt145.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import one.win.casino.rt145.R
import one.win.casino.rt145.ui.state.MainEventRt145
import one.win.casino.rt145.ui.state.ApplicationStRt145
import one.win.casino.rt145.ui.theme.redRt145
import one.win.casino.rt145.ui.theme.whiteRt145

@Composable
fun AgeScreen(
    modifier: Modifier = Modifier,
    onEvent: (MainEventRt145) -> Unit,
    year: MutableIntState,
    month: MutableIntState,
    day: MutableIntState
) {
    BackHandler {}

    val activity = (LocalContext.current as? Activity)

    val warning = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight(500),
                fontSize = 14.sp,
                color = whiteRt145,
            )
        ) {
            append(stringResource(id = R.string.as_change_age))
        }
        append(" ")
        pushStringAnnotation(
            tag = stringResource(id = R.string.as_exit), annotation = ""
        )
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight(800),
                fontSize = 14.sp,
                color = whiteRt145
            )
        ) {
            append(stringResource(id = R.string.as_exit))
        }
        pop()
        append(" ")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight(500),
                fontSize = 14.sp,
                color = whiteRt145
            )
        ) {
            append(stringResource(id = R.string.as_from_app))
        }
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
                .align(Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.as_your_age),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    color = whiteRt145
                )
            )
            Spacer(modifier = modifier.height(70.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                ItemAge(
                    value = day.intValue,
                    title = stringResource(id = R.string.as_day),
                    onIncrement = {
                        if (day.intValue < 31) {
                            day.intValue++
                        }
                    },
                    onDecrement = {
                        if (day.intValue > 1) {
                            day.intValue--
                        }
                    }
                )
                ItemAge(
                    value = month.intValue,
                    title = stringResource(id = R.string.as_month),
                    onIncrement = {
                        if (month.intValue < 12) {
                            month.intValue++
                        }
                    },
                    onDecrement = {
                        if (month.intValue > 1) {
                            month.intValue--
                        }
                    }
                )
                ItemAge(
                    value = year.intValue,
                    title = stringResource(id = R.string.as_year),
                    onIncrement = {
                        if (year.intValue < 2024) {
                            year.intValue++
                        }
                    },
                    onDecrement = {
                        if (year.intValue > 1950) {
                            year.intValue--
                        }
                    }
                )
            }
            if (year.intValue > 2006) {
                Spacer(modifier = modifier.height(142.dp))
                Text(
                    text = stringResource(id = R.string.as_incorrect_age),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        textAlign = TextAlign.Center,
                        color = whiteRt145
                    )
                )
                Spacer(modifier = modifier.height(15.dp))
                ClickableText(
                    onClick = { offset ->
                        warning.getStringAnnotations(tag = "Выйти", offset, offset)
                            .firstOrNull()?.let { annotation ->
                                activity?.finish()
                            }
                    },
                    text = warning,
                )
                Spacer(modifier = modifier.height(42.dp))
            } else {
                Spacer(modifier = modifier.height(280.dp))
            }
            Button(
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = whiteRt145
                ),
                contentPadding = PaddingValues(
                    horizontal = 45.dp, vertical = 12.dp
                ),
                enabled = year.intValue <= 2006,
                onClick = {
                    onEvent(MainEventRt145.OnSetScreenState(ApplicationStRt145.EnterRt145))
                }
            ) {
                Text(
                    text = stringResource(id = R.string.as_continue),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        textAlign = TextAlign.Center,
                        color = redRt145
                    )
                )
            }
        }
    }
}

@Composable
private fun ItemAge(
    modifier: Modifier = Modifier,
    value: Int,
    title: String,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Center,
                color = whiteRt145
            )
        )
        Spacer(modifier = modifier.height(17.dp))
        IconButton(
            onClick = onIncrement
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_drop_up_16),
                contentDescription = "",
                tint = whiteRt145
            )
        }
        Spacer(modifier = modifier.height(17.dp))
        Text(
            text = value.toString(),
            style = TextStyle(
                fontSize = 35.sp,
                fontWeight = FontWeight(700),
                textAlign = TextAlign.Center,
                color = whiteRt145
            )
        )
        Spacer(modifier = modifier.height(17.dp))
        IconButton(
            onClick = onDecrement
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_drop_down_16),
                contentDescription = "",
                tint = whiteRt145
            )
        }
    }
}