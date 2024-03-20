package one.win.casino.rt145.ui.state

sealed class MainEventRt145 {
    class OnSetScreenState(val screenStateRt145: ScreenStateRt145) : MainEventRt145()
    class OnSetTypeQuizState(val selectorQuizRt145: SelectorQuizRt145) : MainEventRt145()
    class OnAnswer(val unswer:Int) : MainEventRt145()
}