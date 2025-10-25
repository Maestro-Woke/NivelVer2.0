package com.example.nivelver20.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Data class для хранения адаптивных размеров
data class AdaptiveDimensions(
    val screenWidth: Dp,
    val screenHeight: Dp,
    val screenType: ScreenType,

    // Отступы
    val horizontalPadding: Dp,
    val verticalPadding: Dp,
    val spaceBetweenButtons: Dp,

    // Размеры кнопок
    val buttonHeight: Dp,
    val buttonCornerRadius: Dp,

    // Размеры для буквы Ñ (фото)
    val letterNSize: Dp,
    val letterNTopPadding: Dp,
    val letterNBottomPadding: Dp,

    // Размеры для нижних кнопок
    val bottomButtonHeight: Dp,
    val bottomButtonWidth: Dp,
    val bottomButtonsTopPadding: Dp,

    // Текст
    val titleFontSize: Float,
    val buttonFontSize: Float,
    val bottomButtonFontSize: Float
)

enum class ScreenType {
    SMALL_PHONE,    // 3.5" - 4.5"
    MEDIUM_PHONE,   // 4.5" - 5.5"
    LARGE_PHONE,    // 5.5" - 6.5"
    SMALL_TABLET,   // 6.5" - 9"
    MEDIUM_TABLET,  // 9" - 11"
    LARGE_TABLET    // 11"+
}

// Composable функция для получения адаптивных размеров
@Composable
fun rememberAdaptiveDimensions(): AdaptiveDimensions {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    return remember(configuration.screenWidthDp, configuration.screenHeightDp) {
        val widthDp = configuration.screenWidthDp
        val heightDp = configuration.screenHeightDp
        val screenDiagonal = with(density) {
            Math.sqrt(
                (widthDp * widthDp + heightDp * heightDp).toDouble()
            ).toFloat()
        }

        val screenType = when {
            screenDiagonal < 4.5f * 160 -> ScreenType.SMALL_PHONE
            screenDiagonal < 5.5f * 160 -> ScreenType.MEDIUM_PHONE
            screenDiagonal < 6.5f * 160 -> ScreenType.LARGE_PHONE
            screenDiagonal < 9f * 160 -> ScreenType.SMALL_TABLET
            screenDiagonal < 11f * 160 -> ScreenType.MEDIUM_TABLET
            else -> ScreenType.LARGE_TABLET
        }

        when (screenType) {
            ScreenType.SMALL_PHONE -> AdaptiveDimensions(
                screenWidth = widthDp.dp,
                screenHeight = heightDp.dp,
                screenType = screenType,
                horizontalPadding = 20.dp,
                verticalPadding = 40.dp,
                spaceBetweenButtons = 20.dp,
                buttonHeight = 48.dp,
                buttonCornerRadius = 24.dp,
                letterNSize = 200.dp,
                letterNTopPadding = 20.dp,
                letterNBottomPadding = 20.dp,
                bottomButtonHeight = 50.dp,
                bottomButtonWidth = 50.dp,
                bottomButtonsTopPadding = 20.dp,
                titleFontSize = 22f,
                buttonFontSize = 18f,
                bottomButtonFontSize = 20f
            )

            ScreenType.MEDIUM_PHONE -> AdaptiveDimensions(
                screenWidth = widthDp.dp,
                screenHeight = heightDp.dp,
                screenType = screenType,
                horizontalPadding = 20.dp,
                verticalPadding = 20.dp,
                spaceBetweenButtons = 20.dp,
                buttonHeight = 56.dp,
                buttonCornerRadius = 28.dp,
                letterNSize = 240.dp,
                letterNTopPadding = 20.dp,
                letterNBottomPadding = 20.dp,
                bottomButtonHeight = 56.dp,
                bottomButtonWidth = 160.dp,
                bottomButtonsTopPadding = 20.dp,
                titleFontSize = 26f,
                buttonFontSize = 20f,
                bottomButtonFontSize = 22f
            )

            ScreenType.LARGE_PHONE -> AdaptiveDimensions(
                screenWidth = widthDp.dp,
                screenHeight = heightDp.dp,
                screenType = screenType,
                horizontalPadding = 20.dp,
                verticalPadding = 20.dp,
                spaceBetweenButtons = 20.dp,
                buttonHeight = 60.dp,
                buttonCornerRadius = 30.dp,
                letterNSize = 260.dp,
                letterNTopPadding = 20.dp,
                letterNBottomPadding = 20.dp,
                bottomButtonHeight = 60.dp,
                bottomButtonWidth = 180.dp,
                bottomButtonsTopPadding = 20.dp,
                titleFontSize = 28f,
                buttonFontSize = 22f,
                bottomButtonFontSize = 24f
            )

            ScreenType.SMALL_TABLET -> AdaptiveDimensions(
                screenWidth = widthDp.dp,
                screenHeight = heightDp.dp,
                screenType = screenType,
                horizontalPadding = 20.dp,
                verticalPadding = 20.dp,
                spaceBetweenButtons = 20.dp,
                buttonHeight = 68.dp,
                buttonCornerRadius = 34.dp,
                letterNSize = 300.dp,
                letterNTopPadding = 20.dp,
                letterNBottomPadding = 20.dp,
                bottomButtonHeight = 68.dp,
                bottomButtonWidth = 200.dp,
                bottomButtonsTopPadding = 20.dp,
                titleFontSize = 32f,
                buttonFontSize = 24f,
                bottomButtonFontSize = 26f
            )

            ScreenType.MEDIUM_TABLET -> AdaptiveDimensions(
                screenWidth = widthDp.dp,
                screenHeight = heightDp.dp,
                screenType = screenType,
                horizontalPadding = 20.dp,
                verticalPadding = 20.dp,
                spaceBetweenButtons = 20.dp,
                buttonHeight = 76.dp,
                buttonCornerRadius = 38.dp,
                letterNSize = 350.dp,
                letterNTopPadding = 20.dp,
                letterNBottomPadding = 20.dp,
                bottomButtonHeight = 76.dp,
                bottomButtonWidth = 220.dp,
                bottomButtonsTopPadding = 20.dp,
                titleFontSize = 36f,
                buttonFontSize = 26f,
                bottomButtonFontSize = 28f
            )

            ScreenType.LARGE_TABLET -> AdaptiveDimensions(
                screenWidth = widthDp.dp,
                screenHeight = heightDp.dp,
                screenType = screenType,
                horizontalPadding = 20.dp,
                verticalPadding = 20.dp,
                spaceBetweenButtons = 20.dp,
                buttonHeight = 84.dp,
                buttonCornerRadius = 42.dp,
                letterNSize = 330.dp,
                letterNTopPadding = 20.dp,
                letterNBottomPadding = 20.dp,
                bottomButtonHeight = 84.dp,
                bottomButtonWidth = 240.dp,
                bottomButtonsTopPadding = 20.dp,
                titleFontSize = 40f,
                buttonFontSize = 28f,
                bottomButtonFontSize = 30f
            )
        }
    }
}