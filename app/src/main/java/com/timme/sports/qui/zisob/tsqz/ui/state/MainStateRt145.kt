package com.timme.sports.qui.zisob.tsqz.ui.state


import com.timme.sports.qui.zisob.tsqz.domain.model.GameDataRt145
import com.timme.sports.qui.zisob.tsqz.domain.model.QuizTaskRt145
import com.timme.sports.qui.zisob.tsqz.domain.model.quizFootball

data class MainStateRt145 (
    val applicationStRt145: ApplicationStRt145 = ApplicationStRt145.AgeRt145,
    val selectorQuizRt145: SelectorQuizRt145 = SelectorQuizRt145.FOOTBALL_QUIZ,
    val countGood: Int = 0,
    val countTasks: Int = 1,
    val tasksRt145: List<QuizTaskRt145> = quizFootball.shuffled(),
    val urlRt145: String = "",
    val isFirst: Boolean = true,
    val footballData: List<GameDataRt145> = emptyList(),
    val basketballData: List<GameDataRt145> = emptyList(),
    val hockeyData: List<GameDataRt145> = emptyList(),
    val remoteCategoryRt145: RemoteCategoryRt145 = RemoteCategoryRt145.FOOTBALL,
)