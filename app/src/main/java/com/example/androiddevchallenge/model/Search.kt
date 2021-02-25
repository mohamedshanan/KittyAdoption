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

package com.example.androiddevchallenge.model

import androidx.compose.runtime.Immutable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * A fake repo for searching.
 */
object SearchRepo {
    fun getCategories(): List<SearchCategoryCollection> = searchCategoryCollections
    fun getSuggestions(): List<SearchSuggestionGroup> = searchSuggestions

    suspend fun search(query: String): List<Pet> = withContext(Dispatchers.Default) {
        delay(200L) // simulate an I/O delay
        pets.filter { it.name.contains(query, ignoreCase = true) }
    }
}

@Immutable
data class SearchCategoryCollection(
    val id: Long,
    val name: String,
    val categories: List<SearchCategory>
)

@Immutable
data class SearchCategory(
    val name: String,
    val imageUrl: String
)

@Immutable
data class SearchSuggestionGroup(
    val id: Long,
    val name: String,
    val suggestions: List<String>
)

/**
 * Static data
 */

private val searchCategoryCollections = listOf(
    SearchCategoryCollection(
        id = 0L,
        name = "Categories",
        categories = listOf(
            SearchCategory(
                name = "Chips & crackers",
                imageUrl = "https://images.dog.ceo/breeds/pointer-germanlonghair/hans3.jpg"
            ),
            SearchCategory(
                name = "Fruit snacks",
                imageUrl = "https://images.dog.ceo/breeds/schnauzer-miniature/n02097047_1791.jpg"
            ),
            SearchCategory(
                name = "Desserts",
                imageUrl = "https://images.dog.ceo/breeds/buhund-norwegian/hakon3.jpg"
            ),
            SearchCategory(
                name = "Nuts ",
                imageUrl = "https://images.dog.ceo/breeds/bouvier/n02106382_112.jpg"
            )
        )
    ),
    SearchCategoryCollection(
        id = 1L,
        name = "Lifestyles",
        categories = listOf(
            SearchCategory(
                name = "Organic",
                imageUrl = "https://images.dog.ceo/breeds/poodle-standard/n02113799_2765.jpg"
            ),
            SearchCategory(
                name = "Gluten Free",
                imageUrl = "https://images.dog.ceo/breeds/bullterrier-staffordshire/n02093256_3297.jpg"
            ),
            SearchCategory(
                name = "Paleo",
                imageUrl = "https://images.dog.ceo/breeds/mountain-swiss/n02107574_1132.jpg"
            ),
            SearchCategory(
                name = "Vegan",
                imageUrl = "https://images.dog.ceo/breeds/cattledog-australian/IMG_7057.jpg"
            ),
            SearchCategory(
                name = "Vegitarian",
                imageUrl = "https://images.dog.ceo/breeds/ovcharka-caucasian/IMG_20191125_161809.jpg"
            ),
            SearchCategory(
                name = "Whole30",
                imageUrl = "https://images.dog.ceo/breeds/pointer-germanlonghair/hans3.jpg"
            )
        )
    )
)

private val searchSuggestions = listOf(
    SearchSuggestionGroup(
        id = 0L,
        name = "Recent searches",
        suggestions = listOf(
            "Cheese",
            "Apple Sauce"
        )
    ),
    SearchSuggestionGroup(
        id = 1L,
        name = "Popular searches",
        suggestions = listOf(
            "Organic",
            "Gluten Free",
            "Paleo",
            "Vegan",
            "Vegitarian",
            "Whole30"
        )
    )
)
