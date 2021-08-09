package com.kobeissidev.jetpackcomposepokedex.util

import kotlin.math.ceil
import kotlin.math.round

private const val DecimeterToInch = 3.93701
private const val HectogramsToOunces = 3.5274

/**
 * Rounds the double to two precision points.
 */
val Double.rounded get() = round(this * 2) / 2

/**
 * Converts a decimeter into a string with feet and inches.
 */
fun decimeterAsString(value: Int): String {
    val asTotalInches = ceil(value * DecimeterToInch)
    val feet = (asTotalInches / 12).rounded
    val inches = (asTotalInches % 12).rounded
    return StringBuilder().apply {
        if (feet > 0.0) {
            append("${feet.toInt()}' ")
        }
        if (inches > 0.0) {
            append("${inches.toInt()}\"")
        }
    }.trim().toString()
}

/**
 * Converts a hectogram into a string with pounds and ounces.
 */
fun hectogramAsString(value: Int): String {
    val asOunces = ceil(value * HectogramsToOunces)
    val pounds = (asOunces / 16).rounded
    val ounces = (asOunces % 16).rounded

    return StringBuilder().apply {
        if (pounds > 0.0) {
            append("${pounds.toInt()} lbs ")
        }
        if (ounces > 0.0) {
            append("${ounces.toInt()} oz")
        }
    }.trim().toString()
}