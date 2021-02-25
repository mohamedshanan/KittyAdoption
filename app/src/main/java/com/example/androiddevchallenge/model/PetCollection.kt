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

@Immutable
data class PetCollection(
    val id: Long,
    val name: String,
    val pets: List<Pet>,
    val type: CollectionType = CollectionType.Normal
)

enum class CollectionType { Normal, Highlight }

/**
 * A fake repo
 */
object PetRepo {
    fun getPets(): List<PetCollection> = snackCollections
    fun getPet(petId: Long) = pets.find { it.id == petId }!!
    fun getRelated(@Suppress("UNUSED_PARAMETER") snackId: Long) = related
    fun getInspiredByCart() = inspiredByCart
    fun getCart() = cart
}

/**
 * Static data
 */

private val tastyTreats = PetCollection(
    id = 1L,
    name = "Recently added",
    type = CollectionType.Highlight,
    pets = pets.subList(0, 13)
)

private val popular = PetCollection(
    id = 2L,
    name = "Popular",
    pets = pets.subList(14, 19)
)

private val wfhFavs = tastyTreats.copy(
    id = 3L,
    name = "Favourites"
)

private val newlyAdded = popular.copy(
    id = 4L,
    name = "Newly Added"
)

private val exclusive = tastyTreats.copy(
    id = 5L,
    name = "Only on KittyAdoption"
)

private val also = tastyTreats.copy(
    id = 6L,
    name = "Customers also choosed"
)

private val inspiredByCart = tastyTreats.copy(
    id = 7L,
    name = "Adopt Me"
)

private val snackCollections = listOf(
    tastyTreats,
    popular,
    wfhFavs,
    newlyAdded,
    exclusive
)

private val related = listOf(
    also,
    popular
)

private val cart = listOf(
    OrderLine(pets[4], 2),
    OrderLine(pets[6], 3),
    OrderLine(pets[8], 1)
)

@Immutable
data class OrderLine(
    val pet: Pet,
    val count: Int
)
