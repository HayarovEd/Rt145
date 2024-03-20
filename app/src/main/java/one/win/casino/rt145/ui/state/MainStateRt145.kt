package one.win.casino.rt145.ui.state


import one.win.casino.rt145.domain.model.GameDataRt145
import one.win.casino.rt145.domain.model.QuizTaskRt145
import one.win.casino.rt145.domain.model.quizFootball

data class MainStateRt145 (
    val screenStateRt145: ScreenStateRt145 = ScreenStateRt145.AgeState,
    val selectorQuizRt145: SelectorQuizRt145 = SelectorQuizRt145.FOOTBALL_QUIZ,
    val countGood: Int = 0,
    val countTasks: Int = 1,
    val tasksRt145: List<QuizTaskRt145> = quizFootball.shuffled(),
    val urlRt145: String = "",
    val footballData: List<GameDataRt145> = emptyList(),
    val basketballData: List<GameDataRt145> = emptyList(),
    val hockeyData: List<GameDataRt145> = emptyList(),
)