package com.timme.sports.qui.zisob.tsqz.ui.state

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.timme.sports.qui.zisob.tsqz.domain.model.quizBasketball
import com.timme.sports.qui.zisob.tsqz.domain.model.quizBoxing
import com.timme.sports.qui.zisob.tsqz.domain.model.quizFootball
import com.timme.sports.qui.zisob.tsqz.domain.model.quizHokkey
import com.timme.sports.qui.zisob.tsqz.domain.model.quizVolleyBall
import com.timme.sports.qui.zisob.tsqz.domain.model.quizTennis
import com.timme.sports.qui.zisob.tsqz.domain.repository.RemoteRepositoryRt145
import com.timme.sports.qui.zisob.tsqz.domain.utils.ResourceRt145
import javax.inject.Inject
import com.timme.sports.qui.zisob.tsqz.domain.utils.PILICE_URL_RT145

@HiltViewModel
class MainViewModelRt145 @Inject constructor(
    private val remoteRepositoryRt145: RemoteRepositoryRt145
) : ViewModel() {
    private var _state = MutableStateFlow(MainStateRt145())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val savedUrl = remoteRepositoryRt145.getSharedUrlRt145()
            if (remoteRepositoryRt145.getFirstRt145()) {
                remoteRepositoryRt145.setFirstRt145(false)
            } else {
                _state.value.copy(
                    applicationStRt145 = ApplicationStRt145.EnterRt145,
                    isFirst = false
                )
                    .fusUpdateStateUIRt145()
            }
            async { getFootballData() }.onAwait
            async { getBasketballData() }.onAwait
            async { getHockeyData() }.onAwait
            //Log.d("MainViewModelRt145", "savedUrl -${savedUrl}")
            if (savedUrl.isNullOrBlank()) {
                getUrlRt145()
            } else {
                _state.value.copy(
                    urlRt145 = savedUrl
                )
                    .fusUpdateStateUIRt145()
            }
        }
    }


    private suspend fun getFootballData() {
        when (val result = remoteRepositoryRt145.sdgetFootballData()) {
            is ResourceRt145.Error -> {
               //Log.d("MainViewModelRt145", "error football -${result.message}")
            }

            is ResourceRt145.Success -> {
                //Log.d("MainViewModelRt145", "result football -${result.data}")
                _state.value.copy(
                    footballData = result.data?.reversed()?: emptyList(),
                )
                    .fusUpdateStateUIRt145()
            }
        }
    }

    private suspend fun getBasketballData() {
        when (val result = remoteRepositoryRt145.klmVtBasketballData()) {
            is ResourceRt145.Error -> {
                //Log.d("MainViewModelRt145", "error basketball -${result.message}")
            }

            is ResourceRt145.Success -> {
                //Log.d("MainViewModelRt145", "result basketball -${result.data}")
                _state.value.copy(
                    basketballData = result.data?.reversed()?: emptyList(),
                )
                    .fusUpdateStateUIRt145()
            }
        }
    }

    private suspend fun getHockeyData() {
        when (val result = remoteRepositoryRt145.vftGetIceHockeyData()) {
            is ResourceRt145.Error -> {
                //Log.d("MainViewModelRt145", "error hockey -${result.message}")
            }

            is ResourceRt145.Success -> {
               // Log.d("MainViewModelRt145", "result hockey -${result.data}")
                _state.value.copy(
                    hockeyData = result.data?.reversed() ?: emptyList(),
                )
                    .fusUpdateStateUIRt145()
            }
        }
    }

    private suspend fun getUrlRt145() {
        when (val result = remoteRepositoryRt145.getUrlRt145()) {
            is ResourceRt145.Error -> {
              Log.d("MainViewModelRt145", "url error -${result.message}")
                _state.value.copy(
                    urlRt145 =  PILICE_URL_RT145
                )
                    .fusUpdateStateUIRt145()

            }

            is ResourceRt145.Success -> {
                if (result.data != null) {
                    Log.d("MainViewModelRt145", "url SUCCESS -${result.data}")
                    _state.value.copy(
                        urlRt145 = result.data
                    )
                        .fusUpdateStateUIRt145()
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
                    applicationStRt145 = eventRt145.applicationStRt145
                )
                    .fusUpdateStateUIRt145()
                if (eventRt145.applicationStRt145 == ApplicationStRt145.EnterRt145) {
                    _state.value.copy(
                        countGood = 0,
                        countTasks = 1
                    )
                        .fusUpdateStateUIRt145()
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
                    .fusUpdateStateUIRt145()
            }

            is MainEventRt145.OnSetRemoteCategory -> {
                _state.value.copy(
                    remoteCategoryRt145 = eventRt145.remoteCategoryRt145
                )
                    .fusUpdateStateUIRt145()
            }
        }
    }

    private fun calculateRt145(answerRt145: Int, rightIndex: Int) {
        if (answerRt145 + 1 == rightIndex) {
            _state.value.copy(
                countGood =  _state.value.countGood + 1,
                countTasks = _state.value.countTasks + 1
            )
                .fusUpdateStateUIRt145()
        } else {
            _state.value.copy(
                countTasks = _state.value.countTasks + 1
            )
                .fusUpdateStateUIRt145()
        }
        if (_state.value.countTasks > _state.value.tasksRt145.size) {
            _state.value.copy(
                applicationStRt145 = ApplicationStRt145.ResulQuizRt145
            )
                .fusUpdateStateUIRt145()
        }
    }


    private fun MainStateRt145.fusUpdateStateUIRt145() {
        println("setSharedUrlRt14fyuiuirt145uf544")
        _state.update {
            this
        }
    }
}