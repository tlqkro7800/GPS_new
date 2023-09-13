package com.example.myapplication1004

import FragmentStudy
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentTimer.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentTimer : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_timer, container, false)

        val buttonChangeActivity = view.findViewById<Button>(R.id.go_to_study)
        // 버튼 클릭 이벤트 처리
        buttonChangeActivity.setOnClickListener {
            // FragmentTransaction을 사용하여 Fragment 변경
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            val fragment = FragmentStudy() // 대상 Fragment인 FragmentStudy를 생성
            fragmentTransaction.replace(R.id.body_container, fragment)
            fragmentTransaction.addToBackStack(null) // 뒤로 가기 스택에 추가
            fragmentTransaction.commit()
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentTimer.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentTimer().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}