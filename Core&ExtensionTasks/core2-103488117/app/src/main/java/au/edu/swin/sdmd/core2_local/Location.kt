package au.edu.swin.sdmd.core2_local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val image: Int, var name: String, var location: String, var date: String, var rating: Float, val id: Int
) : Parcelable