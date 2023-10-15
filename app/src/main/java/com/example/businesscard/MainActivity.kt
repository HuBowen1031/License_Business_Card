package com.example.businesscard

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val paramContext = this
                    PersonalInfoTextAndAvatar(name = stringResource(R.string.Name), identity = stringResource(R.string.Intro),paramContext)//place composable functions here.

                }
            }
        }
    }
}

@Composable
fun PersonalInfoTextAndAvatar(name: String, identity: String,paramContext : MainActivity,modifier: Modifier = Modifier ) {
    var imgNum by remember { mutableStateOf(1) }
    var beautyBool by remember{ mutableStateOf(false)}
     val NotificationStr = if (beautyBool) (R.string.class_10_beauty_disabled_notification) else (
        R.string.class_10_beauty_enabled_Notification
    )
    val duration = Toast.LENGTH_SHORT
    val toast = Toast.makeText(paramContext, NotificationStr, duration)
    val onBeautyChanged: (Boolean) -> Unit = {
        beautyBool = it
        toast.show()

    }
    val ImgSelector = when(imgNum) {
        1 -> R.drawable.img_1
        2 -> R.drawable.img_2
        3 -> R.drawable.img_3
        4 -> R.drawable.img_4
        5 -> R.drawable.img_5
        6 -> R.drawable.img_6
        else -> R.drawable.img_7
    }
    val BeautyImgSelector = when(imgNum) {
        1 -> R.drawable.se_1
        2 -> R.drawable.se_2
        3 -> R.drawable.se_3
        4 -> R.drawable.se_4
        else -> R.drawable.se_5
    }
    val ImgPresenter = if (beautyBool) BeautyImgSelector else ImgSelector
    //Spacer(modifier = Modifier.padding(100.dp))
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = ImgPresenter
            ),
            contentDescription = "This is License photo number $imgNum",
            //contentScale = ContentScale.None,
            modifier = Modifier
                .requiredSize(width = 200.dp, height = 200.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Button(onClick = {imgNum = if (beautyBool) (1..7).random() else (1..5).random()}
        ) {
            Text(text = stringResource(R.string.buttonDescription))
        }
        Row(    //This row is to add a switch that allows user to choose whether view the modified photo or not
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
          Text(text = stringResource(R.string.class_10_beauty),textAlign = TextAlign.Center)
          Switch(checked = beautyBool, onCheckedChange = onBeautyChanged,

          )
        }
        Text(text = name,
            fontSize = 80.sp,
            //lineHeight = 40.sp,
            modifier = Modifier
                .padding(bottom = 4.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(text = identity,
        fontSize = 30.sp,
        modifier =Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Text(text = stringResource(R.string.wanted),
            color = Color.Red,
            modifier =Modifier.align(alignment = Alignment.CenterHorizontally),
            fontSize = 25.sp
        )
        Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            Icon(Icons.Rounded.Email, contentDescription = null)
            Text(text = stringResource(R.string.mailbox))
        }
        Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            Icon(Icons.Rounded.Call, contentDescription = null)
            Text(text = stringResource(R.string.Tel_Number))
        }

        Text(text = stringResource(R.string.Description_1, name),
        modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            color = Color.Blue
        )
        Text(text = stringResource(R.string.Description_2),
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            color = Color.Yellow
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        //PersonalInfoText(name = "L.L.S", identity = "Criminal")//place composable functions here.
        //PersonalInfoTextAndAvatar(name ="L.L.S" , identity = "Criminal")
    }
}