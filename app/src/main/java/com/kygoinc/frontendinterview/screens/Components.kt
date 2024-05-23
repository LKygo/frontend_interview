package com.kygoinc.frontendinterview.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Person
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.kygoinc.frontendinterview.R

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
        value = usernameValue.value,
        onValueChange = {
            usernameValue.value = it
            onValueChange(it)
        },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Black)
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                painterResource(id = R.drawable.filter)
            }
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
        title = "Traveling Bag",
        price = "KES 600.00",
        image = R.drawable.image_1,
        description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight …see more"
    ),
    Items(
        title = "Carrier Bag",
        price = "Ksh 50.00",
        image = R.drawable.image_2,
        description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight …see more"
    ),
    Items(
        title = "Puffer Jacket",
        price = "Ksh 1800.00",
        image = R.drawable.image_7,
        description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight …see more"
    ),
    Items(
        title = "Polo Shirt",
        price = "Ksh 400.00",
        image = R.drawable.image_9,
        description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight …see more"
    ),
    Items(
        title = "Round Neck",
        price = "Ksh 300.00",
        image = R.drawable.image_10,
        description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight …see more"
    ),
    Items(
        title = "Fleece Kikoi",
        price = "Ksh 100.00",
        image = R.drawable.image_11,
        description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight …see more"
    ),

    )

data class Items(
    val title: String,
    val price: String,
    val image: Int,
    val description: String
)

@Composable
fun ItemComponent(
//    items : List<Items> = item,
    image: Int,
    title: String,
    price: String,
    onItemClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
//            .padding(top = 8.dp)
            .background(Color.White)
            .clickable {
                onItemClicked()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "items",
            modifier = modifier
                .fillMaxWidth(0.8f)
                .height(200.dp)
                .padding(top = 16.dp),
            contentScale = ContentScale.Fit
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
                text = price,
                style = TextStyle(
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
    onItemClicked: (Int) -> Unit,

    ) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(0.9f)
        ) {
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

            ) {
            items.forEachIndexed(


            ) { index, item ->
                item {
                    ItemComponent(
                        image = item.image,
                        title = item.title,
                        price = item.price,
                        modifier = Modifier.padding(4.dp),
                        onItemClicked = {
                            onItemClicked(index)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Toolbar(
    onLogout: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .height(90.dp)
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {

        IconButton(onClick = { /* Handle click event here */ }) {
            Icon(Icons.Outlined.Person, contentDescription = "Search", tint = Color.Black)

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


        IconButton(onClick = onLogout) {
            Icon(
                painter = painterResource(id = R.drawable.logout), // Replace with your icon resource
                contentDescription = "logout"
            )
        }
    }
}


@Composable
fun Sale(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .background(Color(0xFF68AB00))
            .padding(14.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {


        Text(
            text = "15% off if you pay via MCoopCash!",
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .background(Color(0xFF68AB00))
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsernameTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val isFocused = remember { mutableStateOf(false) }

    Box(modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent { event ->
                    isFocused.value = event.isFocused
                }
                .border(
                    BorderStroke(1.dp, color = Color.LightGray),
                    shape = RoundedCornerShape(8.dp) // Remove rounded corners for underline
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color(0xFF68AB00), // Hide default focus indicator
                unfocusedIndicatorColor = Color.Transparent  // Hide default unfocused indicator
            )
        )

        Text(
            text = "Username",
            color = Color.LightGray,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = if (isFocused.value) 4.dp else 16.dp) // Adjust label movement
        )
    }
}

@Composable
fun DetailsToolbar(
    labelValue: String,
    onBack: () -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .height(90.dp)
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {

        IconButton(onClick = { /* Handle click event here */ }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)

        }

        Text(
            text = labelValue,
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
        )


        IconButton(onClick = { onCancel() }) {
            Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.Black)

        }
    }
}


@Composable
fun LoginInputField(
    label: String,
    inputValue: String,
    onChangeValue: (String) -> Unit,
    errorMessage: String? = null,
    indicator: Boolean = true,
    isPassword: Boolean,

    ) {
    val colors = TextFieldDefaults.colors(
        errorTextColor = Color.Red,
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
        errorContainerColor = Color.Transparent,
        errorCursorColor = Color.Red,
        focusedIndicatorColor = if (indicator) Color(0xE0414141) else MaterialTheme.colorScheme.scrim,
        unfocusedIndicatorColor = if (indicator) Color(0xFF414141) else MaterialTheme.colorScheme.scrim,
        errorIndicatorColor = Color.Red,
        errorLeadingIconColor = Color.Red,
        errorTrailingIconColor = Color.Red,
        errorLabelColor = Color.Red,
        errorPlaceholderColor = Color.Red,
        disabledIndicatorColor = Color.Transparent

    )

    val passwordVisibility = remember { mutableStateOf(false) }
    TextField(
        colors = colors,
        value = inputValue,
        textStyle = TextStyle(
            fontSize = 17.sp,
            textAlign = TextAlign.Left,
            color = MaterialTheme.colorScheme.secondary,

            //fontFamily = FontFamily(Font(R.font.nunitosans_7pt_regular)),


        ),
        isError = errorMessage != null,
        label = {
            if (inputValue.isEmpty() || errorMessage == null) {
                Text(
                    text = label,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 15.sp,
                        //fontFamily = FontFamily(Font(R.font.nunitosans_7pt_regular)),

                    ),
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .offset(y = (-10).dp)
                        .offset(x = (-20).dp)
                )
            } else {
                Text(
                    text = errorMessage,
                    style = TextStyle(
                        color = Color.Red,
                        fontSize = 15.sp,
                        //fontFamily = FontFamily(Font(R.font.nunitosans_7pt_regular)),

                    ),
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .offset(y = (-10).dp)
                        .offset(x = (-20).dp)

                )
            }
        },
        onValueChange = onChangeValue,
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth(0.9f)
            .padding(
                top = 8.dp, // 0dp to remove, adjust as needed
                bottom = 8.dp,
                start = 0.dp,
                end = 0.dp
            ),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = false,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        shape = RectangleShape,
        maxLines = 1,
        singleLine = true,
        trailingIcon = {
            if (isPassword) {
                if (!passwordVisibility.value) {
                    Icon(
                        painter = painterResource(id = R.drawable.visibility_off),
                        contentDescription = "visibility off",
                        tint = Color(0xFF68AB00)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.show_icon),
                        contentDescription = "visibility on",
                        tint = Color(0xFF68AB00)
                    )
                }
                IconButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.show_icon),
                        contentDescription = "visibility on",
                        tint = Color(0xFF68AB00)
                    )
                }
            } else {

            }
        },
        visualTransformation = if (isPassword && !passwordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None
    )
    Row {
        Text(
            text = "Forgot $label?", style = TextStyle(
                color = Color(0xFF68AB00),
                fontSize = 15.sp,
                //fontFamily = FontFamily(Font(R.font.nunitosans_7pt_regular)),
            ),
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                .offset(x = 100.dp)
        )
    }
}

@Composable
fun InputFieldErrorText(errorMessage: String) {
    Text(
        text = errorMessage,
        style = TextStyle(
            color = Color.Red,
            fontSize = 12.sp,
            //fontFamily = FontFamily(Font(R.fo))
        ),
        modifier = Modifier
            .padding(0.dp, 5.dp, 0.dp, 5.dp)

    )
}

@Preview
@Composable
private fun NewInputPrev() {
    UsernameTextField(value = "", onValueChange = {})
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
    SearchField(onValueChange = {})
}

@Preview
@Composable
private fun SalePreview() {
    Sale()
}

@Preview
@Composable
private fun ToolbarPreview() {
    Toolbar(onLogout = {})
}


@Preview
@Composable
private fun ItemPreview() {
    ItemGrid(items = item) {}
}