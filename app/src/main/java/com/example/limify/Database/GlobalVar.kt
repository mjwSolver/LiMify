package Database

import Model.*
import User

//import com.example.limify01.model.Pemasukkan
//import com.example.limify01.model.Pengeluaran


class GlobalVar {
    companion object{



        var uid = ""
        val STORAGE_PERMISSION_CODE: Int = 100
        val listDataUser = ArrayList<User>()
        val listDataKeuangan = ArrayList<Keuangan>()
        val listHistoryRecycle = ArrayList<HistoryRecycle>()
        val listDataMasukHarian = ArrayList<PemasukanHarian>()
        val listDataKeluarHarian = ArrayList<PengeluaranHarian>()
        var listDataBulanan = ArrayList<Bulanan>()
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