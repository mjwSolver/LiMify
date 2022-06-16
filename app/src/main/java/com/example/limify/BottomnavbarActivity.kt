package com.example.limify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.limify.databinding.ActivityBottomnavbarBinding
import com.example.limify01.Menu1Fragment
import com.example.limify01.Menu3Fragment
import com.example.limify01.Menu4Fragment


class BottomnavbarActivity : AppCompatActivity() {

    private lateinit var viewBind: ActivityBottomnavbarBinding
    private var cicak = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityBottomnavbarBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        SetCurrentFragment(Menu1Fragment())

        viewBind.bottomNavigationViewBottomnavbar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu1_menu -> SetCurrentFragment(Menu1Fragment())
                R.id.menu2_menu -> SetCurrentFragment(Menu2Fragment())
                R.id.menu3_menu -> SetCurrentFragment(Menu3Fragment())
                R.id.menu4_menu -> SetCurrentFragment(Menu4Fragment())
            }
            true
        }
    }

    private fun SetCurrentFragment(fragment: Fragment){
        this.supportFragmentManager.beginTransaction().apply {
            replace(viewBind.framelayoutBottomnavbar.id, fragment)
            commit()
        }
    }
}