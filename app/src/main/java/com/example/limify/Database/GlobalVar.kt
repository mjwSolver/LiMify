package Database

import Model.HistoryRecycle
import Model.Keuangan
import com.example.limify01.model.User


class GlobalVar {
    companion object{
        var uid=null
        val STORAGE_PERMISSION_CODE: Int = 100
        val listDataUser = ArrayList<User>()
        var seelist = false
        val listDataKeuangan = ArrayList<Keuangan>()
        val listHistoryRecycle = ArrayList<HistoryRecycle>()
    }
}