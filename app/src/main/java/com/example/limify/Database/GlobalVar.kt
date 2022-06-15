package Database

import com.example.limify01.model.Pemasukkan
import com.example.limify01.model.Pengeluaran
import com.example.limify01.model.User


class GlobalVar {
    companion object{
        var uid = ""
        val STORAGE_PERMISSION_CODE: Int = 100
        val listDataUser = ArrayList<User>()
        val listDataPengeluaran = ArrayList<Pengeluaran>()
        val listDataPemasukkann = ArrayList<Pemasukkan>()


        //
        var dataUser = ArrayList<String>()


    }
}