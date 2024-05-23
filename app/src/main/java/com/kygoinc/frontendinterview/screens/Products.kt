package com.kygoinc.frontendinterview.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Products (modifier: Modifier = Modifier) {

    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Toolbar()

Sale()

        ItemGrid(items = item)

    }
}

@Preview
@Composable
private fun ProductsPreview() {

    Products()
}