package su.petrowich.jad_d4_fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class BackStackFragment : Fragment() {

    private var counter : Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_backstack, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.fragment_text)
        val button = view.findViewById<Button>(R.id.fragment_button)

        counter = arguments?.getInt(COUNT_KEY)!!
        textView.text = counter.toString()

        button.setOnClickListener {
            val fragmentManager = fragmentManager
            if (fragmentManager != null) {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, BackStackFragment.newInstance(counter + 1))
                        .addToBackStack(null)
                        .commit()
            }
        }
    }

    companion object {
        private val COUNT_KEY = "COUNT_KEY"

        fun newInstance(count: Int): BackStackFragment {
            val fragment = BackStackFragment()
            val args = Bundle()
            args.putInt(COUNT_KEY, count)
            fragment.arguments = args
            return fragment
        }
    }

}