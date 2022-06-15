package com.example.limify01.model

import android.os.Parcel
import android.os.Parcelable

class Pengeluaran (
    var pengeluaran:String?,
    parcel: Parcel? = null
) : Keuangan(parcel) {

    fun addParent (keuangan: Keuangan){
        this.catatan=keuangan.catatan
        this.jenis=keuangan.jenis
        this.waktu=keuangan.waktu
        this.uid=keuangan.uid
    }

}