function addToCart(data)
{

    var sku = data.elements["productRequestSku"].value;
    var obj = {"productRequestSku":sku};
    $.get("./updatecart" , obj , function (data) {
        document.getElementById("result").innerHTML = data;
        $('#myModal').modal('show');
    });

    return false;
}