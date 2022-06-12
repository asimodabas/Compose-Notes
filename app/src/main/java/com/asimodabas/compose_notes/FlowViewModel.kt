package com.asimodabas.compose_notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FlowViewModel : ViewModel() {

    val countDownTimerFlow = flow<Int> {

        val countDownFrom = 10
        var counter = countDownFrom

        emit(countDownFrom)
        while (counter > 0) {

            delay(1000)
            counter--
            emit(counter)
        }
    }

    init {
        collectInViewModel()
    }

    private fun collectInViewModel() {
/*
        viewModelScope.launch {
                countDownTimerFlow
                .filter {
                    it % 2 == 0
                }
                .map {
                    it + it
                }
                .collect() {
                    println("counter : $it")
                }
        }
*/
        countDownTimerFlow.onEach {
            println(it)
        }.launchIn(viewModelScope)
    }
}