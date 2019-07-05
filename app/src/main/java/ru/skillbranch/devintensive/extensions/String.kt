package ru.skillbranch.devintensive.extensions

fun String?.trimOrNull(): String? {
    val resultString = this?.trim()

    return if (resultString?.isEmpty() == true) null else resultString
}

fun String?.truncate(count: Int = 16): String? {
    var str = this
    if(this?.length!! > count){
        str = str?.trim()
    }
    str = str?.take(count)
    if(this.length > count){
        return str?.trim().plus("...")
    }
    return str
}

fun String?.stripHtml(): String? {
    return this
        ?.replace("<.*?>".toRegex(), "")
        ?.replace("\\s+".toRegex(), " ")
}