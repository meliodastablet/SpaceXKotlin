package com.mcakiroglu.spacexkotlin.utils

class FormatUtil {

    companion object {
        fun isNull(data: Any?): Boolean {
            val result: Boolean = data != null
            return result;
        }

        fun isNullString(data: String?): String{
            return if(data.isNullOrEmpty() || data.equals("null")){
                ""
            }else{
                data
            }

        }

    }


    /*
    *
    *  try {
                val inputMethodManager: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken,0)
            }catch (e: Exception){
                //do smtng
            }
    *
    *
    * */
}