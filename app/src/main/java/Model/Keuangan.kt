package Model

import android.os.Parcel
import android.os.Parcelable

open class Keuangan(
    var uang:String?,
    var catatan:String?,
    var tipe:String?,
    var jenis:String?,
    var waktu:String?,
    var uid:String?
) : Parcelable {
    constructor(parcel: Parcel?) : this(
        parcel?.readString(),
        parcel?.readString(),
        parcel?.readString(),
        parcel?.readString(),
        parcel?.readString(),
        parcel?.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uang)
        parcel.writeString(catatan)
        parcel.writeString(tipe)
        parcel.writeString(jenis)
        parcel.writeString(waktu)
        parcel.writeString(uid)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Keuangan> {
        override fun createFromParcel(parcel: Parcel): Keuangan {
            return Keuangan(parcel)
        }

        override fun newArray(size: Int): Array<Keuangan?> {
            return arrayOfNulls(size)
        }
    }

}