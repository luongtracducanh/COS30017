package au.edu.swin.sdmd.l09_notquitebinaryfiles.data

import android.content.Context
import java.io.*

object HistoryFile {
    const val fileName = "decimal_history"

    /**
     * @effects
     *  append the specified content to the file named fileName.
     *
     *  This file is located under the folder "files" of the app's data folder on the device
     */
    fun appendInput(context: Context, fileName: String, content: String) {
        context.openFileOutput(fileName, Context.MODE_APPEND).use {
            it.write(content.toByteArray())
            it.write("\n".toByteArray())
        }
    }

    /**
     * @effects
     *  read and return the entire content of the file named fileName as List<String>
     *
     *  This file is located under the folder "files" of the app's data folder on the device
     */
    fun getFileContents(context: Context, fileName: String): List<String> {
        // if file exists, read data and reverse it
        return if (File(context.filesDir.absolutePath, fileName).exists()) {
            val history = context.openFileInput(fileName)
                .bufferedReader().useLines {
                    it.toList()
                }
            /* to show the most recent ones on top */
            history.asReversed()
        } else { // if file does not exist, return an empty list
            emptyList()
        }
    }

    /**
     * @effects
     *  delete the file named fileName.
     *
     *  This file is located under the folder "files" of the app's data folder on the device
     */
    fun deleteFile(context: Context, fileName: String) {
        context.deleteFile(fileName)
    }
}