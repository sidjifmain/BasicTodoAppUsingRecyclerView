package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var todoList = mutableListOf(
            Todo("Learn a new language", false),
            Todo("Take a weekend trip", false),
            Todo("Read a classic novel", false),
            Todo("Start a new hobby", false),
            Todo("Volunteer for a cause", false),
            Todo("Organize your closet", false),
            Todo("Plan a picnic", false),
            Todo("Watch a documentary", false),
            Todo("Take a photography class", false),
            Todo("Visit a historical site", false)

        )

        val adapter = TodoAdapter(todoList)
        binding.rview.adapter = adapter
        binding.rview.layoutManager = LinearLayoutManager(this)


        binding.addButoon.setOnClickListener{
            if (binding.editText.text.isNotEmpty()){
                val title = binding.editText.text.toString()


                if ( isDuplicateTitle(todoList , title)){
                    Toast.makeText(this , "This task is alredy added" , Toast.LENGTH_LONG).show()
                }else{
                    val todo = Todo(title , false)
                    todoList.add(todo)
                    adapter.notifyItemInserted(todoList.size-1)
                }

            }
            else{
                Toast.makeText(this , "The place is Empty" , Toast.LENGTH_LONG).show()
            }
        }



    }

    fun isDuplicateTitle(todoList: MutableList<Todo>, titleToCheck: String): Boolean {
        for (todo in todoList) {
            if (todo.title == titleToCheck) {
                return true
            }
        }
        return false
    }
}


