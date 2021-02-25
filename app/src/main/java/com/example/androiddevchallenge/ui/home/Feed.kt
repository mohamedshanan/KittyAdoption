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

package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.PetCollection
import com.example.androiddevchallenge.model.PetRepo
import com.example.androiddevchallenge.ui.components.JetsnackDivider
import com.example.androiddevchallenge.ui.components.JetsnackSurface
import com.example.androiddevchallenge.ui.components.SnackCollection
import com.example.androiddevchallenge.ui.theme.JetsnackTheme
import dev.chrisbanes.accompanist.insets.statusBarsHeight

@Composable
fun Feed(
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val snackCollections = remember { PetRepo.getPets() }
    Feed(
        snackCollections,
        onSnackClick,
        modifier
    )
}

@Composable
private fun Feed(
    petCollections: List<PetCollection>,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    JetsnackSurface(modifier = modifier.fillMaxSize()) {
        Box {
            SnackCollectionList(petCollections, onSnackClick)
            DestinationBar()
        }
    }
}

@Composable
private fun SnackCollectionList(
    petCollections: List<PetCollection>,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        item {
            Spacer(Modifier.statusBarsHeight(additional = 56.dp))
        }
        itemsIndexed(petCollections) { index, snackCollection ->
            if (index > 0) {
                JetsnackDivider(thickness = 2.dp)
            }
            SnackCollection(
                petCollection = snackCollection,
                onSnackClick = onSnackClick,
                index = index
            )
        }
    }
}

@Preview("Home")
@Composable
fun HomePreview() {
    JetsnackTheme {
        Feed(onSnackClick = { })
    }
}

@Preview("Home • Dark Theme")
@Composable
fun HomeDarkPreview() {
    JetsnackTheme(darkTheme = true) {
        Feed(onSnackClick = { })
    }
}
