package one.win.casino.rt145.ui.state

sealed class MainEventRt145 {
    class OnSetScreenState(val applicationStRt145: ApplicationStRt145) : MainEventRt145()
    class OnSetTypeQuizState(val selectorQuizRt145: SelectorQuizRt145) : MainEventRt145()
    class OnAnswer(val answer:Int, val rightIndex:Int) : MainEventRt145()
    class OnSetRemoteCategory(val remoteCategoryRt145: RemoteCategoryRt145) : MainEventRt145()
}