package com.example.navigationanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationanimation.ui.theme.NavigationAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "first",
                        builder =  {
                            composable("first") {
                                FirstScreen(
                                    onClick = { navController.navigate("second") }
                                )
                            }
                            composable(
                                route = "second",
                                enterTransition = { slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth / 2 }, animationSpec = tween()) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth / 2 }, animationSpec = tween()) },
                                popEnterTransition = { slideInVertically(initialOffsetY = { fullHeight -> fullHeight / 2 }, animationSpec = tween()) },
                                popExitTransition = { slideOutVertically(targetOffsetY = { fullHeight -> fullHeight / 2 }, animationSpec = tween()) },
                            ) {
                                SecondScreen(
                                    onClick = { navController.navigateUp() }
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}