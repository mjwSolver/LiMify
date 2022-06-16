package Model

import android.os.Parcel

class PengeluaranHarian(
    var tipe:String?, parcel: Parcel?= null
): KeuanganHarian(parcel) {

    fun addParent (keuanganHarian: KeuanganHarian){
        this.uang=keuanganHarian.uang
        this.dotd=keuanganHarian.dotd
    }

}