package com.example.notesapp_teamcats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp_teamcats.databinding.ActivityMainBinding
import com.example.notesapp_teamcats.db.NoteDatabase
import com.example.notesapp_teamcats.repository.NoteRepository
import com.example.notesapp_teamcats.viewmodel.NoteViewModel
import com.example.notesapp_teamcats.viewmodel.NoteViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setUpViewModel()
    }


    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelProviderFactory(application, noteRepository)

        noteViewModel = ViewModelProvider(this, viewModelProviderFactory).get(NoteViewModel::class.java)
    }
}