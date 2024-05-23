package com.kygoinc.frontendinterview.screens

import android.graphics.fonts.Font
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kygoinc.frontendinterview.R

@Composable
fun ProductDetails(navController: NavController, modifier: Modifier = Modifier) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){

        DetailsToolbar( onBack = { navController.popBackStack() },  onCancel =  { navController.popBackStack() } )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
          horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.login),
                contentDescription = "items",
                modifier = modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 16.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                Text(
                    text = "Product Name",
                    style = androidx.compose.ui.text.TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                Text(
                    text = "600 KES",
                    style = androidx.compose.ui.text.TextStyle(
                        color = Color(0xFF013014),
                        fontSize = 20.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                Text(
                    text = "Apparel",
                    style = androidx.compose.ui.text.TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Normal
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
            ) {
                Text(
                    text = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight …see more",
                    style = androidx.compose.ui.text.TextStyle(
                        color = Color.Black,
                        fontSize = 17.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            LightGreenBtn(texValue = "Add to Cart", onClick = {
                navController.navigate("products")

            })

            Spacer(modifier = Modifier.height(16.dp))

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp)
            ){
                ItemGrid(items = item)
            }



        }

    }
}


@Preview
@Composable
private fun ProductDetailsPrev() {
    ProductDetails(rememberNavController())
}