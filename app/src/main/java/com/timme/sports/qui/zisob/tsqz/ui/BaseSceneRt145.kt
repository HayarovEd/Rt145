package com.timme.sports.qui.zisob.tsqz.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.timme.sports.qui.zisob.tsqz.ui.state.MainViewModelRt145
import com.timme.sports.qui.zisob.tsqz.ui.state.ApplicationStRt145

@Composable
fun BaseSceneRt145(
    viewModel: MainViewModelRt145 = hiltViewModel()
) {
    val stateRt145 = viewModel.state.collectAsState()
    val eventRt145 = viewModel::onEventRt145

    val day = remember { mutableIntStateOf(1) }
    val month = remember { mutableIntStateOf(1) }
    val year = remember { mutableIntStateOf(2009) }
    when (stateRt145.value.applicationStRt145) {
        ApplicationStRt145.AgeRt145 -> {
            AgeScreen(
                day = day,
                month = month,
                year = year,
                onEvent = eventRt145)
        }

        ApplicationStRt145.AskRt145 -> {
            AskScreen(onEvent = eventRt145)
        }

        ApplicationStRt145.EnterRt145 -> {
            EnterScreen(
                isFirst = stateRt145.value.isFirst,
                onEvent = eventRt145)
        }

        ApplicationStRt145.QuizRt145 -> {
            QuizScreenRt145(
                selectorQuizRt145 = stateRt145.value.selectorQuizRt145,
                quizTaskRt145 = stateRt145.value.tasksRt145[stateRt145.value.countTasks - 1],
                number = stateRt145.value.countTasks,
                size = stateRt145.value.tasksRt145.size,
                onEvent = eventRt145
            )
        }

        ApplicationStRt145.RemoteCategoryRt145 -> {
            CategoryScreenRt145(
                remoteCategoryRt145 = stateRt145.value.remoteCategoryRt145,
                onEvent = eventRt145
            )
        }

        ApplicationStRt145.ResulQuizRt145 -> {
            ResultScreenRt145(
                selectorQuizRt145 = stateRt145.value.selectorQuizRt145,
                size = stateRt145.value.tasksRt145.size,
                countGood = stateRt145.value.countGood,
                onEvent = eventRt145
            )
        }

        ApplicationStRt145.SelectQuizRt145 -> {
            SelectQuizScreen(
                selectorQuizRt145 = stateRt145.value.selectorQuizRt145,
                size = stateRt145.value.tasksRt145.size,
                onEvent = eventRt145
            )
        }

        ApplicationStRt145.ScheduleRt145 -> {
            ScheduleScreenRt145(
                remoteCategoryRt145 = stateRt145.value.remoteCategoryRt145,
                footballData = stateRt145.value.footballData,
                basketballData = stateRt145.value.basketballData,
                hockeyData = stateRt145.value.hockeyData,
                onEvent = eventRt145
            )
        }

        ApplicationStRt145.WebRt145 -> {
            WebViewScreen(
                url = stateRt145.value.urlRt145,
                onEvent = eventRt145
            )
        }
    }
}