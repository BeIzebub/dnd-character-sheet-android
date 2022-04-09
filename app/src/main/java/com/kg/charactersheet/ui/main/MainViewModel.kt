package com.kg.charactersheet.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.kg.charactersheet.model.Character
import com.kg.charactersheet.model.backgrounds.FolkHero
import com.kg.charactersheet.model.classes.Klass
import com.kg.charactersheet.model.races.MountainDwarf

class MainViewModel : ViewModel() {

    private val users: MutableLiveData<List<Character>> by lazy {
        MutableLiveData<List<Character>>().also {
            loadCharacters()
        }
    }

    fun getCharacters(): LiveData<List<Character>> {
        return users
    }

    private fun loadCharacters() {
        // TODO: characters will be loaded from database

        // test character

        val testanor = Character("Testanor", FolkHero(), MountainDwarf(), Klass())

        Log.e("CHARACTER", Gson().toJson(testanor))
    }

}