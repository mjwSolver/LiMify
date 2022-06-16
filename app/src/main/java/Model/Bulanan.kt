package Model

import android.os.Parcel
import android.os.Parcelable

data class Bulanan(
    var uang:String?,
    var dom:String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uang)
        parcel.writeString(dom)
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