package com.kygoinc.frontendinterview.screens

import android.util.Log
import android.widget.Toolbar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.kygoinc.frontendinterview.R
import java.lang.Error

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppInputWithIcon(
    error: String,
    username: (String) -> Unit,
    password: (String) -> Unit,
    navController: NavController,
    viewModelFactory: ViewModelProvider.Factory
) {
    val colors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent,
        focusedIndicatorColor = Color.White,
        unfocusedIndicatorColor = Color.White,
        focusedPlaceholderColor = Color.White,
        unfocusedPlaceholderColor = Color.White,
        errorLabelColor = Color.Red,
        errorLeadingIconColor = Color.Red,
        errorTextColor = Color.Red,
        errorTrailingIconColor = Color.Red,
        focusedTrailingIconColor = Color.White,
        errorContainerColor = Color.Transparent,
        errorIndicatorColor = Color.Red,
        errorPlaceholderColor = Color.Red,
        focusedTextColor = Color.White
    )

    var textFieldValue by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordIsVisible by remember { mutableStateOf(false) }

    Column {


        TextField(
            colors = colors,
            value = textFieldValue,
            textStyle = TextStyle(
                fontSize = 17.sp,
                textAlign = TextAlign.Left,

                ),
            label = {
                if (textFieldValue.isEmpty()) {
                    Text(
                        text = "Username", style = TextStyle(
                            color = Color.White,
                            fontSize = 15.sp,

                            ),
                        modifier = Modifier
                            .padding(start = 0.dp)
                            .offset(y = (-10).dp)
                    )
                } else {
                    Text(
                        text = error, style = TextStyle(
                            color = Color.Red,
                            fontSize = 15.sp,

                            ),
                        modifier = Modifier
                            .padding(start = 0.dp)
                            .offset(y = (-10).dp)
                    )
                }
            },
            onValueChange = {
                textFieldValue = it
                username = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(top = 10.dp, bottom = 10.dp)
                .onFocusChanged { focusState ->
                    Log.w("Test", "$focusState")
                },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),

            shape = RectangleShape,
//            placeholder = { Text("Password", style=textStyle(12, Color.White)) },
            maxLines = 1,
            singleLine = true
        )
        Text(
            text = "Forgot Username",
            modifier = Modifier
                .wrapContentSize(),
            style = TextStyle(
                color = Color(0xFF68AB00),
                fontSize = 15.sp,
                textAlign = TextAlign.Right,

                )
        )

        TextField(
            colors = colors,
            value = password,
            textStyle = TextStyle(
                fontSize = 22.sp,
                textAlign = TextAlign.Left,
                letterSpacing = 10.sp
            ),
            isError = error.isNotEmpty(),
            label = {
                if (textFieldValue.isEmpty())
                    Text(
                        text = error, style = TextStyle(
                            color = Color.Red,
                            fontSize = 15.sp,

                            ),
                        modifier = Modifier
                            .padding(start = 0.dp)
                            .offset(y = (-10).dp)
                    )
            },
            onValueChange = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(top = 10.dp, bottom = 10.dp)
                .onFocusChanged { focusState ->
                    Log.w("Test", "$focusState")
                },
            keyboardOptions =
            KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            trailingIcon = {
                val icon = if (passwordIsVisible) {
                    R.drawable.show_icon
                } else {
                    R.drawable.show_icon
                }
                IconButton(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    onClick = {
                        passwordIsVisible = !passwordIsVisible
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = icon),
                        contentDescription = "null",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },

            shape = RectangleShape,
//            placeholder = { Text("Password", style=textStyle(12, Color.White)) },
            maxLines = 1,
            singleLine = true,
            visualTransformation = if (passwordIsVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
        )
        Text(
            text = "Forgot Password",
            modifier = Modifier
                .wrapContentSize(),
            style = TextStyle(
                color = Color(0xFF68AB00),
                fontSize = 15.sp,
                textAlign = TextAlign.Right,

                )
        )

    }
}

@Composable
fun LightGreenBtn(texValue: String, enabled: Boolean = true, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(75.dp)
            .padding(
                start = 0.dp,
                top = 15.dp,
                end = 0.dp,
                bottom = 10.dp
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF68AB00),
            disabledContainerColor = Color(0xFF68AB00)
        ),
        shape = RoundedCornerShape(10),
        contentPadding = ButtonDefaults.ContentPadding,
        enabled = enabled

    ) {
        Text(
            style = TextStyle(
                color = Color.White,
                fontSize = 17.sp,

                ),
            text = texValue
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(
    labelValue: String,
    onValueChange: (String) -> Unit
) {

    val passwordValue = remember {
        mutableStateOf("")
    }

    val passwordVisibility = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 12.dp)
            .padding(vertical = 8.dp, horizontal = 10.dp),
        value = passwordValue.value,
        onValueChange = {
            passwordValue.value = it
            onValueChange(it)
        },
        label = { Text(text = labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
        ),
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if (!passwordVisibility.value) {
                Icon(
                    painter = painterResource(id = R.drawable.show_icon),
                    contentDescription = "visibility off",
                    tint = Color.White
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.show_icon),
                    contentDescription = "visibility on",
                    tint = Color.Black
                )
            }
            IconButton(onClick = {
                passwordVisibility.value = !passwordVisibility.value
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.show_icon),
                    contentDescription = "visibility on",
                    tint = Color.Black
                )
            }
        },
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(
            mask = 'X'
        )


    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    onValueChange: (String) -> Unit
) {

    val usernameValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 12.dp)
            .padding(vertical = 4.dp, horizontal = 10.dp),
        value = usernameValue.value ,
        onValueChange = {
            usernameValue.value = it
            onValueChange(it)
        },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Black)
        },
        trailingIcon = {
            Icon(Icons.Default.List, contentDescription = "Search", tint = Color.Black)
        },
        label = { Text(text = "Search products") },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
        ),
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        ),
        keyboardOptions = KeyboardOptions.Default,


        )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NormalTextFieldComponent(
    labelValue: String,
    onValueChange: (String) -> Unit
) {

    val usernameValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 12.dp)
            .padding(vertical = 4.dp, horizontal = 10.dp),
        value = usernameValue.value,
        onValueChange = {
            usernameValue.value = it
            onValueChange(it)
        },
        label = { Text(text = labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
        ),
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        ),
        keyboardOptions = KeyboardOptions.Default,


        )

}

 val item = listOf(
    Items(
        title = "Item 1",
        price = "Ksh 100",
        image = R.drawable.login
    ),
    Items(
        title = "Item 2",
        price = "Ksh 200",
        image = R.drawable.login
    ),
    Items(
        title = "Item 3",
        price = "Ksh 300",
        image = R.drawable.login
    ),
    Items(
        title = "Item 4",
        price = "Ksh 400",
        image = R.drawable.login
    ),
    Items(
        title = "Item 5",
        price = "Ksh 500",
        image = R.drawable.login
    ),
    Items(
        title = "Item 6",
        price = "Ksh 600",
        image = R.drawable.login
    ),
    Items(
        title = "Item 7",
        price = "Ksh 700",
        image = R.drawable.login
    ),
    Items(
        title = "Item 8",
        price = "Ksh 800",
        image = R.drawable.login
    ),
    Items(
        title = "Item 9",
        price = "Ksh 900",
        image = R.drawable.login
    ),
    Items(
        title = "Item 10",
        price = "Ksh 1000",
        image = R.drawable.login
    )

)

data class Items(
    val title: String,
    val price: String,
    val image: Int
)

@Composable
fun ItemComponent(
//    items : List<Items> = item,
    image: Int,
    title: String,
    price: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
//            .padding(top = 8.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "items",
            modifier = modifier
                .fillMaxWidth(0.8f)
                .padding(top = 16.dp),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(top = 4.dp)
        )
        {
            Text(
                text = title, style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Row(
            modifier = Modifier
                    .fillMaxWidth(0.8f)
        )
        {
            Text(
                text = price, style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}
@Composable
fun SearchBar() {
    var searchInput by rememberSaveable { mutableStateOf("") }

    TextField(
        value = searchInput,
        onValueChange = { searchInput = it },
        label = {
            Text(
                "Search for product", style = TextStyle(
                    fontWeight = FontWeight.Normal, fontSize = 18.sp
                )
            )
        },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Black)
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(horizontal = 22.dp),
        shape = RoundedCornerShape(10.dp),
        textStyle = TextStyle(
            color = Color.White, fontWeight = FontWeight.SemiBold
        ),

        )

}

@Composable
fun ItemGrid(
    items: List<Items>,
    modifier: Modifier = Modifier
) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Row (
            modifier = Modifier.fillMaxWidth(0.9f)
        ){
            Text(
                text = "Best Selling", style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 22.dp)
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier,
            //            .padding(8.dp)
            //        contentPadding = PaddingValues(top = 4.dp)
        ) {
            items.forEach(


            ) { item ->
                item {
                    ItemComponent(
                        image = item.image,
                        title = item.title,
                        price = item.price,
                        modifier = modifier
                            .padding(4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Toolbar(modifier: Modifier = Modifier) {
  Row (
      modifier = Modifier
          .height(110.dp)
          .fillMaxWidth()
          .background(Color.White),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.Bottom
  ){

      IconButton(onClick = { /* Handle click event here */ }) {
          Icon(
              painter = painterResource(id = R.drawable.user), // Replace with your icon resource
              contentDescription = "user"
          )
      }

      Text(
          text = "Hello userName",
          style = TextStyle(
              color = Color.Black,
              fontSize = 20.sp,
              fontWeight = FontWeight.Medium
          ),
          modifier = Modifier
              .padding(bottom = 8.dp)
      )


      IconButton(onClick = { /* Handle click event here */ }) {
          Icon(
              painter = painterResource(id = R.drawable.logout), // Replace with your icon resource
              contentDescription = "logout"
          )
      }
  }
}


@Composable
fun Sale(modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier
            .background(Color(0xFF68AB00))
            .padding(8.dp)
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ){


        Text(
            text = "15% off if you pay via MCoopCash!",
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .background(Color(0xFF68AB00))
        )
    }
}

@Preview
@Composable
private fun UsernamePrev() {
    NormalTextFieldComponent(labelValue = "Username") {
    }
}
@Preview
@Composable
private fun SearchPreview() {
    SearchField( onValueChange = {})
}

@Preview
@Composable
private fun SalePreview() {
    Sale()
}
@Preview
@Composable
private fun ToolbarPreview() {
    Toolbar()
}


@Preview
@Composable
private fun ItemPreview() {
    ItemGrid(items = item)
}