package com.sebqv97.myselfpromoteapp

import java.io.Serializable

data class Message(
    val ContactName: String,
    val ContactNumber: String,
    val DisplayName: String,
    val juniorIncluded: Boolean,
    val JobTitle: String?,
    val CurrentlyAvailable: Boolean,
    val AvailableDate: String?
) :Serializable{
    fun getFullJobDescription() = if(juniorIncluded) "a Junior $JobTitle" else "an $JobTitle"
    fun getAvailability() = if(CurrentlyAvailable) "immediately" else "from $AvailableDate"
}

