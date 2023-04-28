package au.edu.swin.sdmd.l09_notquitebinaryfiles.data

import android.content.Context

/**
 * @overview Provides an API for manipulating shared-preference file
 */
object SharedPrefFile {
  /**
   * @effects
   *  inserts (key,value) into the shared-preference file whose name is prefFileName
   */
  fun updateSharedPrefs(context: Context,
                        prefFileName: String,
                        key: String, value: String?) {
    /**
     * For writing to a shared preference file, we need to name
     * the file first.
     */
    val sharedPref = context.getSharedPreferences(prefFileName,
        Context.MODE_PRIVATE)

    /**
     * Using an Editor to add/update values in the file before committing.
     */
    val editor = sharedPref?.edit()
    editor?.putString(key, value)
    editor?.apply()
  }

  /**
   * @effects
   *  reads (key,defVal) from the shared-preference file whose name is prefFileName.
   *  if an entry with the specified key exists
   *    return its value
   *  else
   *    return defVal
   */
  fun checkSharedPrefs(context: Context,
                       prefFileName: String,
                       key: String,
                       defVal: String): String? {
    /**
     * For reading shared preference files, simply find the correct file
     * and find the value using the key. A default value can also be
     * specified.
     */
    val sharedPref = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
    return sharedPref?.getString(key, defVal)
  }
}