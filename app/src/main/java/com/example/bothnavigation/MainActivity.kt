package com.example.bothnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.bothnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //bottom navigation
        navController=findNavController(R.id.hostFragment)
        binding.bottomNavigation.setupWithNavController(navController)

        //up button
        appBarConfiguration= AppBarConfiguration(navController.graph,binding.drawerLayout)
        NavigationUI.setupActionBarWithNavController(this,navController,binding.drawerLayout)

        //drawer layout
        NavigationUI.setupWithNavController(binding.navigationView,navController)

        ////NavigationView && BottomNavigationView

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,appBarConfiguration)
    }
}