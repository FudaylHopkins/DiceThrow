package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {

    private val _currentRoll = MutableLiveData<Int>()
    val currentRoll: LiveData<Int> get() = _currentRoll

    var dieSides: Int = 6

    fun setSides(sides:Int){
        dieSides = sides
    }

    fun rollDie(){
        _currentRoll.value = Random.nextInt(1, dieSides+1)
    }

}