package MVVM

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_add2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    var todoViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    private var id: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        if (intent != null && intent.hasExtra(EXTRA_TODO_TITLE) && intent.hasExtra(EXTRA_TODO_DESC) && intent.hasExtra(
                EXTRA_TODO_ID
            )
        ) {
            add_edittext_title.setText(intent.getStringExtra(EXTRA_TODO_TITLE))
            add_edittext_descript.setText(intent.getStringExtra(EXTRA_TODO_DESC))
            id = intent.getIntExtra(EXTRA_TODO_ID, -1)
        }

        add_button.setOnClickListener {
            if (add_edittext_title.text.isNotEmpty() && add_edittext_descript.text.isNotEmpty()) {
                val todo = Todo(id, add_edittext_title.text.toString(), add_edittext_descript.text.toString())
                lifecycleScope.launch(Dispatchers.IO) { todoViewModel.insert(todo) }
                finish()
            } else {
                Toast.makeText(this, "Please enter title and desc", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        const val EXTRA_TODO_TITLE = "EXTRA_TODO_TITLE"
        const val EXTRA_TODO_DESC = "EXTRA_TODO_DESC"
        const val EXTRA_TODO_ID = "EXTRA_TODO_ID"
    }
}