package com.example.cryptoapp.utils

import java.util.*
import java.sql.Timestamp
import java.text.SimpleDateFormat

fun covertTimestampToTime(timestamp: Int?): String {
    if (timestamp == null) return ""
    val stamp = Timestamp((timestamp * 1000).toLong())
    val date = Date(stamp.time)
    val pattern = "HH:mm:ss"
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    sdf.timeZone = TimeZone.getDefault()
    return sdf.format(date)

}