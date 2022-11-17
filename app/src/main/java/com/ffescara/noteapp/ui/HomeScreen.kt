package com.ffescara.noteapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ffescara.noteapp.model.Notes

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NoteApp(listNote: List<Notes>) {

    Scaffold(topBar = {
        TopAppBar() {
            Icon(Icons.Rounded.Menu, contentDescription = "Icon")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "My Notes")
        }
    }) {
        LazyColumn {
            items(listNote) { note ->
                NoteCard(notes = note)
            }
        }
    }
}

@Composable
fun NoteCard(notes: Notes) {
    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = notes.note,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NoteCardPreview() {
    NoteCard(
        notes = Notes(
            id = 1,
            note = "Satu"
        )
    )
}