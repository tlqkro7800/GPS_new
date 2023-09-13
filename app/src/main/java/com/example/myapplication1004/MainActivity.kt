package com.example.myapplication1004

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    var firestore: FirebaseFirestore? = null

    private val frame: ConstraintLayout by lazy { // activity_main의 화면 부분
        findViewById(R.id.body_container)
    }
    private val bottomNavigationView: BottomNavigationView by lazy { // 하단 네비게이션 바
        findViewById(R.id.bottom_navigation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 하단 네비게이션 바 클릭 이벤트 설정
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_timer -> {
                    replaceFragment(FragmentTimer())
                    true
                }
                R.id.nav_user -> {
                    replaceFragment(FragmentUser())
                    true
                }
                R.id.nav_setting -> {
                    replaceFragment(FragmentSetting())
                    true
                }
                R.id.nav_shop -> {
                    replaceFragment(FragmentShop())
                    true
                }
                else -> false
            }
        }
    }

    // 화면 전환 구현 메소드
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(frame.id, fragment).commit()
    }
}
