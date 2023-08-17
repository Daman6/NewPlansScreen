package com.example.newplansscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newplansscreen.ui.theme.NewPlansScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewPlansScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PlansDetails()
                }
            }
        }
    }
}

@Composable
fun PlansDetails() {
    Column(modifier = Modifier.background(Color.Gray)) {

        Text(
            text = "Select an option below to see details.",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 19.6.sp,
//                fontFamily = FontFamily(Font(R.font.acumin pro)),
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        TabRowExample()

    }
}

@Composable
fun PlanHeaderBtns() {
    LazyRow(){
        items(2){
            HeaderUi()
        }
    }
}

@Composable
fun HeaderUi() {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(Color.Black)
            .clip(RoundedCornerShape(4.dp))
            .padding(horizontal = 40.dp, vertical = 10.dp)

        ,
    ){
        Text(
            text = "Annual Plan",
            style = TextStyle(
                fontSize = 18.sp,
//                fontFamily = FontFamily(Font(R.font.acumin pro)),
                fontWeight = FontWeight(700),
                color = Color(0xFF0032AE),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.wrapContentSize()
        )
    }
}
@Composable
fun TabRowExample() {
    val tabs = listOf("Annual Plan", "Monthly Plan", "Monthly Plan","Monthly Plan")
    var selectedTabIndex by remember { mutableStateOf(0) }

        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            edgePadding = 0.dp,
            containerColor = Color.Transparent,
            indicator = {},
            divider = {},
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    modifier = Modifier
                        .height(48.dp).padding(horizontal = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .background(
                                if (selectedTabIndex == index) Color.White else Color(
                                    0xFF0032AE
                                ),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 40.dp, vertical = 10.dp)
                    ) {
                        Text(
                            text = title,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight(700),
                                color = if (selectedTabIndex == index) Color(0xFF0032AE) else Color(0xFFFFFFFF),
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier.wrapContentSize()
                        )
                    }
                }
            }
        }
    }



@Preview(showSystemUi = true)
@Composable
fun jnfjnf() {
    TabRowExample()
}