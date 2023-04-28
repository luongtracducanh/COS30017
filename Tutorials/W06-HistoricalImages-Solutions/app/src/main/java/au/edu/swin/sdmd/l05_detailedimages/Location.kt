package au.edu.swin.sdmd.l05_detailedimages

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(val name: String, val author: String,
                    val latitude: Float, val longitude: Float,
                    var visited: Boolean = false): Parcelable {
}