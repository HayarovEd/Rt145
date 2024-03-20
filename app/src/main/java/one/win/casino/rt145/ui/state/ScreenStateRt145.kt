package one.win.casino.rt145.ui.state

sealed interface ScreenStateRt145 {
    data object AgeState : ScreenStateRt145
    data object EnterState : ScreenStateRt145
    data object AskState : ScreenStateRt145
    data object SelectQuizState : ScreenStateRt145
    data object QuizState : ScreenStateRt145
    data object ResulQuizState : ScreenStateRt145
    data object WebState : ScreenStateRt145
    data object RemoteCategoryState : ScreenStateRt145
    data object SheduleState : ScreenStateRt145
}