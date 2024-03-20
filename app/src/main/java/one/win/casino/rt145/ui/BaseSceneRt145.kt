package one.win.casino.rt145.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import one.win.casino.rt145.ui.state.MainViewModelRt145
import one.win.casino.rt145.ui.state.ScreenStateRt145

@Composable
fun BaseSceneRt145(
    viewModel: MainViewModelRt145 = hiltViewModel()
) {
    val stateRt145 = viewModel.state.collectAsState()
    val eventRt145 = viewModel::onEventRt145

    when (stateRt145.value.screenStateRt145) {
        ScreenStateRt145.AgeStateRt145 -> {
            AgeScreen(onEvent = eventRt145)
        }

        ScreenStateRt145.AskStateRt145 -> {
            AskScreen(onEvent = eventRt145)
        }

        ScreenStateRt145.EnterStateRt145 -> {
            EnterScreen(onEvent = eventRt145)
        }

        ScreenStateRt145.QuizStateRt145 -> {
            QuizScreenRt145(
                selectorQuizRt145 = stateRt145.value.selectorQuizRt145,
                quizTaskRt145 = stateRt145.value.tasksRt145[stateRt145.value.countTasks - 1],
                number = stateRt145.value.countTasks,
                size = stateRt145.value.tasksRt145.size,
                onEvent = eventRt145
            )
        }

        ScreenStateRt145.RemoteCategoryStateRt145 -> {

        }

        ScreenStateRt145.ResulQuizStateRt145 -> {
            ResultScreenRt145(
                selectorQuizRt145 = stateRt145.value.selectorQuizRt145,
                size = stateRt145.value.tasksRt145.size,
                countGood = stateRt145.value.countGood,
                onEvent = eventRt145
            )
        }

        ScreenStateRt145.SelectQuizStateRt145 -> {
            SelectQuizScreen(
                selectorQuizRt145 = stateRt145.value.selectorQuizRt145,
                size = stateRt145.value.tasksRt145.size,
                onEvent = eventRt145
            )
        }

        ScreenStateRt145.ScheduleStateRt145 -> {

        }

        ScreenStateRt145.WebStateRt145 -> {

        }
    }
}