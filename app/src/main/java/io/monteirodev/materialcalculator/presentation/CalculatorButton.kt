package io.monteirodev.materialcalculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import io.monteirodev.materialcalculator.presentation.HighlightLevel.Highlighted
import io.monteirodev.materialcalculator.presentation.HighlightLevel.Neutral
import io.monteirodev.materialcalculator.presentation.HighlightLevel.SemiHighlighted
import io.monteirodev.materialcalculator.presentation.HighlightLevel.StronglyHighlighted

@Composable
fun CalculatorButton(
    action: CalculatorUiAction,
    modifier: Modifier = Modifier,
    onclick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(
                when (action.highlightLevel) {
                    Neutral -> colorScheme.surfaceVariant
                    SemiHighlighted -> colorScheme.inverseSurface
                    Highlighted -> colorScheme.tertiary
                    StronglyHighlighted -> colorScheme.primary
                }
            )
            .clickable { onclick() },
        contentAlignment = Alignment.Center
    ) {
        if (action.text != null) {
            Text(
                text = action.text,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                color = when (action.highlightLevel) {
                    Highlighted -> colorScheme.onSurfaceVariant
                    Neutral -> colorScheme.inverseOnSurface
                    SemiHighlighted -> colorScheme.onTertiary
                    StronglyHighlighted -> colorScheme.onPrimary
                }
            )
        } else {
            action.content()
        }
    }
}