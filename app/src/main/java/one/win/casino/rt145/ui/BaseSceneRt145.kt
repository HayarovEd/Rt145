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
    val state = viewModel.state.collectAsState()
    val event = viewModel::onEvent

    when (state.value.screenStateRt145) {
        ScreenStateRt145.AgeState -> {
            AgeScreen(onEvent = event)
        }

        ScreenStateRt145.AskState -> {
            AskScreen(onEvent = event)
        }

        ScreenStateRt145.EnterState -> {
            EnterScreen(onEvent = event)
        }

        ScreenStateRt145.QuizState -> {
            QuizScreenRt145(
                selectorQuizRt145 = state.value.selectorQuizRt145,
                quizTaskRt145 = state.value.tasks[state.value.countTasks - 1],
                number = state.value.countTasks,
                size = state.value.tasks.size,
                onEvent = event
            )
        }

        ScreenStateRt145.RemoteCategoryState -> {

        }

        ScreenStateRt145.ResulQuizState -> {
            ResultScreenRt145(
                selectorQuizRt145 = state.value.selectorQuizRt145,
                size = state.value.tasks.size,
                countGood = state.value.countGood,
                onEvent = event
            )
        }

        ScreenStateRt145.SelectQuizState -> {
            SelectQuizScreen(
                selectorQuizRt145 = state.value.selectorQuizRt145,
                size = state.value.tasks.size,
                onEvent = event
            )
        }

        ScreenStateRt145.SheduleState -> {

        }

        ScreenStateRt145.WebState -> {

        }
    }
}