package com.kygoinc.frontendinterview.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Products(navController: NavController, modifier: Modifier = Modifier) {

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

            Sale()

            Spacer(modifier = Modifier.height(12.dp))
            SearchField(  onValueChange = {})

            ItemGrid(items = item)
        }

    }
}

@Preview
@Composable
private fun ProductsPreview() {

    Products( navController = rememberNavController())
}