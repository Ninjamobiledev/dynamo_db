package com.example.dynamofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Student

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_add = findViewById<AppCompatButton>(R.id.btn_add)
        btn_add.setOnClickListener {
            val item: Student = Student.builder()
                .name("Mehul")
                .age(4)
                .build()
            Log.i("Amplify", item.id)
            Amplify.DataStore.save(
                item,
                { success -> Log.i("Amplify", "Saved item: " + success.item().name) },
                { error -> Log.e("Amplify", "Could not save item to DataStore", error) }
            )
        }

    }
}