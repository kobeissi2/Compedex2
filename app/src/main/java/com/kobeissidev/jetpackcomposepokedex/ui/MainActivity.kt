package com.kobeissidev.jetpackcomposepokedex.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.kobeissidev.jetpackcomposepokedex.ui.navigation.MainNavigationScreen
import com.kobeissidev.jetpackcomposepokedex.ui.theme.CustomTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomTheme {
                MainNavigationScreen()
            }
        }
    }
}
