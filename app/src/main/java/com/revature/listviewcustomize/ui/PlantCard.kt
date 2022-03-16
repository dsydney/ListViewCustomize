package com.revature.listviewcustomize.ui

import android.content.Context
import android.graphics.drawable.shapes.Shape
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable
fun PlantCard(name: String, description: String, image: Int) {

    var context = LocalContext.current

    Card(

        modifier = Modifier
            .padding(10.dp)
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable { cardViewCallBack(context, name+description) },
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = Gray

    ) {

        Row (

            verticalAlignment = Alignment.CenterVertically

                ){

            Image(

                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.size(130.dp).padding(8.dp),
                contentScale = ContentScale.Fit

            )

            Column(

                Modifier.padding(8.dp)

            ) {

                Text(

                    text = name,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)

                )

                Text(

                    text = description,
                    style = MaterialTheme.typography.body1,
                    fontStyle = FontStyle.Italic,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 4.dp)

                )

            }

        }

    }

}

fun cardViewCallBack(context: Context, s: String) {

    //When you click on a card, the following message is displayed
    //parameter s brings in the name and description of the list item in that card
    Toast.makeText(context, "Hello ${s}", Toast.LENGTH_LONG).show()

}
