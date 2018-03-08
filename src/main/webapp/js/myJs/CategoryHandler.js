function getAllCategory() {
    $.post("./allcat", function (data) {
     //   var categoryList = document.getElementById("categoryList");
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "./allcat", true);

       var list = JSON.parse(data);

        for (var i = 0; i < list.length; i++) {
            $('#categoryList').append('<li><a href="./catName?category='+list[i]+'">'+list[i]+ '</a></li>');
        }
    });

}