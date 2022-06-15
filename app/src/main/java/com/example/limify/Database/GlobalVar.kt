package Database

import User

//import com.example.limify01.model.Pemasukkan
//import com.example.limify01.model.Pengeluaran


class GlobalVar {
    companion object{
        var uid = ""
        val STORAGE_PERMISSION_CODE: Int = 100
        val listDataUser = ArrayList<User>()
//        val listDataPengeluaran = ArrayList<Pengeluaran>()
//        val listDataPemasukkann = ArrayList<Pemasukkan>()

        var emailUser:String = ""
        var passUser:String = ""

        var masukan:String=""
        var luaran:String=""
        var needing:String=""
        var wanting:String=""
        var saving:String=""

        var monthing:Boolean = false

//        ing = globalvar
//        tanpa ing - sharedPreference
//        an = GlobalVar
//        tanpa an - sharedPreference


    }
}