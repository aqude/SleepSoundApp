package com.example.sleepsoundsapp.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sleepsoundsapp.R.*
import com.example.sleepsoundsapp.navigation.Screen
import com.example.sleepsoundsapp.utils.BoardingScreenData
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun BoardingScreen(navController: NavHostController) {
    val items = ArrayList<BoardingScreenData>()
    val mainWallpaperColor = Color(0xFF141927)
    val Colors =
        mapOf<String, Color>(
            "colorBottom" to Color.White,
            "colorTitle" to Color.White,
            "buttonColor" to Color(0xFF21283f)
        )

    items.add(
        BoardingScreenData(
            drawable.relax_sounds___stp_1,
            "Exclusive sounds",
            "We have an author's library of sounds that you will not find anywhere else",
            Button = false
        )
    )
    items.add(
        BoardingScreenData(
            drawable.relax_sounds___stp2,
            "Relax sleep sounds",
            "Our sounds will help to relax and improve your sleep health",
            Button = false
        )
    )
    items.add(
        BoardingScreenData(
            drawable.relax_sounds___stp3,
            "Story for kids",
            "Famous fairy tales with soothing sounds will help your children fall asleep faster",
            Button = true
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )
    BoardingScreenPager(
        Colors,
        navController,
        item = items, pagerState,
        modifier = Modifier
            .fillMaxSize()
            .background(color = mainWallpaperColor)
            .padding(horizontal = 24.dp),
    )
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun BoardingScreenPager(
    colors: Map<String, Color>,
    navController: NavHostController,
    item: List<BoardingScreenData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    modifierText: Modifier = Modifier,

    ) {
    Box(modifier = modifier) {
        HorizontalPager(state = pagerState) { page ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 111.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = item[page].Image),
                    contentDescription = item[page].Title,
                    modifier = Modifier.padding(bottom = 50.dp)
                )
                colors["colorTitle"]?.let {
                    Text(
                        fontWeight = FontWeight.Bold,
                        text = item[page].Title,
                        color = it,
                        fontSize = 34.sp,
                        modifier = Modifier.padding(bottom = 8.dp), textAlign = TextAlign.Center
                    )
                }

                colors["colorBottom"]?.let {
                    Text(
                        text = item[page].Text,
                        color = it,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(bottom = 64.dp)
                            .alpha(0.6f),
                        textAlign = TextAlign.Center,
                    )
                }

                PagerIndicator(item.size, pagerState.currentPage)

                if (item[page].Button) {
                    colors["buttonColor"]?.let {
                        Button(
                            onClick = { navController.navigate(Screen.Home.route) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 24.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = it)
                        ) {
                            Text(text = "Next", fontSize = 16.sp, color = Color.White)
                        }
                    }
                }
            }


        }
    }
}

@Composable
fun PagerIndicator(size: Int, currentPage: Int) {
    Row(modifier = Modifier.padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 20.dp else 10.dp)
    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) Color(0xFF4870FF) else Color(0xFF21283F)
            )
    )
}

