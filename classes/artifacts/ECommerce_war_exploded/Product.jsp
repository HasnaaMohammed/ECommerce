<!DOCTYPE html>
<html lang="en">

<head>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <!-- your stylesheet with modifications -->
    <link href="css/custom.css" rel="stylesheet">

    <script src="js/respond.min.js"></script>
    <script src="js/jquery-1.11.0.min.js"></script>

    <script src="js/myJs/CategoryHandler.js"></script>
    <script src="js/myJs/cartHandleScript.js"></script>
    <link rel="shortcut icon" href="favicon.png">


</head>

<body onload="getAllCategory()">
<!-- *** TOPBAR ***
_________________________________________________________ -->
<jsp:include page="head.jsp"/>
<div class="modal fade" id="myModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 id="modalmsg" class="modal-title">Add To Cart</h4>
                <div class="modal-body">
                    <p id="result"></p>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<div id="all">

    <div id="content">
        <div class="container">

            <div class="col-md-12">
                <ul class="breadcrumb">
                    <li><a href="#">Home</a>
                    </li>
                    <li>Ladies</li>
                </ul>
            </div>

            <div class="col-md-3">
                <div class="panel panel-default sidebar-menu">

                    <div class="panel-heading">
                        <h3 class="panel-title">Categories</h3>
                    </div>

                    <div class="panel-body">
                        <ul class="nav nav-pills nav-stacked category-menu">
                            <li>
                                <ul id="categoryList">
                                </ul>


                        </ul>

                    </div>
                </div>
            </div>

            <div class="col-md-9">
                <div class="box">
                    <h1>${requestScope.categoryName}</h1>
                    <p>In our Ladies department we offer wide selection of the best products we have found and carefully
                        selected worldwide.</p>
                </div>

                <div class="row products">

                    <c:forEach items="${requestScope.product}" var="pro">
                        <div class="col-md-4 col-sm-6">

                            <div class="product">
                                <div class="flip-container">
                                    <div class="flipper">
                                        <div class="front">
                                            <img src="${pro.product_img}" alt="" class="img-responsive">

                                        </div>
                                        <div class="back">

                                            <img src="${pro.product_img}" alt="" class="img-responsive">

                                        </div>
                                    </div>
                                </div>

                                <img src="${pro.product_img}" alt="" class="img-responsive">

                                <div class="text">
                                    <h3>${pro.name}</h3>
                                    <p class="price">${pro.price}</p>
                                    <form onsubmit="return addToCart(this)">
                                        <<input type="hidden" value="${pro.sku}" name="productRequestSku">
                                        <p class="buttons">
                                            <!--   <a href="detail.html" class="btn btn-default">View detail</a>-->
                                            <button href="basket.jsp" class="btn btn-primary"><i
                                                    class="fa fa-shopping-cart"></i>Add to cart
                                            </button>
                                        </p>
                                    </form>
                                </div>
                                <!-- /.text -->
                            </div>
                            <!-- /.product -->

                        </div>
                    </c:forEach>

                    <!-- /.col-md-4 -->
                </div>
                <!-- /.products -->

                <%--<div class="pages">--%>

                    <%--<p class="loadMore">--%>
                        <%--<a href="#" class="btn btn-primary btn-lg"><i class="fa fa-chevron-down"></i> Load more</a>--%>
                    <%--</p>--%>

                    <%--<ul class="pagination">--%>
                        <%--<li><a href="#">&laquo;</a>--%>
                        <%--</li>--%>
                        <%--<li class="active"><a href="#">1</a>--%>
                        <%--</li>--%>
                        <%--<li><a href="#">2</a>--%>
                        <%--</li>--%>
                        <%--<li><a href="#">3</a>--%>
                        <%--</li>--%>
                        <%--<li><a href="#">4</a>--%>
                        <%--</li>--%>
                        <%--<li><a href="#">5</a>--%>
                        <%--</li>--%>
                        <%--<li><a href="#">&raquo;</a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>


            </div>
            <!-- /.col-md-9 -->
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
                <p class="pull-right">Template by <a
                        href="https://bootstrapious.com/e-commerce-templates">Bootstrapious</a> & <a
                        href="https://fity.cz">Fity</a>
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
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/bootstrap-hover-dropdown.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/front.js"></script>


</body>

</html>