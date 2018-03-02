function updateUserProfile() {

    var fullName = $("#fullname").val();
    var email = $("#email").val();
    var password = $("#password").val();
    var birthdate = $("#birthdate").val();
    var address = $("#address").val();
    var job = $("#job").val();
    var limit = $("#limit").val();
    var updateMsg = document.getElementById("updateMsg");
    var userObject = {
        "fullname" : fullName,
        "password" : password,
        "birthdate": birthdate,
        "address"  : address,
        "job"      : job,
        "limit"    : limit
    };


    $.post("/updateUser" , userObject , function (date) {

        if(date === "success")
            location.reload();
        else
        {
            updateMsg.innerHTML = date;
        }
    });

    return false;
}