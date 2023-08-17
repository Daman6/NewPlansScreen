package com.example.newplansscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
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

data class PlanModel(
    val title: String,
    val type: String,
)

val annualList = listOf<PlanModel>(
    PlanModel(
        "Access ~225 live Capitals, Wizards, Washington Mystics, and Go-Go Games every year",
        "icon"
    ),
    PlanModel("Watch on 3 supported devices at a time", "icon"),
    PlanModel("Discount on tickets for select Game of the Month", "icon"),
    PlanModel(
        "Access ~225 live Capitals, Wizards, Washington Mystics, and Go-Go Games every year",
        "text"
    ),
    PlanModel("Watch on 3 supported devices at a time", "icon"),
    PlanModel("Discount on tickets for select Game of the Month", "text"),
    )

val monthlyList = listOf<PlanModel>(
    PlanModel("Watch on 3 supported devices at a time", "icon"),
    PlanModel("Discount on tickets for select Game of the Month", "icon"),
    PlanModel("Watch on 3 supported devices at a time", "icon"),
    PlanModel("Discount on tickets for select Game of the Month", "text"),
)

val weeklyList = listOf<PlanModel>(
    PlanModel("Watch on 3 supported devices at a time", "icon"),
    PlanModel("Discount on tickets for select Game of the Month", "text"),
)

@Composable
fun PlansDetails() {
    Column(modifier = Modifier.background(Color.DarkGray)) {
        Spacer(modifier = Modifier.height(10.dp))
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
fun PriceUi(title: String, subtitle: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0032AE))
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 22.sp,
//                fontFamily = FontFamily(Font(R.font.acumin pro)),
                fontWeight = FontWeight(600),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        )
        Text(
            text = subtitle,
            style = TextStyle(
                fontSize = 16.sp,
//                fontFamily = FontFamily(Font(R.font.acumin pro)),
                fontWeight = FontWeight(400),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        )
    }
}

@Composable
fun ItemListUi(backgroundColor: Color, title: String, type: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(backgroundColor)
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
//                fontFamily = FontFamily(Font(R.font.acumin pro)),
                fontWeight = FontWeight(600),
                color = Color.Black,
            ),
            modifier = Modifier.weight(0.8f)
        )
        Spacer(modifier = Modifier.width(40.dp))
        if (type == "text") {
            Text(
                text = "3",
                style = TextStyle(
                    fontSize = 14.sp,
//                fontFamily = FontFamily(Font(R.font.acumin pro)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF007F06),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.weight(0.2f)
            )
        } else {
            Icon(
                painter = painterResource(id = com.example.newplansscreen.R.drawable.baseline_check_24),
                contentDescription = "TickIcon",
                tint = Color(0xFF007F06),
                modifier = Modifier
                    .size(24.dp)
                    .weight(0.2f)
            )
        }
    }
}

@Composable
fun TabRowExample() {
    val tabs = listOf("Annual Plan", "Monthly Plan", "Weekly Plan")
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabContents = listOf(annualList, monthlyList, weeklyList)

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
                    .height(48.dp)
                    .padding(horizontal = 8.dp)
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
                            color = if (selectedTabIndex == index) Color(0xFF0032AE) else Color(
                                0xFFFFFFFF
                            ),
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier.wrapContentSize()
                    )
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(12.dp))
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            PriceUi(title = "$199.99/ year", subtitle = "Save 20% compared to monthly plan")
        }
        itemsIndexed(tabContents[selectedTabIndex]) { index, it ->
            val color = if (index % 2 == 0) Color.White else Color.LightGray
            ItemListUi(backgroundColor = color, title = it.title, type = it.type)
        }
    }
}