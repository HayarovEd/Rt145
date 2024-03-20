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
    val eventRt145 = viewModel::onEvent

    when (stateRt145.value.screenStateRt145) {
        ScreenStateRt145.AgeState -> {
            AgeScreen(onEvent = eventRt145)
        }

        ScreenStateRt145.AskState -> {
            AskScreen(onEvent = eventRt145)
        }

        ScreenStateRt145.EnterState -> {
            EnterScreen(onEvent = eventRt145)
        }

        ScreenStateRt145.QuizState -> {
            QuizScreenRt145(
                selectorQuizRt145 = stateRt145.value.selectorQuizRt145,
                quizTaskRt145 = stateRt145.value.tasksRt145[stateRt145.value.countTasks - 1],
                number = stateRt145.value.countTasks,
                size = stateRt145.value.tasksRt145.size,
                onEvent = eventRt145
            )
        }

        ScreenStateRt145.RemoteCategoryState -> {

        }

        ScreenStateRt145.ResulQuizState -> {
            ResultScreenRt145(
                selectorQuizRt145 = stateRt145.value.selectorQuizRt145,
                size = stateRt145.value.tasksRt145.size,
                countGood = stateRt145.value.countGood,
                onEvent = eventRt145
            )
        }

        ScreenStateRt145.SelectQuizState -> {
            SelectQuizScreen(
                selectorQuizRt145 = stateRt145.value.selectorQuizRt145,
                size = stateRt145.value.tasksRt145.size,
                onEvent = eventRt145
            )
        }

        ScreenStateRt145.SheduleState -> {

        }

        ScreenStateRt145.WebState -> {

        }
    }
}