package Model

import User
import com.google.android.gms.common.api.ResultTransform
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import kotlin.collections.HashMap

class DAOUser () {

        var db: FirebaseDatabase = FirebaseDatabase.getInstance()
        var databaseReference = db.getReference("Users")

    class DAOUser constructor() {

    }

    fun add(use: User, userName:String): Task<Void> {
//        if(use != null) {
            return databaseReference.push().setValue(use)
//        }
    }

    fun update(key: String, hmap:HashMap<String, Objects>): Task<Void> {
        return databaseReference.child(key).updateChildren(hmap as Map<String, Any>)
    }

    fun delete(key:String): Task<Void>{
        return databaseReference.child(key).removeValue()
    }


}