package Model

import android.os.Parcel
import android.os.Parcelable

open class KeuanganHarian (
    var uang:String?,
    var dotd:String?
): Parcelable {
    constructor(parcel: Parcel?) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uang)
        parcel.writeString(dotd)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<KeuanganHarian> {
        override fun createFromParcel(parcel: Parcel): KeuanganHarian {
            return KeuanganHarian(parcel)
        }

        override fun newArray(size: Int): Array<KeuanganHarian?> {
            return arrayOfNulls(size)
        }
    }
}