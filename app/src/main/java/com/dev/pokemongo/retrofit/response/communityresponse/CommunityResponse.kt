package com.dev.pokemongo.retrofit.response.communityresponse

import androidx.room.Entity

//@Entity(tableName = "comm")
data class CommunityResponse(
    val friends: List<Friends>,
    val foes: List<Foes>
)