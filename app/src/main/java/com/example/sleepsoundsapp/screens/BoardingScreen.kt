package com.example.sleepsoundsapp.screens

import android.graphics.pdf.PdfDocument.Page
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sleepsoundsapp.R
import com.example.sleepsoundsapp.R.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BoardingScreen(navController: NavHostController) {
    val items = ArrayList<BoardingScreenData>()
    val mainWallpaperColor = Color(0xFF141927)

    items.add(
        BoardingScreenData(
            drawable.relax_sounds___stp_1,
            "Эксклюзивная музыка",
            "У нас есть авторская библиотека звуков, которую вы больше нигде не найдете"
        )
    )
    items.add(
        BoardingScreenData(
            drawable.relax_sounds___stp2,
            "Расслабляющие звуки для сна",
            "Наши звуки помогут расслабиться и улучшить ваш сон"
        )
    )
    items.add(
        BoardingScreenData(
            drawable.relax_sounds___stp3,
            "Истории для детей",
            "Знаменитые сказки с успокаивающими звуками помогут вашим детям быстрее заснуть"
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )
    BoardingScreenPager(
        item = items, pagerState, modifier = Modifier
            .fillMaxSize()
            .background(color = mainWallpaperColor)
            .padding(horizontal = 24.dp)
    )
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun BoardingScreenPager(
    item: List<BoardingScreenData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    modifierText: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally)
        {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = item[page].Image),
                        contentDescription = item[page].Title
                    )
                    Text(text = item[page].Title, color = Color.White, fontSize = 34.sp)
                    Text(text = item[page].Text, color = Color.White, fontSize = 16.sp)
                }

            }
            PagerIndicator(item.size, pagerState.currentPage)
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

