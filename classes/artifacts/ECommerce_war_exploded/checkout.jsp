<!DOCTYPE html>
<html lang="en">

<head>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Obaju e-commerce template">
    <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
    <meta name="keywords" content="">

    <title>
        Obaju : e-commerce template
    </title>

    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

    <!-- styles -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">

    <!-- theme stylesheet -->
    <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">
    <script src="js/jquery-1.11.0.min.js"></script>

    <!-- your stylesheet with modifications -->
    <link href="css/custom.css" rel="stylesheet">

    <script src="js/respond.min.js"></script>
    <script src="js/myJs/cartHandleScript.js"></script>
    <link rel="shortcut icon" href="favicon.png">
    <script>
        function checkout()
        {
            $.post("./checkout" , function (data) {

                document.getElementById("pStatus").innerHTML = data;
                document.getElementById("checkoutbtn").disabled = true;
            });
        }
    </script>


</head>

<body onload="checkCartValidaity()">

<jsp:include page="/head.jsp"/>
    <div id="all">

        <div id="content">
            <div class="container">

                <div class="col-md-12">
                    <ul class="breadcrumb">
                        <li><a href="./index.jsp">Home</a>
                        </li>
                        <li>Check Out</li>
                    </ul>
                </div>

                <div class="col-md-9" id="basket">

                    <div class="box">

                        <form method="post" action="checkout1.html">

                            <h1 id="carthead">Check Out</h1>
                            <b id="pStatus"></b>
                        <%--<p class="text-muted">You currently have 3 item(s) in your cart.</p>--%>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th colspan="1">Product</th>
                                            <th colspan="1">Name</th>
                                            <th>Quantity</th>
                                            <th>Unit price</th>
                                            <th colspan="2">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${sessionScope.cartProductList}" var="product">
                                        <tr>
                                            <td><img src="${product.product_img}"></td>

                                            <c:choose>
                                                <c:when test="${product.availableForCart == false}">
                                                    <td style="color: red">${product.name}</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>${product.name}</td>
                                                </c:otherwise>
                                            </c:choose>


                                            <td><p>${product.quantiity}</p></td>
                                            <td>$${product.price}</td>
                                            <td>$${product.price * product.quantiity}</td>

                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <th colspan="4">Total</th>
                                            <c:set var="cartTotal" value="${0}" />
                                            <c:forEach var="product" items="${sessionScope.cartProductList}">
                                                <c:set var="cartTotal" value="${cartTotal + product.price*product.quantiity}" />

                                            </c:forEach>

                                            <th colspan="2">$${cartTotal}</th>
                                        </tr>
                                    </tfoot>
                                </table>

                            </div>
                            <!-- /.table-responsive -->

                            <div class="box-footer">
                                <div class="pull-left">
                                    <a href="basket.jsp" class="btn btn-default"><i class="fa fa-chevron-left"></i>Back to Cart</a>
                                </div>
                                <div class="pull-right">
                                  <!--  <button class="btn btn-default"><i class="fa fa-refresh"></i> Update basket</button> -->
                                    <c:choose>
                                    <c:when test="${fn:length(sessionScope.cartProductList) <= 0}">
                                    <button  disabled type="button" class="btn btn-primary" id="checkoutbtn" onclick="checkout()">
                                        checkout<i class="fa fa-chevron-right"></i>
                                        </c:when>
                                        <c:otherwise>
                                        <button type="button" class="btn btn-primary" id="checkoutbtn" onclick="checkout()">
                                            checkout<i class="fa fa-chevron-right"></i>
                                        </c:otherwise>
                                    </c:choose>

                                    </button>
                                </div>
                            </div>

                        </form>

                    </div>

                </div>
                <div class="col-md-3">
                    <div class="box" id="order-summary">
                        <div class="box-header">
                            <h3>Order summary</h3>
                        </div>
                        <p class="text-muted">Total Price</p>

                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <td>Order subtotal</td>
                                        <th>$${cartTotal}</th>
                                    </tr>
                                    <tr class="total">
                                        <td>Total</td>
                                        <th>$${cartTotal}</th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>


                  <!--  <div class="box">
                        <div class="box-header">
                            <h4>Coupon code</h4>
                        </div>
                        <p class="text-muted">If you have a coupon code, please enter it in the box below.</p>
                        <form>
                            <div class="input-group">

                                <input type="text" class="form-control">

                                <span class="input-group-btn">

					<button class="btn btn-primary" type="button"><i class="fa fa-gift"></i></button>

				    </span>
                            </div>-->
                            <!-- /input-group -->
							<!--
                        </form>
                    </div>
-->
                </div>
                <!-- /.col-md-3 -->

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

        <!-- *** FOOTER ***
 _________________________________________________________ -->
        <jsp:include page="footer.jsp"/>
        <!-- /#footer -->

        <!-- *** FOOTER END *** -->




        <!-- *** COPYRIGHT ***
 _________________________________________________________ -->
        <div id="copyright">
            <div class="container">
                <div class="col-md-6">
                    <p class="pull-left">© 2015 Your name goes here.</p>

                </div>
                <div class="col-md-6">
                    <p class="pull-right">Template by <a href="https://bootstrapious.com/e-commerce-templates">Bootstrapious</a> & <a href="https://fity.cz">Fity</a>
                         <!-- Not removing these links is part of the license conditions of the template. Thanks for understanding :) If you want to use the template without the attribution links, you can do so after supporting further themes development at https://bootstrapious.com/donate  -->
                    </p>
                </div>
            </div>
        </div>
        <!-- *** COPYRIGHT END *** -->



    </div>
    <!-- /#all -->


    

    <!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.cookie.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/modernizr.js"></script>
    <script src="js/bootstrap-hover-dropdown.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/front.js"></script>



</body>

</html>