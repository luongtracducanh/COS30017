package au.edu.swin.sdmd.w10_unitlist

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class MyUnit(val unit: String) {
    // scenario 2 ONLY
//    var icon: Bitmap? = drawIcon() // this should be null for some scenarios

    fun drawIcon(): Bitmap {
        val bgColor = getColor(unit)
        val b = Bitmap.createBitmap(192, 192, Bitmap.Config.ARGB_8888)
        b.eraseColor(bgColor) // fill bitmap with the color
        val c = Canvas(b)
        val p = Paint()
        p.isAntiAlias = true
        p.color = Color.WHITE
        p.textSize = 96.0f
        c.drawText(unit.last().toString(), 32f, 96f, p)
        return b
    }

    /** Construct a color from a movie name  */
    private fun getColor(name: String): Int {
        val hex = toHexString(name)
        val red = "#" + hex.substring(0, 2)
        val green = "#" + hex.substring(2, 4)
        val blue = "#" + hex.substring(4, 6)
        val alpha = "#" + hex.substring(6, 8)
        return Color.argb(
            Integer.decode(alpha), Integer.decode(red), Integer.decode(green), Integer.decode(blue)
        )
    }

    /** Given a location name -- generate a hex value from its hashcode  */
    private fun toHexString(name: String): String {
        val hc = name.hashCode()
        var hex = Integer.toHexString(hc)
        if (hex.length < 8) {
            hex = hex + hex + hex
            hex = hex.substring(0, 8) // use default color value
        }
        return hex
    }
}