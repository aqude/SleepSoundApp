package com.example.sleepsoundsapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sleepsoundsapp.R
import com.example.sleepsoundsapp.utils.ContentHomeData
import com.example.sleepsoundsapp.utils.TabBarTopData

@Composable
@Preview(showBackground = true)
//navController: NavHostController
fun HomeScreen() {
    val backgroundColor: Color = Color(0xFF141927)
    val topBarBlocks = ArrayList<TabBarTopData>()
    val contentHomeData = ArrayList<ContentHomeData>()

    contentHomeData.add(
        ContentHomeData(
            Color.Cyan,
            "Guitar Camp",
            3,
            "Instrumental"
        )
    )
    contentHomeData.add(
        ContentHomeData(
            Color.White,
            "Guitar Camp",
            1,
            "Ambient"
        )
    )
    contentHomeData.add(
        ContentHomeData(
            Color.Red,
            "Guitar Camp",
            5,
            "Instrumental"
        )
    )

    topBarBlocks.add(
        TabBarTopData(
            R.drawable.all_home,
            "All"
        )
    )
    topBarBlocks.add(
        TabBarTopData(
            R.drawable.ambient_home,
            "Ambient"
        )
    )
    topBarBlocks.add(
        TabBarTopData(
            R.drawable.for_kids_home,
            "For Kids"
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            TabBar(topBarBlocks)
            MainContent(contentHomeData)
        }
    }
}

@Composable
fun TabBar(blocks: ArrayList<TabBarTopData>) {

    val selectedChipIndex by remember {
        mutableStateOf(0)
    }
    Text(
        text = "Discover",
        fontSize = 34.sp,
        color = Color.White,
        modifier = Modifier.padding(top = 36.dp, bottom = 8.dp),
        fontWeight = FontWeight.Bold
    )
    LazyRow {
        items(blocks.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        var selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        if (selectedChipIndex == it) Color(0xFF4870FF)
                        else Color(0xFF21283F)
                    )
                    .padding(15.dp)
//                    .height(38.dp)
            ) {
                Row() {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 4.dp),
                        painter = painterResource(id = blocks[it].Icon),
                        contentDescription = "Icon",
                        tint = Color.White,
                    )
                    Text(
                        text = blocks[it].Text,
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
}

@Composable
fun MainContent(items: ArrayList<ContentHomeData>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()

        ) {
            items(items.size) {
                ContentItem(items = items[it])
            }
        }
    }

}

@Composable
fun ContentItem(items: ContentHomeData) {
    TODO(
        "https://github.com/philipplackner/MeditationUIYouTube/blob/master/app/src/main/java/com/plcoding/meditationuiyoutube/ui/HomeScreen.kt"
    + "додедать как в коде FeatureItem"
    )
}

fun BottomNavBar() {

}


