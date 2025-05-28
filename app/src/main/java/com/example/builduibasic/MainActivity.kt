package com.example.builduibasic

import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
//import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Arrangement

val buttonBlueColor = Color(0xFF1A73E8)
val lightGrayTextColor = Color(0xFF5F6368)
val lightBlueCardColor = Color(0xFFCCE7FF)
val primaryTitleColor = Color(0xFF0D47A1) // Màu xanh dương cho tiêu đề
val orangeColor = Color(0xFFE69500) // Màu cam cho chữ "Brown"
val errorRedColor = Color.Red
val itemLightBlue = Color(0xFFD0E4FF)
val itemDarkBlue = Color(0xFF5C9DFF)
val itemLightGreen = Color(0xFFA5D6A7)
val itemDarkGreen = Color(0xFF66BB6A)
val borderYellow = Color(0xFFFFEB3B)

// Định nghĩa các route
object AppRoutes {
    const val WELCOME_SCREEN = "welcome_screen"
    const val COMPONENT_LIST = "component_list"
    const val TEXT_DETAIL = "text_detail"
    const val IMAGES_SCREEN = "images_screen"
    const val TEXTFIELD_DETAIL_SCREEN = "textfield_detail_screen"
    const val ROW_LAYOUT_DETAIL_SCREEN = "row_layout_detail_screen"
    const val COLUMN_LAYOUT_DETAIL_SCREEN = "column_layout_detail_screen"
    const val PASSWORDFIELD_DETAIL_SCREEN = "passwordfield_detail_screen"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppNavigation()
            }
            // }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppRoutes.WELCOME_SCREEN) {
        composable(AppRoutes.WELCOME_SCREEN) {
            WelcomeScreen(navController = navController)
        }
        composable(AppRoutes.COMPONENT_LIST) {
            UIComponentsListScreen(navController = navController)
        }
        composable(AppRoutes.TEXT_DETAIL) {
            TextDetailScreen(navController = navController)
        }
        composable(AppRoutes.IMAGES_SCREEN) {
            ImagesScreen(navController = navController)
        }
        composable(AppRoutes.TEXTFIELD_DETAIL_SCREEN) {
            TextFieldDetailScreen(navController = navController)
        }
        composable(AppRoutes.ROW_LAYOUT_DETAIL_SCREEN) {
            RowLayoutDetailScreen(navController = navController)
        }
        composable(AppRoutes.COLUMN_LAYOUT_DETAIL_SCREEN) {
            ColumnLayoutDetailScreen(navController = navController)
        }
        composable(AppRoutes.PASSWORDFIELD_DETAIL_SCREEN) {
            PasswordFieldDetailScreen(navController = navController)
        }
    }
}

// --- UIComponentsListScreen điều hướng và các thành phần con (cập nhật) ---

@Composable
fun UIComponentsListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "UI Components List",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = primaryTitleColor,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        CategorySection(title = "Display") {
            DisplayItemCard(
                title = "Text",
                description = "Displays text",
                onClick = {
                    navController.navigate(AppRoutes.TEXT_DETAIL) // Điều hướng khi nhấp
                }
            )
            Spacer(modifier = Modifier.height(12.dp))

            DisplayItemCard(
                title = "Image",
                description = "Displays an image",
                onClick = {
                    navController.navigate(AppRoutes.IMAGES_SCREEN)
                }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        CategorySection(title = "Input") {
            DisplayItemCard(
                title = "TextField",
                description = "Input field for text",
                onClick = {
                    navController.navigate(AppRoutes.TEXTFIELD_DETAIL_SCREEN)
                }
            )
        }
            Spacer(modifier = Modifier.height(12.dp))

            DisplayItemCard(
                title = "PasswordField",
                description = "Input field for passwords",
                onClick = {
                    navController.navigate(AppRoutes.PASSWORDFIELD_DETAIL_SCREEN)
                }
            )


        Spacer(modifier = Modifier.height(24.dp))

        CategorySection(title = "Layout") {
            DisplayItemCard(
                title = "Column",
                description = "Arranges elements vertically",
                onClick = {
                    navController.navigate(AppRoutes.COLUMN_LAYOUT_DETAIL_SCREEN)
                }
            )
            Spacer(modifier = Modifier.height(12.dp))

            DisplayItemCard(
                title = "Row",
                description = "Arranges elements horizontally",
                onClick = {
                    navController.navigate(AppRoutes.ROW_LAYOUT_DETAIL_SCREEN)
                }
            )
        }

    }
}


@Composable
fun CategorySection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        content()
    }
}

// Cập nhật DisplayItemCard để nhận onClick lambda
@Composable
fun DisplayItemCard(
    title: String,
    description: String,
    onClick: (() -> Unit)? = null // onClick là optional
) {
    val baseModifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(8.dp))
        .background(lightBlueCardColor)

    val finalModifier = if (onClick != null) {
        baseModifier.clickable(onClick = onClick)
    } else {
        baseModifier
    }

    Column(
        modifier = finalModifier.padding(16.dp) // Padding luôn được áp dụng
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = description,
            fontSize = 14.sp,
            color = Color.DarkGray
        )
    }
}
//  ----welcome screen----
@Composable
fun WelcomeScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) { // Box để đặt thông tin user ở góc trên phải
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween // Để đẩy button xuống dưới
        ) {
            // Phần trống ở trên để thông tin user không bị che
            Spacer(modifier = Modifier.height(50.dp))

            // Nội dung chính ở giữa
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f) // Để chiếm không gian còn lại ở giữa
            ) {
                Image(
                    painter = painterResource(id = R.drawable.jetpack_icon), // THAY THẾ bằng ID logo của bạn
                    contentDescription = "Jetpack Compose Logo",
                    modifier = Modifier
                        .size(150.dp) // Điều chỉnh kích thước logo
                        .padding(bottom = 24.dp),
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = "Jetpack Compose",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
                    fontSize = 15.sp,
                    color = lightGrayTextColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 24.dp) // Thêm padding ngang cho dễ đọc
                )
            }

            // Button ở dưới cùng
            Button(
                onClick = {
                    navController.navigate(AppRoutes.COMPONENT_LIST) {
                        // Xóa WelcomeScreen khỏi back stack để không quay lại được
                        popUpTo(AppRoutes.WELCOME_SCREEN) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .padding(horizontal = 16.dp, vertical = 4.dp), // Padding cho button
                shape = RoundedCornerShape(26.dp), // Bo tròn mạnh cho button
                colors = ButtonDefaults.buttonColors(containerColor = buttonBlueColor)
            ) {
                Text("I'm ready", fontSize = 18.sp, color = Color.White)
            }
        }

        // Thông tin User ở góc trên phải
        Column(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 24.dp, end = 24.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Trần Thanh Lâm",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
            Text(
                text = "62205000792",
                fontSize = 13.sp,
                color = Color.Gray
            )
        }
    }
}

// Preview cho WelcomeScreen
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun WelcomeScreenPreview() {
    MaterialTheme {
        Surface {
            // Để preview hoạt động, bạn cần tạo drawable 'jetpack_compose_logo.png'
            // hoặc thay thế R.drawable.jetpack_compose_logo bằng một drawable có sẵn.
            WelcomeScreen(navController = rememberNavController())
        }
    }
}

// --- Màn hình TextDetailScreen (MỚI) ---
@OptIn(ExperimentalMaterial3Api::class) // Cho TopAppBar
@Composable
fun TextDetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Text Detail",
                        color = primaryTitleColor, // Màu tiêu đề App Bar
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = primaryTitleColor // Màu icon back
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent // Nền App Bar trong suốt hoặc màu tùy ý
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp), // Thêm padding cho nội dung bên trong
            horizontalAlignment = Alignment.Start // Căn chỉnh nội dung
        ) {
            StyledTextExample()
        }
    }
}

@Composable
fun StyledTextExample() {
    val baseFontSize = 22.sp // Kích thước font cơ bản cho đoạn văn
    Text(
        text = buildAnnotatedString {
            append("The ")
            withStyle(style = SpanStyle(color = Color.Blue, fontSize = baseFontSize.times(1.5f))) {
                append("quick ")
            }
            withStyle(style = SpanStyle(color = orangeColor, fontSize = baseFontSize * 1.5f, fontWeight = FontWeight.Bold)) { // "Brown" to và màu cam
                append("Brown")
            }
            append(" fox jumps ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("over")
            }
            append(" the ")
            withStyle(style = SpanStyle(fontStyle = FontStyle.Italic, textDecoration = TextDecoration.Underline)) { // "lazy" nghiêng và gạch chân (gộp từ hình)
                append("lazy")
            }
            append(" dog.")
        },
        fontSize = baseFontSize, // Kích thước font cơ bản
        lineHeight = (baseFontSize.value * 1.4).sp // Tăng chiều cao dòng cho dễ đọc
    )
}

// --- Previews (cập nhật và thêm mới) ---
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun UIComponentsListScreenPreview() {
    MaterialTheme {
        Surface {
            // Để preview UIComponentsListScreen mà không cần NavController thực sự:
            UIComponentsListScreen(navController = rememberNavController())
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun TextDetailScreenPreview() {
    MaterialTheme {
        Surface {
            TextDetailScreen(navController = rememberNavController())
        }
    }
}
// --- Màn hình TextDetailScreen (MỚI) ---

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImagesScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Images",
                        color = primaryTitleColor,
                        fontWeight = FontWeight.Bold,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = primaryTitleColor
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent // Hoặc màu nền bạn muốn cho AppBar
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp) // Padding cho nội dung
                .verticalScroll(rememberScrollState()) // Cho phép cuộn
        ) {

            Image(
                painter = painterResource(id = R.drawable.uth), // THAY THẾ bằng tên file ảnh local thứ nhất của bạn
                contentDescription = "First Local Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp) // Điều chỉnh chiều cao nếu cần
                    .clip(RoundedCornerShape(12.dp)), // Bo góc cho ảnh
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(9.dp))
            Text(
                text = "https://giaothongvantaitphcm.edu.vn/wp-content/uploads/2025/01/Logo-GTVT.png", // Chú thích cho ảnh thứ nhất
                fontSize = 13.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(25.dp)) // Khoảng cách giữa hai khối ảnh

            // 2. Hình ảnh local thứ hai
            Image(
                painter = painterResource(id = R.drawable.uth2), // THAY THẾ bằng tên file ảnh local thứ hai của bạn
                contentDescription = "Second Local Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp) // Điều chỉnh chiều cao nếu cần
                    .clip(RoundedCornerShape(12.dp)), // Bo góc cho ảnh
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "In app", // Chú thích cho ảnh thứ hai
                fontSize = 13.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

// Preview cho ImagesScreen
@Preview(showBackground = true, backgroundColor = 0xFFF0F0F0)
@Composable
fun ImagesScreenPreview() {
    MaterialTheme {
        Surface {
            // Để preview hoạt động, bạn cần tạo các drawable mẫu:
            // 'first_local_image.png' và 'second_local_image.png' trong res/drawable
            // Nếu không, thay thế R.drawable.* bằng các drawable có sẵn như R.drawable.ic_launcher_background
            // để tránh lỗi khi build preview.
            ImagesScreen(navController = rememberNavController())
        }
    }
}

//---------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDetailScreen(navController: NavController) {
    var inputText by remember { mutableStateOf("") } // State để lưu trữ giá trị của TextField

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "TextField",
                        color = primaryTitleColor, // Sử dụng màu đã định nghĩa
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = primaryTitleColor // Sử dụng màu đã định nghĩa
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent // Hoặc màu nền bạn muốn cho AppBar
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp), // Padding chung cho nội dung
            horizontalAlignment = Alignment.CenterHorizontally // Căn giữa các thành phần con nếu chúng không fillMaxWidth
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                label = { Text("Thông tin nhập") },
                modifier = Modifier.fillMaxWidth(), // TextField chiếm toàn bộ chiều rộng
                singleLine = true // Cho phép nhập trên một dòng (tùy chọn)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tự động cập nhật dữ liệu theo textfield: $inputText",
                color = errorRedColor, // Màu đỏ cho text này
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth() // Để text căn theo lề nếu dài
            )
        }
    }
}

// Preview cho TextFieldDetailScreen
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun TextFieldDetailScreenPreview() {
    MaterialTheme {
        Surface {
            TextFieldDetailScreen(navController = rememberNavController())
        }
    }
}

//---row---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RowLayoutDetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Row Layout",
                        color = primaryTitleColor, // Sử dụng màu đã định nghĩa
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = primaryTitleColor // Sử dụng màu đã định nghĩa
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp), // Padding chung cho nội dung
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Hiển thị 4 hàng ví dụ
            repeat(4) {
                SampleRow()
                if (it < 3) { // Thêm khoảng cách giữa các hàng, trừ hàng cuối cùng
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun SampleRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround, // Sắp xếp các item cách đều nhau
        verticalAlignment = Alignment.CenterVertically
    ) {
        RowItem(color = itemLightBlue)
        RowItem(color = itemDarkBlue)
        RowItem(color = itemLightBlue)
    }
}

@Composable
fun RowItem(color: Color) {
    Box(
        modifier = Modifier
            .width(90.dp)  // Chiều rộng của item
            .height(60.dp) // Chiều cao của item
            .clip(RoundedCornerShape(12.dp)) // Bo góc
            .background(color)
    )
}

// Preview cho RowLayoutDetailScreen
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun RowLayoutDetailScreenPreview() {
    MaterialTheme {
        Surface {
            RowLayoutDetailScreen(navController = rememberNavController())
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnLayoutDetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Column Layout", // Sửa lại từ "Colum Layout"
                        color = primaryTitleColor, // Sử dụng màu đã định nghĩa
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = primaryTitleColor // Sử dụng màu đã định nghĩa
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) { innerPadding ->
        Box( // Sử dụng Box để dễ dàng căn giữa Column ví dụ
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            contentAlignment = Alignment.Center // Căn giữa Column ví dụ trong Box
        ) {
            SampleColumnWithBorder()
        }
    }
}

//---column---
@Composable
fun SampleColumnWithBorder() {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.8f) // Column ví dụ chiếm 80% chiều rộng màn hình
            .border(
                BorderStroke(3.dp, borderYellow), // Độ dày và màu của border
                RoundedCornerShape(16.dp) // Bo góc cho border
            )
            .padding(16.dp), // Padding bên trong border, trước các item
        verticalArrangement = Arrangement.spacedBy(16.dp), // Khoảng cách giữa các item con
        horizontalAlignment = Alignment.CenterHorizontally // Căn giữa các item con theo chiều ngang (nếu chúng không fillMaxWidth)
    ) {
        ColumnItem(color = itemLightGreen)
        ColumnItem(color = itemDarkGreen)
        ColumnItem(color = itemLightGreen)
    }
}

@Composable
fun ColumnItem(color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth() // Item chiếm toàn bộ chiều rộng của Column cha (Column có border)
            .height(80.dp)  // Chiều cao của item
            .clip(RoundedCornerShape(12.dp)) // Bo tròn góc cho item
            .background(color)
    )
}

// Preview cho ColumnLayoutDetailScreen
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ColumnLayoutDetailScreenPreview() {
    MaterialTheme {
        Surface {
            ColumnLayoutDetailScreen(navController = rememberNavController())
        }
    }
}

//----passwordfield---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldDetailScreen(navController: NavController) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "PasswordField",
                        color = primaryTitleColor, // Sử dụng màu đã định nghĩa
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = primaryTitleColor // Sử dụng màu đã định nghĩa
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Nhập mật khẩu") },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Mô tả cho accessibility
                    val description = if (passwordVisible) "Ẩn mật khẩu" else "Hiện mật khẩu"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            // Bạn có thể thêm Text ở đây để hiển thị mật khẩu nếu passwordVisible là true
            // Ví dụ:
            // if (passwordVisible) {
            //     Spacer(modifier = Modifier.height(16.dp))
            //     Text(
            //         text = "Mật khẩu hiện tại: $password",
            //         fontSize = 14.sp
            //     )
            // }
        }
    }
}

// Preview cho PasswordFieldDetailScreen
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PasswordFieldDetailScreenPreview() {
    MaterialTheme {
        Surface {
            PasswordFieldDetailScreen(navController = rememberNavController())
        }
    }
}