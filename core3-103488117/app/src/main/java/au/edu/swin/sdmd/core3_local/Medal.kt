package au.edu.swin.sdmd.core3_local

data class Medal(
    val country: String,
    val countryCode: String,
    val timesCompeted: Int,
    val gold: Int,
    val silver: Int,
    val bronze: Int,
    val totalMedals: Int
)