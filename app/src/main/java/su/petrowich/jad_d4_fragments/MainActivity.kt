package su.petrowich.jad_d4_fragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragmentTransition = supportFragmentManager.beginTransaction()
            fragmentTransition.replace(R.id.fragment_container, BackStackFragment.newInstance(0))
            fragmentTransition.commit()
        }
    }
}
