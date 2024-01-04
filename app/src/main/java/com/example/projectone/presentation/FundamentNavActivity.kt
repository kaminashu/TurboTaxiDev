package com.example.projectone.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.projectone.R
import com.example.projectone.data.network.api.ApiCilent
import com.example.projectone.data.network.dto.ApiDto
import com.example.projectone.data.network.model.AuthUser
import com.example.projectone.data.network.model.UserPost
import com.example.projectone.databinding.ActivityFundamentBinding
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.create


class FundamentNavActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityFundamentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFundamentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        val network = ApiCilent.getRetrofit().create(ApiDto::class.java)
        lifecycleScope.launch {
            val userPost=UserPost(AuthUser("bek_vil","uz","bek_vil"))
            val mess = network.getLoginZapros(userPost).mess
            Log.d("TAG", "onCreate: $mess")
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_viloyatlar,
                R.id.nav_foydalanuvchilar,
                R.id.nav_malumotlar,
                R.id.nav_restr,
                R.id.nav_hisobot,
                R.id.nav_roole,
                R.id.nav_order
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    companion object {
        fun newIntnet(context: Context): Intent {
            return Intent(context, FundamentNavActivity::class.java)
        }
    }
}