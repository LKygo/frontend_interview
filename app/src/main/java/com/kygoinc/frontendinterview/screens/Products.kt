package com.kygoinc.frontendinterview.screens

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kygoinc.frontendinterview.screens.viewmodel.ProductsViewModel

@Composable
fun Products(navController: NavController, productsModel: ProductsViewModel = hiltViewModel()) {

    val apiItems = productsModel.state.value.products
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        productsModel.getProducts(
            onSuccess = {
                Log.d("Products", apiItems.toString())
                Toast.makeText(context, "Successfully fetched and logged products", Toast.LENGTH_SHORT).show()

            },
            onFailure = {
                Toast.makeText(context, "Failed to fetch products", Toast.LENGTH_SHORT).show()

                Log.d("Products", "Failure")
            }
        )

    }


    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
//                .verticalScroll(rememberScrollState())
        ) {
            Toolbar( onLogout = { navController.navigate("login") })
           Divider( modifier = Modifier.height(1.dp).fillMaxWidth(), color = Color.Gray)

            Sale()

            Spacer(modifier = Modifier.height(12.dp))
            SearchField(  onValueChange = {})

            ItemGrid(items = item){index ->
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    "index", index
                )
                navController.navigate("productDetails"){
                    launchSingleTop = true
                }
                Log.d("index value navigation", index.toString())
            }
        }

    }
}

@Preview
@Composable
private fun ProductsPreview() {

    Products( navController = rememberNavController())
}