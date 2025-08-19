package com.dlmapps.financem.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/* ===================== 1) Colores base (ajusta estos 3) ===================== */
private val PRIMARY   = Color(0xFFAA280FF)  // <— cámbialo por tu primario
private val SECONDARY = Color(0xFF007AFF)  // <— cámbialo por tu secundario
private val TERTIARY  = Color(0xFFFFB020)  // <— opcional, acento

/* ===================== 2) Paletas LIGHT/DARK ===================== */
// LIGHT neutrales (fondos/surfaces)
private val BackgroundLight       = Color(0xFFF7F8FC)
private val SurfaceLight          = Color(0xFFFFFFFF)
private val SurfaceVariantLight   = Color(0xFFE6E8EF)
private val OnBackgroundLight     = Color(0xFF161A20)
private val OnSurfaceLight        = Color(0xFF1E232B)
private val OnPrimaryLight        = Color(0xFFFFFFFF)
private val OnSecondaryLight      = Color(0xFFFFFFFF)
private val OnTertiaryLight       = Color(0xFF1C1C1C)
private val OutlineLight          = Color(0x33424B57) // 20%
private val OutlineVariantLight   = Color(0xFFCDD3DF)

// DARK neutrales (fondos/surfaces)
private val BackgroundDark        = Color(0xFF1E1A30)
private val SurfaceDark           = Color(0xFF151820)
private val SurfaceVariantDark    = Color(0xFF2A2F3A)
private val OnBackgroundDark      = Color(0xFFE5E7EB)
private val OnSurfaceDark         = Color(0xFFDFE3EA)
private val OnPrimaryDark         = Color(0xFFFFFFFF)
private val OnSecondaryDark       = Color(0xFFFFFFFF)
private val OnTertiaryDark        = Color(0xFF101317)
private val OutlineDark           = Color(0x334A5461) // 20%
private val OutlineVariantDark    = Color(0xFF3A4250)

private val LightColors = lightColorScheme(
    primary = PRIMARY,
    onPrimary = OnPrimaryLight,
    secondary = SECONDARY,
    onSecondary = OnSecondaryLight,
    tertiary = TERTIARY,
    onTertiary = OnTertiaryLight,

    background = BackgroundLight,
    onBackground = OnBackgroundLight,

    surface = SurfaceLight,
    onSurface = OnSurfaceLight,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = OnSurfaceLight,

    outline = OutlineLight,
    outlineVariant = OutlineVariantLight
)

private val DarkColors = darkColorScheme(
    primary = PRIMARY,
    onPrimary = OnPrimaryDark,
    secondary = SECONDARY,
    onSecondary = OnSecondaryDark,
    tertiary = TERTIARY,
    onTertiary = OnTertiaryDark,

    background = BackgroundDark,
    onBackground = OnBackgroundDark,

    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = OnSurfaceDark,

    outline = OutlineDark,
    outlineVariant = OutlineVariantDark
)

/* ===================== 3) Tipografías (sin color embebido) ===================== */
private val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default, fontWeight = FontWeight.SemiBold,
        fontSize = 34.sp, lineHeight = 40.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default, fontWeight = FontWeight.Bold,
        fontSize = 24.sp, lineHeight = 30.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default, fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp, lineHeight = 26.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default, fontWeight = FontWeight.Normal,
        fontSize = 16.sp, lineHeight = 22.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default, fontWeight = FontWeight.Medium,
        fontSize = 14.sp, lineHeight = 18.sp
    )
)

/* ===================== 4) Tema con switch automático ===================== */
@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = AppTypography,
        content = content
    )
}
