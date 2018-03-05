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


function checkCartValidaity()
{
    var checkOutbtn = document.getElementById("checkoutbtn");
    var cartHead = document.getElementById("carthead");
    var errorLabel = document.getElementById("errorlabel");
      $.post("./validatecart" , function (data) {

          if(data === "out")
          {
            checkOutbtn.disabled = true;
            cartHead.style.color = "red";
            errorLabel.innerHTML = "One Or more Element in Your cart is Not Available Now !";
          }
      });

}