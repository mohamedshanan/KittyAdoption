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
data class Pet(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val price: Long,
    val tagline: String = "",
    val tags: Set<String> = emptySet()
)

/**
 * Static data
 */

val pets = listOf(
    Pet(
        id = 1L,
        name = "Ellie Mae",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/beagle/n02088364_18403.jpg",
        price = 299
    ),
    Pet(
        id = 2L,
        name = "Crusher A177",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/terrier-norfolk/n02094114_2631.jpg",
        price = 299
    ),
    Pet(
        id = 3L,
        name = "Luna",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/finnish-lapphund/mochilamvan.jpg",
        price = 299
    ),
    Pet(
        id = 4L,
        name = "Buddy",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/pembroke/n02113023_12759.jpg",
        price = 299
    ),
    Pet(
        id = 5L,
        name = "Milo",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/hound-ibizan/n02091244_169.jpg",
        price = 499
    ),
    Pet(
        id = 6L,
        name = "Pickles",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/collie-border/n02106166_884.jpg",
        price = 299
    ),
    Pet(
        id = 7L,
        name = "Ida",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/schipperke/n02104365_675.jpg",
        price = 1299
    ),
    Pet(
        id = 8L,
        name = "Sundance Kid",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/terrier-australian/n02096294_1168.jpg",
        price = 299
    ),
    Pet(
        id = 9L,
        name = "Fendi",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/clumber/n02101556_1469.jpg",
        price = 549
    ),
    Pet(
        id = 10L,
        name = "Butch Cassidy",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/terrier-yorkshire/n02094433_9739.jpg",
        price = 299
    ),
    Pet(
        id = 11L,
        name = "Dixie",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/germanshepherd/n02106662_5169.jpg",
        price = 299
    ),
    Pet(
        id = 12L,
        name = "Merida",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/pitbull/IMG_20190826_121528_876.jpg",
        price = 299
    ),
    Pet(
        id = 13L,
        name = "Jimi",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/airedale/n02096051_3796.jpg",
        price = 299
    ),
    Pet(
        id = 14L,
        name = "Delilah",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/cattledog-australian/IMG_1042.jpg",
        price = 299
    ),
    Pet(
        id = 15L,
        name = "Almond",
        imageUrl = "https://images.dog.ceo/breeds/terrier-toy/n02087046_2316.jpg",
        price = 299
    ),
    Pet(
        id = 16L,
        name = "Prinley",
        imageUrl = "https://images.dog.ceo/breeds/pitbull/IMG_20190826_121528_876.jpg",
        price = 299
    ),
    Pet(
        id = 17L,
        name = "Sammy",
        imageUrl = "https://images.dog.ceo/breeds/bouvier/n02106382_1452.jpg",
        price = 299
    ),
    Pet(
        id = 18L,
        name = "Moose",
        imageUrl = "https://images.dog.ceo/breeds/terrier-border/n02093754_5342.jpg",
        price = 299
    ),
    Pet(
        id = 19L,
        name = "Raven",
        imageUrl = "https://images.dog.ceo/breeds/spaniel-irish/n02102973_879.jpg",
        price = 299
    ),
    Pet(
        id = 20L,
        name = "Baboo",
        imageUrl = "https://images.dog.ceo/breeds/mexicanhairless/n02113978_3419.jpg",
        price = 299
    ),
    Pet(
        id = 21L,
        name = "Daisy",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/chow/n02112137_2453.jpg",
        price = 299
    ),
    Pet(
        id = 22L,
        name = "Bella",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/sheepdog-english/n02105641_11253.jpg",
        price = 299
    ),
    Pet(
        id = 23L,
        name = "Shirley",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/pointer-german/n02100236_304.jpg",
        price = 299
    ),
    Pet(
        id = 24L,
        name = "Maria",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/coonhound/n02089078_1758.jpg",
        price = 299
    ),
    Pet(
        id = 25L,
        name = "Mary's foster puppy",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/rottweiler/n02106550_11105.jpg",
        price = 299
    ),
    Pet(
        id = 26L,
        name = "Squishy",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/bluetick/n02088632_3640.jpg",
        price = 299
    ),
    Pet(
        id = 27L,
        name = "Lou",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/spaniel-sussex/n02102480_4544.jpg",
        price = 299
    ),
    Pet(
        id = 28L,
        name = "Ruby",
        tagline = "A tag line",
        imageUrl = "https://images.dog.ceo/breeds/pinscher-miniature/n02107312_2967.jpg",
        price = 299
    )
)
