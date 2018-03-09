function createAdminHandler() {


  
    console.log("create admin");
    var name = document.getElementById("admin_name");
    var email = document.getElementById("admin_email");
    var password = document.getElementById("admin_password");
    var birthDate = document.getElementById("admin_birthdate");
    var address = document.getElementById("admin_address");
    var job = document.getElementById("admin_job");
 

    var postObject = {
        "name":name.value,
        "email":email.value ,
        "pass":password.value,
        "birthdate":birthDate.value,
        "address":address.value,
        "job":job.value
        
    };
    var createAdminErrorLabel = document.getElementById("createAdminErrorLabel");
    var createAdminBtn = document.getElementById("createAdminBtn");
    createAdminBtn.disabled = true;
    $.post("../CreateAdmin" , postObject , function (data) {
    console.log(data);
        if(data === "success")
            data = "Register Successfully";
        createAdminErrorLabel.innerHTML = data;
        createAdminBtn.disabled = false;

    });
    return false;
}