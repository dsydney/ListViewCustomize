package com.revature.listviewcustomize.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import com.revature.listviewcustomize.R
import com.revature.listviewcustomize.model.data.Plant
import com.revature.listviewcustomize.ui.theme.ListViewCustomizeTheme
import com.revature.listviewcustomize.ui.theme.Purple500
import com.revature.listviewcustomize.ui.theme.Purple700
import com.revature.listviewcustomize.ui.theme.plants
import org.intellij.lang.annotations.JdkConstants

@Preview(

    uiMode = UI_MODE_NIGHT_YES,
    name="Dark Mode"

)
@Preview(

    uiMode = UI_MODE_NIGHT_NO,
    name="Light Mode"

)
@Composable
fun defaultPreview() {
    //change darkTheme to true to see darkMode, false to see lightMode, (OR put ui mode night yes above)
    ListViewCustomizeTheme(
        //darkTheme = false
    ) {

        AllPlants(plantList = plants)

    }

}

@Composable
fun AllPlants(plantList: List<Plant>) {

    Scaffold(

        topBar = {

            TopAppBar(
                //title is a static string that we added in strings.xml
                backgroundColor = MaterialTheme.colors.primary,
                title = {Text(stringResource(R.string.title))}

            )

        }

    ) {

        LazyColumn(

            Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)

        ) {
            //First item is the title...
            item {

                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 25.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Text(

                        text = "Plants used for Cancer Treatment",
                        style = MaterialTheme.typography.h4,
                        color = Purple500,
                        fontWeight = FontWeight.ExtraBold

                    )

                }

            } // End of item
            //Subsequent items are plantcards displaying each plant in our list
            items(plantList) {
                //for each item in plantList, which we will call plant...
                plant->
                //create a PlantCard...
                PlantCard(
                    //and give it a name, desc, and image from that item in plantList...
                    plant.name,
                    plant.description,
                    plant.imageRes

                )

            }

        }

    }

}