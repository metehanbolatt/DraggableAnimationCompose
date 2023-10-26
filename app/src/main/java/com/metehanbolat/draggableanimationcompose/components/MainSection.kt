package com.metehanbolat.draggableanimationcompose.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.metehanbolat.draggableanimationcompose.R
import kotlin.math.roundToInt

@Composable
fun MainSection() {

    var laptopImageOffsetX by remember { mutableFloatStateOf(0f) }
    val laptopImageOffsetXAnimation by animateFloatAsState(
        targetValue = laptopImageOffsetX,
        label = "laptopOffset X"
    )

    var laptopImageOffsetY by remember { mutableFloatStateOf(0f) }
    val laptopImageOffsetYAnimation by animateFloatAsState(
        targetValue = laptopImageOffsetY,
        label = "laptopOffset Y"
    )

    var circleImageOffsetX by remember { mutableFloatStateOf(0f) }
    val circleImageOffsetXAnimation by animateFloatAsState(
        targetValue = circleImageOffsetX,
        label = "circleOffset X"
    )

    var circleImageOffsetY by remember { mutableFloatStateOf(0f) }
    val circleImageOffsetYAnimation by animateFloatAsState(
        targetValue = circleImageOffsetY,
        label = "circleOffset Y"
    )

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        val brush = Brush.horizontalGradient(listOf(Color(0xFF00E1FF), Color(0xB5C000F5)))

        Canvas(
            modifier = Modifier
                .size(200.dp)
                .offset {
                    IntOffset(
                        circleImageOffsetXAnimation.roundToInt(),
                        circleImageOffsetYAnimation.roundToInt()
                    )
                }
        ) {
            drawCircle(brush = brush)
        }

        Image(
            modifier = Modifier
                .size(260.dp)
                .offset {
                    IntOffset(
                        laptopImageOffsetXAnimation.roundToInt(),
                        laptopImageOffsetYAnimation.roundToInt()
                    )
                }
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDrag = { _, dragAmount ->
                            laptopImageOffsetX += dragAmount.x
                            laptopImageOffsetY += dragAmount.y

                            circleImageOffsetX -= dragAmount.x
                            circleImageOffsetY -= dragAmount.y

                        },
                        onDragEnd = {
                            laptopImageOffsetX = 0f
                            laptopImageOffsetY = 0f

                            circleImageOffsetX = 0f
                            circleImageOffsetY = 0f
                        }
                    )
                },
            painter = painterResource(R.drawable.msi_laptop),
            contentDescription = "Laptop"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainSectionPreview() {
    MainSection()
}