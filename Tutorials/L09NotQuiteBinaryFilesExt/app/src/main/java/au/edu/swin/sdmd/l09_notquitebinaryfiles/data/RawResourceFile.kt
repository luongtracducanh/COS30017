package au.edu.swin.sdmd.l09_notquitebinaryfiles.data

import android.content.res.Resources

object RawResourceFile {
  /**
   * @effects
   *  read and return the raw content of the file whose resource-id is fileRid.
   *  This file is located in the folder <code>res/raw</code>
   */
  fun readContent(resources: Resources, fileRid: Int) : String {
    return resources.openRawResource(fileRid).bufferedReader().readText()
  }
}