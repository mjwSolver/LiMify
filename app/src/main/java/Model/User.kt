package Model


class User(
    var userName:String,
    var userPassword:String
) {

    constructor() : this(userName = "", userPassword = "") {
    }

}