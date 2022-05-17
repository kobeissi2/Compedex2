package com.kobeissidev.jetpackcomposepokedex.ui.screen.detail.section.tab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.kobeissidev.jetpackcomposepokedex.ui.composable.AutoSizeText
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun InfoTabLayout(
    backgroundColor: Color,
    textColor: Color,
    vararg tabs: Pair<Tabs, @Composable () -> Unit>
) {
    val pagerState = rememberPagerState(initialPage = 0)
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    color = textColor,
                )
            },
            backgroundColor = backgroundColor
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(selected = tabIndex == index, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }, text = {
                    AutoSizeText(
                        text = tab.first.value,
                        style = MaterialTheme.typography.body1.copy(
                            color = textColor
                        )
                    )
                })
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            count = tabs.size
        ) { index ->
            tabs[index].second()
        }
    }
}