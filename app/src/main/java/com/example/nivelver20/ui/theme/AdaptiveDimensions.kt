package com.example.nivelver20.ui.theme

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.sqrt

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
    val bottomButtonFontSize: Float,

    // Для экрана выбора уровня
    val nivelItemSpacing: Dp,
    val nivelImageSize: Dp,
    val nivelCircleWidth: Dp,
    val nivelCircleHeight: Dp,
    val nivelTitleFontSize: Float,
    val nivelSideTextFontSize: Float,

    // Для экрана авторизации (Login)
    val loginTitleFontSize: Float,
    val loginLabelFontSize: Float,
    val loginInputHeight: Dp,
    val loginButtonWidth: Dp,
    val loginButtonHeight: Dp,
    val loginSpaceBetweenInputs: Dp,
    val loginSpaceBetweenButtons: Dp,

    // Для экрана Vocabulario
    val vocabularioCardHeight: Dp,
    val vocabularioCardCornerRadius: Dp,
    val vocabularioTitleFontSize: Float,
    val vocabularioWordFontSize: Float,
    val vocabularioCounterFontSize: Float,
    val vocabularioCardSpacing: Dp,
    val vocabularioPadding: Dp,
    val vocabularioBlockWeight: Float,  // Вес блока карточек (испанских/русских)
    val vocabularioBlockSpacing: Dp
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
@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun rememberAdaptiveDimensions(): AdaptiveDimensions {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    return remember(configuration.screenWidthDp, configuration.screenHeightDp) {
        val widthDp = configuration.screenWidthDp
        val heightDp = configuration.screenHeightDp
        val screenDiagonal = with(density) {
            sqrt(
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
                verticalPadding = 20.dp,
                spaceBetweenButtons = 20.dp,
                buttonHeight = 40.dp,
                buttonCornerRadius = 24.dp,
                letterNSize = 200.dp,
                letterNTopPadding = 20.dp,
                letterNBottomPadding = 20.dp,
                bottomButtonHeight = 40.dp,
                bottomButtonWidth = 40.dp,
                bottomButtonsTopPadding = 20.dp,
                titleFontSize = 22f,
                buttonFontSize = 18f,
                bottomButtonFontSize = 20f,
                nivelItemSpacing = 20.dp,
                nivelImageSize = 90.dp,
                nivelCircleWidth = 140.dp,
                nivelCircleHeight = 90.dp,
                nivelTitleFontSize = 28f,
                nivelSideTextFontSize = 28f,

                // Для экрана авторизации
                loginTitleFontSize = 28f,
                loginLabelFontSize = 16f,
                loginInputHeight = 50.dp,
                loginButtonWidth = 250.dp,
                loginButtonHeight = 50.dp,
                loginSpaceBetweenInputs = 15.dp,
                loginSpaceBetweenButtons = 15.dp,

                // Для экрана Vocabulario
                vocabularioCardHeight = 60.dp,
                vocabularioCardCornerRadius = 12.dp,
                vocabularioTitleFontSize = 28f,
                vocabularioWordFontSize = 18f,
                vocabularioCounterFontSize = 42f,
                vocabularioCardSpacing = 10.dp,
                vocabularioPadding = 16.dp,
                vocabularioBlockWeight = 0.3f,
                vocabularioBlockSpacing = 10.dp
            )

            ScreenType.MEDIUM_PHONE -> AdaptiveDimensions(
                screenWidth = widthDp.dp,
                screenHeight = heightDp.dp,
                screenType = screenType,
                horizontalPadding = 20.dp,
                verticalPadding = 20.dp,
                spaceBetweenButtons = 20.dp,
                buttonHeight = 45.dp,
                buttonCornerRadius = 28.dp,
                letterNSize = 240.dp,
                letterNTopPadding = 20.dp,
                letterNBottomPadding = 20.dp,
                bottomButtonHeight = 45.dp,
                bottomButtonWidth = 160.dp,
                bottomButtonsTopPadding = 20.dp,
                titleFontSize = 26f,
                buttonFontSize = 20f,
                bottomButtonFontSize = 22f,
                nivelItemSpacing = 20.dp,
                nivelImageSize = 110.dp,
                nivelCircleWidth = 155.dp,
                nivelCircleHeight = 105.dp,
                nivelTitleFontSize = 32f,
                nivelSideTextFontSize = 32f,

                // Для экрана авторизации
                loginTitleFontSize = 32f,
                loginLabelFontSize = 18f,
                loginInputHeight = 56.dp,
                loginButtonWidth = 280.dp,
                loginButtonHeight = 56.dp,
                loginSpaceBetweenInputs = 20.dp,
                loginSpaceBetweenButtons = 20.dp,

                // Для экрана Vocabulario
                vocabularioCardHeight = 70.dp,
                vocabularioCardCornerRadius = 14.dp,
                vocabularioTitleFontSize = 32f,
                vocabularioWordFontSize = 20f,
                vocabularioCounterFontSize = 48f,
                vocabularioCardSpacing = 12.dp,
                vocabularioPadding = 18.dp,
                vocabularioBlockWeight = 0.3f,
                vocabularioBlockSpacing = 10.dp
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
                bottomButtonFontSize = 24f,
                nivelItemSpacing = 20.dp,
                nivelImageSize = 150.dp,
                nivelCircleWidth = 200.dp,
                nivelCircleHeight = 150.dp,
                nivelTitleFontSize = 36f,
                nivelSideTextFontSize = 36f,

                // Для экрана авторизации
                loginTitleFontSize = 36f,
                loginLabelFontSize = 20f,
                loginInputHeight = 60.dp,
                loginButtonWidth = 300.dp,
                loginButtonHeight = 60.dp,
                loginSpaceBetweenInputs = 20.dp,
                loginSpaceBetweenButtons = 20.dp,

                // Для экрана Vocabulario
                vocabularioCardHeight = 20.dp,
                vocabularioCardCornerRadius = 18.dp,
                vocabularioTitleFontSize = 30f,
                vocabularioWordFontSize = 19f,
                vocabularioCounterFontSize = 42f,
                vocabularioCardSpacing = 6.dp,
                vocabularioPadding = 16.dp,
                vocabularioBlockWeight = 0.3f,
                vocabularioBlockSpacing = 10.dp
            )

            ScreenType.SMALL_TABLET -> AdaptiveDimensions(
                screenWidth = widthDp.dp,
                screenHeight = heightDp.dp,
                screenType = screenType,
                horizontalPadding = 20.dp,
                verticalPadding = 40.dp,
                spaceBetweenButtons = 20.dp,
                buttonHeight = 58.dp,
                buttonCornerRadius = 34.dp,
                letterNSize = 300.dp,
                letterNTopPadding = 20.dp,
                letterNBottomPadding = 20.dp,
                bottomButtonHeight = 58.dp,
                bottomButtonWidth = 200.dp,
                bottomButtonsTopPadding = 20.dp,
                titleFontSize = 32f,
                buttonFontSize = 24f,
                bottomButtonFontSize = 26f,
                nivelItemSpacing = 20.dp,
                nivelImageSize = 180.dp,
                nivelCircleWidth = 360.dp,
                nivelCircleHeight = 145.dp,
                nivelTitleFontSize = 42f,
                nivelSideTextFontSize = 42f,

                // Для экрана авторизации
                loginTitleFontSize = 48f,
                loginLabelFontSize = 28f,
                loginInputHeight = 68.dp,
                loginButtonWidth = 250.dp,
                loginButtonHeight = 68.dp,
                loginSpaceBetweenInputs = 25.dp,
                loginSpaceBetweenButtons = 25.dp,

                // Для экрана Vocabulario
                vocabularioCardHeight = 40.dp,
                vocabularioCardCornerRadius = 18.dp,
                vocabularioTitleFontSize = 42f,
                vocabularioWordFontSize = 26f,
                vocabularioCounterFontSize = 63f,
                vocabularioCardSpacing = 6.dp,
                vocabularioPadding = 22.dp,
                vocabularioBlockWeight = 0.3f,
                vocabularioBlockSpacing = 10.dp
            )

            ScreenType.MEDIUM_TABLET -> AdaptiveDimensions(
                screenWidth = widthDp.dp,
                screenHeight = heightDp.dp,
                screenType = screenType,
                horizontalPadding = 20.dp,
                verticalPadding = 40.dp,
                spaceBetweenButtons = 20.dp,
                buttonHeight = 77.dp,
                buttonCornerRadius = 38.dp,
                letterNSize = 350.dp,
                letterNTopPadding = 20.dp,
                letterNBottomPadding = 20.dp,
                bottomButtonHeight = 77.dp,
                bottomButtonWidth = 220.dp,
                bottomButtonsTopPadding = 20.dp,
                titleFontSize = 44f,
                buttonFontSize = 36f,
                bottomButtonFontSize = 32f,
                nivelItemSpacing = 20.dp,
                nivelImageSize = 190.dp,
                nivelCircleWidth = 390.dp,
                nivelCircleHeight = 230.dp,
                nivelTitleFontSize = 66f,
                nivelSideTextFontSize = 66f,

                // Для экрана авторизации
                loginTitleFontSize = 55f,
                loginLabelFontSize = 35f,
                loginInputHeight = 76.dp,
                loginButtonWidth = 400.dp,
                loginButtonHeight = 77.dp,
                loginSpaceBetweenInputs = 30.dp,
                loginSpaceBetweenButtons = 30.dp,

                // Для экрана Vocabulario
                vocabularioCardHeight = 40.dp,
                vocabularioCardCornerRadius = 20.dp,
                vocabularioTitleFontSize = 48f,
                vocabularioWordFontSize = 30f,
                vocabularioCounterFontSize = 72f,
                vocabularioCardSpacing = 18.dp,
                vocabularioPadding = 24.dp,
                vocabularioBlockWeight = 0.3f,
                vocabularioBlockSpacing = 10.dp
            )

            ScreenType.LARGE_TABLET -> AdaptiveDimensions(
                screenWidth = widthDp.dp,
                screenHeight = heightDp.dp,
                screenType = screenType,
                horizontalPadding = 20.dp,
                verticalPadding = 40.dp,
                spaceBetweenButtons = 20.dp,
                buttonHeight = 87.dp,
                buttonCornerRadius = 42.dp,
                letterNSize = 400.dp,
                letterNTopPadding = 20.dp,
                letterNBottomPadding = 20.dp,
                bottomButtonHeight = 87.dp,
                bottomButtonWidth = 240.dp,
                bottomButtonsTopPadding = 20.dp,
                titleFontSize = 40f,
                buttonFontSize = 28f,
                bottomButtonFontSize = 30f,
                nivelItemSpacing = 20.dp,
                nivelImageSize = 220.dp,
                nivelCircleWidth = 570.dp,
                nivelCircleHeight = 170.dp,
                nivelTitleFontSize = 54f,
                nivelSideTextFontSize = 54f,

                // Для экрана авторизации
                loginTitleFontSize = 59f,
                loginLabelFontSize = 38f,
                loginInputHeight = 84.dp,
                loginButtonWidth = 480.dp,
                loginButtonHeight = 87.dp,
                loginSpaceBetweenInputs = 35.dp,
                loginSpaceBetweenButtons = 35.dp,

                // Для экрана Vocabulario
                vocabularioCardHeight = 110.dp,
                vocabularioCardCornerRadius = 22.dp,
                vocabularioTitleFontSize = 54f,
                vocabularioWordFontSize = 34f,
                vocabularioCounterFontSize = 81f,
                vocabularioCardSpacing = 20.dp,
                vocabularioPadding = 26.dp,
                vocabularioBlockWeight = 0.3f,
                vocabularioBlockSpacing = 10.dp
            )
        }
    }
}