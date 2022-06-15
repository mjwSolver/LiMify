class User(
    var userName:String,
    var userPassword:String,
    var userEmail:String
) {

    constructor() : this(userName = "", userPassword = "", userEmail = "") {  }
}
