package com.example.unidad4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unidad4.models.Character
import com.example.unidad4.network.StartWarsApi
import com.example.unidad4.network.StartWarsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    //private codigo protegido
    private lateinit var list:MutableList<Character>
    //live data, clase que creo google que permite que cada ves que su valor cambie esta notifica a todas las partes del codigo que esten suscritas a esta variable, en este caso el mainactivity va estar suscritas a los cambios de esta bariable
    val characters = MutableLiveData<List<Character>>()
    fun getCharacters() {
        //corrutina que ejecuta todo el tiempo mientras el app esta ejecutandose
//        GlobalScope.launch(Dispatchers.IO){
//            StartWarsApi.service.getCharacters()
//        }
        //ejecuta corutina se ejecuta mientras el activity o view model se muestre en pantalla
        viewModelScope.launch(Dispatchers.IO) {
            list = StartWarsApi.service.getCharacters().toMutableList()
            characters.postValue(list)
        }
    }

    fun delete(position : Int) {
       list.removeAt(position)
       characters.postValue(list)
    }


}