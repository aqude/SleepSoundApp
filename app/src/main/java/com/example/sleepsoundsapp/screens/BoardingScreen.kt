package com.example.sleepsoundsapp.screens

import android.graphics.pdf.PdfDocument.Page
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.sleepsoundsapp.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@Composable
fun BoardingScreen(navController: NavHostController) {
    val items = ArrayList<BoardingScreenData>()

    items.add(
        BoardingScreenData(
            R.drawable.relax_sounds___stp_1,
            "Эксклюзивная музыка",
            "У нас есть авторская библиотека звуков, которую вы больше нигде не найдете"
        )
    )
    items.add(
        BoardingScreenData(
            R.drawable.relax_sounds___stp2,
            "Расслабляющие звуки для сна",
            "Наши звуки помогут расслабиться и улучшить ваш сон"
        )
    )
    items.add(
        BoardingScreenData(
            R.drawable.relax_sounds___stp3,
            "Истории для детей",
            "Знаменитые сказки с успокаивающими звуками помогут вашим детям быстрее заснуть"
        )
    )

}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun BoardingScreenPager(
    item: List<BoardingScreenData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {
}


