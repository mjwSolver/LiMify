package com.example.limify01.model

import android.os.Parcel

class Pemasukkan(
    var pemasukkan:String?,
    parcel: Parcel? = null
) : Keuangan(parcel) {

    fun addParent (keuangan: Keuangan){
        this.catatan=keuangan.catatan
        this.jenis=keuangan.jenis
        this.waktu=keuangan.waktu
        this.uid=keuangan.uid
    }

}