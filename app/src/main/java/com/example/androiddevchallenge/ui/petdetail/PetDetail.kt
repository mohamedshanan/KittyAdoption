/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.androiddevchallenge.ui.petdetail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.model.PetCollection
import com.example.androiddevchallenge.model.PetRepo
import com.example.androiddevchallenge.ui.components.JetsnackButton
import com.example.androiddevchallenge.ui.components.JetsnackDivider
import com.example.androiddevchallenge.ui.components.JetsnackSurface
import com.example.androiddevchallenge.ui.components.SnackCollection
import com.example.androiddevchallenge.ui.components.SnackImage
import com.example.androiddevchallenge.ui.theme.JetsnackTheme
import com.example.androiddevchallenge.ui.theme.Neutral8
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import kotlin.math.max
import kotlin.math.min

private val BottomBarHeight = 56.dp
private val TitleHeight = 128.dp
private val GradientScroll = 180.dp
private val ImageOverlap = 115.dp
private val MinTitleOffset = 56.dp
private val MinImageOffset = 12.dp
private val MaxTitleOffset = ImageOverlap + MinTitleOffset + GradientScroll
private val ExpandedImageSize = 300.dp
private val CollapsedImageSize = 150.dp
private val HzPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun SnackDetail(
    snackId: Long,
    upPress: () -> Unit
) {
    val snack = remember(snackId) { PetRepo.getPet(snackId) }
    val related = remember(snackId) { PetRepo.getRelated(snackId) }

    Box(Modifier.fillMaxSize()) {
        val scroll = rememberScrollState(0)
        Header()
        Body(related, scroll)
        Title(snack, scroll.value)
        Image(snack.imageUrl, scroll.value)
        Up(upPress)
        CartBottomBar(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
private fun Header() {
    Spacer(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .background(Brush.horizontalGradient(JetsnackTheme.colors.interactivePrimary))
    )
}

@Composable
private fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
            .background(
                color = Neutral8.copy(alpha = 0.32f),
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            tint = JetsnackTheme.colors.iconInteractive,
            contentDescription = stringResource(R.string.label_back)
        )
    }
}

@Composable
private fun Body(
    related: List<PetCollection>,
    scroll: ScrollState
) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(MinTitleOffset)
        )
        Column(
            modifier = Modifier.verticalScroll(scroll)
        ) {
            Spacer(Modifier.height(GradientScroll))
            JetsnackSurface(Modifier.fillMaxWidth()) {
                Column {
                    Spacer(Modifier.height(ImageOverlap))
                    Spacer(Modifier.height(TitleHeight))

                    Spacer(Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.detail_header),
                        style = MaterialTheme.typography.overline,
                        color = JetsnackTheme.colors.textHelp,
                        modifier = HzPadding
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.detail_placeholder),
                        style = MaterialTheme.typography.body1,
                        color = JetsnackTheme.colors.textHelp,
                        modifier = HzPadding
                    )

                    Spacer(Modifier.height(40.dp))
                    Text(
                        text = stringResource(R.string.ingredients),
                        style = MaterialTheme.typography.overline,
                        color = JetsnackTheme.colors.textHelp,
                        modifier = HzPadding
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.ingredients_list),
                        style = MaterialTheme.typography.body1,
                        color = JetsnackTheme.colors.textHelp,
                        modifier = HzPadding
                    )

                    Spacer(Modifier.height(16.dp))
                    JetsnackDivider()

                    related.forEach { snackCollection ->
                        key(snackCollection.id) {
                            SnackCollection(
                                petCollection = snackCollection,
                                onSnackClick = { },
                                highlight = false
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier
                            .padding(bottom = BottomBarHeight)
                            .navigationBarsPadding(left = false, right = false)
                            .height(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun Title(pet: Pet, scroll: Int) {
    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }
    val offset = (maxOffset - scroll).coerceAtLeast(minOffset)
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = TitleHeight)
            .statusBarsPadding()
            .graphicsLayer { translationY = offset }
            .background(color = JetsnackTheme.colors.uiBackground)
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            text = pet.name,
            style = MaterialTheme.typography.h4,
            color = JetsnackTheme.colors.textSecondary,
            modifier = HzPadding
        )
        Text(
            text = pet.tagline,
            style = MaterialTheme.typography.subtitle2,
            fontSize = 20.sp,
            color = JetsnackTheme.colors.textHelp,
            modifier = HzPadding
        )
        Spacer(Modifier.height(4.dp))
        Spacer(Modifier.height(8.dp))
        JetsnackDivider()
    }
}

@Composable
private fun Image(
    imageUrl: String,
    scroll: Int
) {
    val collapseRange = with(LocalDensity.current) { (MaxTitleOffset - MinTitleOffset).toPx() }
    val collapseFraction = (scroll / collapseRange).coerceIn(0f, 1f)

    CollapsingImageLayout(
        collapseFraction = collapseFraction,
        modifier = HzPadding.then(Modifier.statusBarsPadding())
    ) {
        SnackImage(
            imageUrl = imageUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun CollapsingImageLayout(
    collapseFraction: Float,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        check(measurables.size == 1)

        val imageMaxSize = min(ExpandedImageSize.roundToPx(), constraints.maxWidth)
        val imageMinSize = max(CollapsedImageSize.roundToPx(), constraints.minWidth)
        val imageWidth = lerp(imageMaxSize, imageMinSize, collapseFraction)
        val imagePlaceable = measurables[0].measure(Constraints.fixed(imageWidth, imageWidth))

        val imageY = lerp(MinTitleOffset, MinImageOffset, collapseFraction).roundToPx()
        val imageX = lerp(
            (constraints.maxWidth - imageWidth) / 2, // centered when expanded
            constraints.maxWidth - imageWidth, // right aligned when collapsed
            collapseFraction
        )
        layout(
            width = constraints.maxWidth,
            height = imageY + imageWidth
        ) {
            imagePlaceable.place(imageX, imageY)
        }
    }
}

@Composable
private fun CartBottomBar(modifier: Modifier = Modifier) {
    JetsnackSurface(modifier) {
        Column {
            JetsnackDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .navigationBarsPadding(left = false, right = false)
                    .then(HzPadding)
                    .heightIn(min = BottomBarHeight)
            ) {
                Spacer(Modifier.width(16.dp))
                JetsnackButton(
                    onClick = { /* todo */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(R.string.add_to_cart),
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Preview("Snack Detail")
@Composable
private fun SnackDetailPreview() {
    JetsnackTheme {
        SnackDetail(
            snackId = 1L,
            upPress = { }
        )
    }
}

@Preview("Snack Detail • Dark")
@Composable
private fun SnackDetailDarkPreview() {
    JetsnackTheme(darkTheme = true) {
        SnackDetail(
            snackId = 1L,
            upPress = { }
        )
    }
}
