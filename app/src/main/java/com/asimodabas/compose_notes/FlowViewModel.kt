package com.asimodabas.compose_notes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

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

}