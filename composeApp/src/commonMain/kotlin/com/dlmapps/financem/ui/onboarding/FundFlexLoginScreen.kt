package com.dlmapps.financem.ui.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import financem.composeapp.generated.resources.Res
import financem.composeapp.generated.resources.ic_app_logo
import financem.composeapp.generated.resources.ic_apple
import financem.composeapp.generated.resources.ic_email
import financem.composeapp.generated.resources.ic_google
import financem.composeapp.generated.resources.ic_password
import financem.composeapp.generated.resources.ic_show_on
import financem.composeapp.generated.resources.ic_visibility_off
import org.jetbrains.compose.resources.painterResource

@Composable
fun FundFlexLoginScreen(
    onSignIn: (email: String, password: String, remember: Boolean) -> Unit = { _, _, _ -> },
    onForgotPassword: () -> Unit = {},
    onSignUp: () -> Unit = {},
    onAppleSignIn: () -> Unit = {},
    onGoogleSignIn: () -> Unit = {},
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }

    val scroll = rememberScrollState()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .imePadding()
                .verticalScroll(scroll)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(32.dp))

            // App logo
            Image(
                painter = painterResource(Res.drawable.ic_app_logo),
                contentDescription = "FundFlex Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .shadow(10.dp, RoundedCornerShape(28.dp), clip = true)
            )

            Spacer(Modifier.height(28.dp))

            // Title
            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(fontSize = 28.sp)) {
                        append("Welcome to ")
                    }
                    withStyle(SpanStyle(fontSize = 28.sp)) {
                        append("FundFlex ")
                    }
                    append("👋")
                },
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,

                )
            Spacer(Modifier.height(8.dp))
            Text(
                "Enter your Email & Password to Sign in",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,

                )

            Spacer(Modifier.height(24.dp))

            // Email
            RoundedField(
                value = email,
                onValueChange = { email = it },
                placeholder = "Email",
                leading = {
                    Image(
                        painter = painterResource(Res.drawable.ic_email),
                        contentDescription = null)
                }
            )

            Spacer(Modifier.height(14.dp))

            // Password
            RoundedField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Password",
                leading = { Image(
                    painter = painterResource(Res.drawable.ic_password),
                    contentDescription = null) },
                isPassword = true,
                passwordVisible = passwordVisible,
                onToggleVisibility = { passwordVisible = !passwordVisible }
            )

            Spacer(Modifier.height(8.dp))

            // Remember + Forgot
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it }
                )
                Text("Remember me")
                Spacer(Modifier.weight(1f))
                Text(
                    text = "Forgot Password?",
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.clickable(onClick = onForgotPassword),
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(Modifier.height(16.dp))

            // Sign in button
            Button(
                onClick = { onSignIn(email.trim(), password, rememberMe) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = Color.White
                )
//                enabled = email.isNotBlank() && password.isNotBlank()
            ) {
                Text("Sign in", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            }

            Spacer(Modifier.height(20.dp))

            // Sign up CTA
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Don’t Have an Account? ")
                Text(
                    "Sign Up",
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable(onClick = onSignUp)
                )
            }

            Spacer(Modifier.height(16.dp))

            // Divider "or"
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = Color.LightGray, thickness = 1.dp
                )
                Text(
                    "  or  ",
                    color = Color.LightGray,
                    fontSize = 14.sp
                )
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = Color.LightGray, thickness = 1.dp
                )
            }

            Spacer(Modifier.height(16.dp))

            // Apple
            BrandButton(
                text = "Continue with Apple",
                background = Color.Black,
                foreground = Color.White,
                iconPainter = painterResource(Res.drawable.ic_apple),
                onClick = onAppleSignIn
            )

            Spacer(Modifier.height(12.dp))

            // Google
            BrandButton(
                text = "Continue with Google",
                background = Color.White,
                foreground = Color(0xFF1F1F1F),
                borderColor = Color.LightGray,
                iconPainter = painterResource(Res.drawable.ic_google),
                onClick = onGoogleSignIn
            )

            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun RoundedField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leading: @Composable (() -> Unit)? = null,
    isPassword: Boolean = false,
    passwordVisible: Boolean = false,
    onToggleVisibility: (() -> Unit)? = null,
) {
    val shape = RoundedCornerShape(18.dp)

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = { Text(placeholder, color = Color.LightGray) },
        leadingIcon = leading,
        trailingIcon = if (isPassword) {
            {
                IconButton(onClick = { onToggleVisibility?.invoke() }) {
                    if (passwordVisible)
                        Image(
                            painter = painterResource(Res.drawable.ic_show_on),
                            contentDescription = null
                        )
                    else
                        Image(
                            painter = painterResource(Res.drawable.ic_visibility_off),
                            contentDescription = null)
                }
            }
        } else null,
        shape = shape,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .border(1.dp, Color.LightGray, shape)
            .background(Color.Transparent, shape),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = Color.LightGray,
            errorBorderColor = MaterialTheme.colorScheme.error,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.primary
        ),
        visualTransformation = if (isPassword && !passwordVisible)
            PasswordVisualTransformation() else VisualTransformation.None
    )
}

@Composable
private fun BrandButton(
    text: String,
    background: Color,
    foreground: Color,
    iconPainter: Painter,
    borderColor: Color? = null,
    onClick: () -> Unit
) {
    val shape = RoundedCornerShape(16.dp)
    val contentPadding = PaddingValues(horizontal = 16.dp)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(shape)
            .clickable(onClick = onClick),
        color = background,
        contentColor = foreground,
        tonalElevation = 0.dp,
        shadowElevation = 0.dp,
//        border = borderColor?.let { BorderStroke(1.dp,it) }
    ) {
        Row(
            Modifier.fillMaxSize().padding(contentPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = iconPainter,
                contentDescription = null,
                modifier = Modifier.size(22.dp)
            )
            Spacer(Modifier.width(12.dp))
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}