package com.kobeissidev.jetpackcomposepokedex.util

private const val BaseUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/"
private const val PokemonBaseUrl = "${BaseUrl}pokemon/"
private const val BaseImageUrl = "${PokemonBaseUrl}other/official-artwork/"
private const val PNG = ".png"

/**
 * Build the image url using an id
 */
val Int.imageUrl get() = "${BaseImageUrl}${this}${PNG}"

/**
 * Build the sprite url using an id
 */
val Int.spriteUrl get() = "${PokemonBaseUrl}${this}${PNG}"

/**
 * Build the image url using a name
 */
val String.imageUrl get() = "${BaseImageUrl}${this}${PNG}"