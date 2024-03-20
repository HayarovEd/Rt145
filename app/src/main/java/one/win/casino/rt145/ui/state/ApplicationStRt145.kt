package one.win.casino.rt145.ui.state

sealed interface ApplicationStRt145 {
    data object AgeStateRt145 : ApplicationStRt145
    data object EnterStateRt145 : ApplicationStRt145
    data object AskStateRt145 : ApplicationStRt145
    data object SelectQuizStateRt145 : ApplicationStRt145
    data object QuizStateRt145 : ApplicationStRt145
    data object ResulQuizStateRt145 : ApplicationStRt145
    data object WebStateRt145 : ApplicationStRt145
    data object RemoteCategoryStateRt145 : ApplicationStRt145
    data object ScheduleStateRt145 : ApplicationStRt145
}