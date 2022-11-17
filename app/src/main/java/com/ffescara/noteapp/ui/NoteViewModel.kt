package com.ffescara.noteapp.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ffescara.noteapp.model.Notes
import com.ffescara.noteapp.network.Api
import kotlinx.coroutines.launch

class NoteViewModel : ViewModel() {

    var noteUiState: List<Notes> by mutableStateOf(listOf())

    init {
        //println("test")
        getListNotes()
    }

    private fun getListNotes() {
        viewModelScope.launch {
            val response = Api.ApiService.GetNotes()
            val listData = response.notes

            listData.forEach { notes: Notes ->
                println("test")
                Log.d("response", "note ${notes.note}")
            }

            noteUiState = response.notes
        }
    }
}