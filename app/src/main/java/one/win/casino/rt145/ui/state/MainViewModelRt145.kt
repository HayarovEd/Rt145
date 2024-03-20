package one.win.casino.rt145.ui.state

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import one.win.casino.rt145.domain.model.quizBasketball
import one.win.casino.rt145.domain.model.quizBoxing
import one.win.casino.rt145.domain.model.quizFootball
import one.win.casino.rt145.domain.model.quizHokkey
import one.win.casino.rt145.domain.model.quizVolleyBall
import one.win.casino.rt145.domain.model.quizTennis
import one.win.casino.rt145.domain.repository.RemoteRepositoryRt145
import one.win.casino.rt145.domain.utils.ResourceRt145
import javax.inject.Inject

@HiltViewModel
class MainViewModelRt145 @Inject constructor(
    private val remoteRepositoryRt145: RemoteRepositoryRt145
) : ViewModel() {
    private var _state = MutableStateFlow(MainStateRt145())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val savedUrl = remoteRepositoryRt145.getSharedUrlRt145()
            async { getFootballData() }.onAwait
            async { getBasketballData() }.onAwait
            async { getHockeyData() }.onAwait
            Log.d("MainViewModelRt145", "savedUrl -${savedUrl}")
            if (savedUrl.isNullOrBlank()) {
                getUrlRt145()
            } else {
                _state.value.copy(
                    urlRt145 = savedUrl
                )
                    .updateStateUIRt145()
            }
        }
    }


    private suspend fun getFootballData() {
        when (val result = remoteRepositoryRt145.getFootballData()) {
            is ResourceRt145.Error -> {
               // Log.d("MainViewModelRt145", "error football -${result.message}")
            }

            is ResourceRt145.Success -> {
                //Log.d("MainViewModelRt145", "result football -${result.data}")
                _state.value.copy(
                    footballData = result.data ?: emptyList(),
                )
                    .updateStateUIRt145()
            }
        }
    }

    private suspend fun getBasketballData() {
        when (val result = remoteRepositoryRt145.getBasketballData()) {
            is ResourceRt145.Error -> {
                //Log.d("MainViewModelRt145", "error basketball -${result.message}")
            }

            is ResourceRt145.Success -> {
                //Log.d("MainViewModelRt145", "result basketball -${result.data}")
                _state.value.copy(
                    basketballData = result.data ?: emptyList(),
                )
                    .updateStateUIRt145()
            }
        }
    }

    private suspend fun getHockeyData() {
        when (val result = remoteRepositoryRt145.getIceHockeyData()) {
            is ResourceRt145.Error -> {
                //Log.d("MainViewModelRt145", "error hockey -${result.message}")
            }

            is ResourceRt145.Success -> {
                //Log.d("MainViewModelRt145", "result hockey -${result.data}")
                _state.value.copy(
                    hockeyData = result.data ?: emptyList(),
                )
                    .updateStateUIRt145()
            }
        }
    }

    private suspend fun getUrlRt145() {
        when (val result = remoteRepositoryRt145.getUrlRt145()) {
            is ResourceRt145.Error -> {
                Log.d("MainViewModelRt145", "url error -${result.message}")
            }

            is ResourceRt145.Success -> {
                if (result.data != null) {
                    Log.d("MainViewModelRt145", "url SUCCESS -${result.data}")
                    _state.value.copy(
                        urlRt145 = result.data
                    )
                        .updateStateUIRt145()
                    remoteRepositoryRt145.setSharedUrlRt145(result.data)
                }
            }
        }
    }

    fun onEventRt145(eventRt145: MainEventRt145) {
        when (eventRt145) {
            is MainEventRt145.OnAnswer -> {
                calculateRt145(
                    answerRt145 = eventRt145.answer,
                    rightIndex = eventRt145.rightIndex
                )
            }

            is MainEventRt145.OnSetScreenState -> {
                _state.value.copy(
                    screenStateRt145 = eventRt145.screenStateRt145
                )
                    .updateStateUIRt145()
                if (eventRt145.screenStateRt145 == ScreenStateRt145.EnterStateRt145) {
                    _state.value.copy(
                        countGood = 0,
                        countTasks = 1
                    )
                        .updateStateUIRt145()
                }
            }

            is MainEventRt145.OnSetTypeQuizState -> {
                val currentTasks = when (eventRt145.selectorQuizRt145) {
                    SelectorQuizRt145.FOOTBALL_QUIZ -> quizFootball.shuffled()
                    SelectorQuizRt145.BASKETBALL_QUIZ -> quizBasketball.shuffled()
                    SelectorQuizRt145.HOCKEY_QUIZ -> quizHokkey.shuffled()
                    SelectorQuizRt145.VOLLEYBALL_QUIZ -> quizVolleyBall.shuffled()
                    SelectorQuizRt145.TENNIS_QUIZ -> quizTennis.shuffled()
                    SelectorQuizRt145.BOXING_QUIZ -> quizBoxing.shuffled()
                }
                _state.value.copy(
                    selectorQuizRt145 = eventRt145.selectorQuizRt145,
                    tasksRt145 = currentTasks,
                )
                    .updateStateUIRt145()
            }

            is MainEventRt145.OnSetRemoteCategory -> {
                _state.value.copy(
                    remoteCategoryRt145 = eventRt145.remoteCategoryRt145
                )
                    .updateStateUIRt145()
            }
        }
    }

    private fun calculateRt145(answerRt145: Int, rightIndex: Int) {
        if (answerRt145 + 1 == rightIndex) {
            _state.value.copy(
                countGood =  _state.value.countGood + 1,
                countTasks = _state.value.countTasks + 1
            )
                .updateStateUIRt145()
        } else {
            _state.value.copy(
                countTasks = _state.value.countTasks + 1
            )
                .updateStateUIRt145()
        }
        if (_state.value.countTasks > _state.value.tasksRt145.size) {
            _state.value.copy(
                screenStateRt145 = ScreenStateRt145.ResulQuizStateRt145
            )
                .updateStateUIRt145()
        }
    }


    private fun MainStateRt145.updateStateUIRt145() {
        _state.update {
            this
        }
    }
}