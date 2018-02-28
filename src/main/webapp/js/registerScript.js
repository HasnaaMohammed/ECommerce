function registerHandler() {


    console.log("Register");
    var name = document.getElementById("reg-name");
    var email = document.getElementById("reg-email");
    var password = document.getElementById("reg-password");
    var birthDate = document.getElementById("reg-birthdate");
    var address = document.getElementById("reg-address");
    var job = document.getElementById("reg-job");
    var creditLimit = document.getElementById("reg-limit");

    var postObject = {
        "name":name.value,
        "email":email.value ,
        "pass":password.value,
        "birthdate":birthDate.value,
        "address":address.value,
        "job":job.value,
        "limit":creditLimit.value
    };
    var registerErrorLabel = document.getElementById("registerErrorLabel");
    var registerBtn = document.getElementById("registerBtn");
    registerBtn.disabled = true;
    $.post("/Register" , postObject , function (data) {
    console.log(data);
        if(data === "success")
            data = "Register Successfully";
        registerErrorLabel.innerHTML = data;
        registerBtn.disabled = false;

    });
    return false;
}