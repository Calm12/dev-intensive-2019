package ru.skillbranch.devintensive.utils

object Transliterator {
    fun rusToEngByLetter(letter: String): String {
        return when (letter) {
            "а" -> "a"
            "б" -> "b"
            "в" -> "v"
            "г" -> "g"
            "д" -> "d"
            "е" -> "e"
            "ё" -> "e"
            "ж" -> "zh"
            "з" -> "z"
            "и" -> "i"
            "й" -> "i"
            "к" -> "k"
            "л" -> "l"
            "м" -> "m"
            "н" -> "n"
            "о" -> "o"
            "п" -> "p"
            "р" -> "r"
            "с" -> "s"
            "т" -> "t"
            "у" -> "u"
            "ф" -> "f"
            "х" -> "h"
            "ц" -> "c"
            "ч" -> "ch"
            "ш" -> "sh"
            "щ" -> "sh'"
            "ъ" -> ""
            "ы" -> "i"
            "ь" -> ""
            "э" -> "e"
            "ю" -> "yu"
            "я" -> "ya"
            else -> letter
        }
    }
}