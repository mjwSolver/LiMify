package Model

import android.os.Parcel
import android.os.Parcelable

data class Bulanan(
    var kebutuhan:String?,
    var keinginan:String?,
    var investasi:String?,
    var dom:String?,
    var uid:String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(kebutuhan)
        parcel.writeString(keinginan)
        parcel.writeString(investasi)
        parcel.writeString(dom)
        parcel.writeString(uid)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Bulanan> {
        override fun createFromParcel(parcel: Parcel): Bulanan {
            return Bulanan(parcel)
        }

        override fun newArray(size: Int): Array<Bulanan?> {
            return arrayOfNulls(size)
        }
    }

}
