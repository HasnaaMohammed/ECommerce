function getAllCategory() {
    var xhttp = new XMLHttpRequest();
    $.post("./allcat", function (data) {

        // xhttp.open("POST", "./allcat", true);

       var list = JSON.parse(data);
        for (var i = 0; i < list.length; i++) {
            $('#categoryList').append('<li><a href="./catName?category='+list[i]+'">'+list[i]+ '</a></li>');
        }

    });

}

function viewAllProduct()
{
    $.post("/Products" , function(data){

        data = JSON.parse(data);
        data.forEach(param =>{
            param.products.forEach(param => {

        });
    });
    });
}


function getAllCategoryAdmin() {
    $.post("../allcat", function (data) {


        var list = JSON.parse(data);
        for (var i = 0; i < list.length; i++) {
            $('#sel1').append('<option>'+list[i]+'</option>');
        }

    });

}