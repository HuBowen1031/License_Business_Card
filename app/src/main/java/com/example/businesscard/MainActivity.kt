package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    PersonalInfoTextAndAvatar(name = stringResource(R.string.Name), identity = stringResource(R.string.Intro))//place composable functions here.
                }
            }
        }
    }
}
@Composable
fun PersonalInfoTextAndAvatar(name: String, identity: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.licensephoto_sized
            ),
            contentDescription = null,
            //contentScale = ContentScale.None,
            modifier = Modifier
                .requiredSize(width = 200.dp, height = 200.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
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
            Text(text = "15067210704")
        }

        Text(text = "     Hi,I am $name(L.L.S stands for 'License Loser Shit'),I am a Criminal.I am wanted because of theft and robbery.",
        modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            color = Color.Blue
        )
        Text(text = "By the way,my favorite food is Excrement.",
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
    PersonalInfoTextAndAvatar(name = stringResource(R.string.Name), identity = stringResource(R.string.Intro))
    }
}