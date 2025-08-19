package com.dlmapps.financem

import androidx.compose.runtime.Composable
import com.dlmapps.financem.ui.onboarding.FundFlexLoginScreen
import com.dlmapps.financem.ui.onboarding.IntroScreen
import com.dlmapps.financem.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    AppTheme {
//        FundFlexLoginScreen()
        IntroScreen()
    }
}

@Preview
@Composable
fun Preview_Light() {
    AppTheme(darkTheme = false) {
        FundFlexLoginScreen()
    }
}

@Preview
@Composable
fun Preview_Dark() {
    AppTheme(darkTheme = true) {
        FundFlexLoginScreen()
    }
}