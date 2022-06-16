package Model

import android.os.Parcel
import android.os.Parcelable

data class Bulanan(
    var kebutuhan:String?,
    var keinginan:String?,
    var investasi:String?,
    var dom:String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
<<<<<<< Updated upstream
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
=======
        parcel?.readString(),
        parcel?.readString()
>>>>>>> Stashed changes
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(kebutuhan)
        parcel.writeString(keinginan)
        parcel.writeString(investasi)
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