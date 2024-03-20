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
            val savedUrl = remoteRepositoryRt145.getSharedUrl()
            async { getFootballData() }.onAwait
            async { getBasketballData() }.onAwait
            async { getHockeyData() }.onAwait
            if (savedUrl.isNullOrBlank()) {
                getUrl()
            } else {
                _state.value.copy(
                    url = savedUrl
                )
                    .updateStateUI()
            }
        }
    }


    private suspend fun getFootballData() {
        when (val result = remoteRepositoryRt145.getFootballData()) {
            is ResourceRt145.Error -> {
                Log.d("MainViewModelRt145", "error football -${result.message}")
            }

            is ResourceRt145.Success -> {
                Log.d("MainViewModelRt145", "result football -${result.data}")
                _state.value.copy(
                    footballData = result.data ?: emptyList(),
                )
                    .updateStateUI()
            }
        }
    }

    private suspend fun getBasketballData() {
        when (val result = remoteRepositoryRt145.getBasketballData()) {
            is ResourceRt145.Error -> {
                Log.d("MainViewModelRt145", "error basketball -${result.message}")
            }

            is ResourceRt145.Success -> {
                Log.d("MainViewModelRt145", "result basketball -${result.data}")
                _state.value.copy(
                    basketballData = result.data ?: emptyList(),
                )
                    .updateStateUI()
            }
        }
    }

    private suspend fun getHockeyData() {
        when (val result = remoteRepositoryRt145.getIceHockeyData()) {
            is ResourceRt145.Error -> {
                Log.d("MainViewModelRt145", "error hockey -${result.message}")
            }

            is ResourceRt145.Success -> {
                Log.d("MainViewModelRt145", "result hockey -${result.data}")
                _state.value.copy(
                    hockeyData = result.data ?: emptyList(),
                )
                    .updateStateUI()
            }
        }
    }

    private suspend fun getUrl() {
        when (val result = remoteRepositoryRt145.getUrl()) {
            is ResourceRt145.Error -> {

            }

            is ResourceRt145.Success -> {
                if (result.data != null) {
                    _state.value.copy(
                        url = result.data
                    )
                        .updateStateUI()
                    remoteRepositoryRt145.setSharedUrl(result.data)
                }
            }
        }
    }

    fun onEvent(event: MainEventRt145) {
        when (event) {
            is MainEventRt145.OnAnswer -> TODO()
            is MainEventRt145.OnSetScreenState -> {
                _state.value.copy(
                    screenStateRt145 = event.screenStateRt145
                )
                    .updateStateUI()
                if (event.screenStateRt145 == ScreenStateRt145.EnterState) {
                    _state.value.copy(
                        countGood = 0
                    )
                        .updateStateUI()
                }
            }
            is MainEventRt145.OnSetTypeQuizState -> {
                val currentTasks = when(event.selectorQuizRt145) {
                    SelectorQuizRt145.FOOTBALL_QUIZ -> quizFootball.shuffled()
                    SelectorQuizRt145.BASKETBALL_QUIZ -> quizBasketball.shuffled()
                    SelectorQuizRt145.HOCKEY_QUIZ -> quizHokkey.shuffled()
                    SelectorQuizRt145.VOLLEYBALL_QUIZ -> quizVolleyBall.shuffled()
                    SelectorQuizRt145.TENNIS_QUIZ -> quizTennis.shuffled()
                    SelectorQuizRt145.BOXING_QUIZ -> quizBoxing.shuffled()
                }
                _state.value.copy(
                    selectorQuizRt145 = event.selectorQuizRt145,
                    tasks = currentTasks,
                )
                    .updateStateUI()
            }
        }
    }



    private fun MainStateRt145.updateStateUI() {
        _state.update {
            this
        }
    }
}