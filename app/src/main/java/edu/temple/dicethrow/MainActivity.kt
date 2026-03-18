package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var die1: DieFragment
    private lateinit var die2: DieFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) == null) {
            die1 = DieFragment.newInstance(6)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, die1)
                .commit()
        } else {
            die1 = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as DieFragment
        }

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView1) == null) {
            die2 = DieFragment.newInstance(6)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView1, die2)
                .commit()
        } else {
            die2 = supportFragmentManager.findFragmentById(R.id.fragmentContainerView1) as DieFragment
        }



        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            die1.throwDie()
            die2.throwDie()
        }
    }
}