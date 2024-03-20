package one.win.casino.rt145.ui.state

sealed interface ScreenStateRt145 {
    data object AgeStateRt145 : ScreenStateRt145
    data object EnterStateRt145 : ScreenStateRt145
    data object AskStateRt145 : ScreenStateRt145
    data object SelectQuizStateRt145 : ScreenStateRt145
    data object QuizStateRt145 : ScreenStateRt145
    data object ResulQuizStateRt145 : ScreenStateRt145
    data object WebStateRt145 : ScreenStateRt145
    data object RemoteCategoryStateRt145 : ScreenStateRt145
    data object ScheduleStateRt145 : ScreenStateRt145
}