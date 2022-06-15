package Model

import android.os.Parcel


class HistoryRecycle (
    var jangkawaktu:String?,
    var listid:Int, parcel: Parcel? = null
) : Keuangan(parcel) {

    fun addParent (keuangan: Keuangan){
        this.uang=keuangan.uang
        this.catatan=keuangan.catatan
        this.tipe=keuangan.tipe
        this.jenis=keuangan.jenis
        this.waktu=keuangan.waktu
        this.uid=keuangan.uid
    }



}