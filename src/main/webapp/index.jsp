<!DOCTYPE html>
<html lang="en">

<head>
    <%@page session="true" %>
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
    <script src="js/jquery-1.11.0.min.js"></script>

        <script src="js/respond.min.js"></script>

        <!--Ajax Script-->
        <script src="js/myJs/loginScript.js"></script>

        <link rel="shortcut icon" href="favicon.png">

    <!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
    <%--<script src="js/jquery-1.11.0.min.js"></script>--%>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/myJs/cartHandleScript.js"></script>
    <script src="js/myJs/loadProductScript.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.cookie.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/modernizr.js"></script>
    <script src="js/bootstrap-hover-dropdown.js"></script>
    <script src="js/front.js"></script>




</head>

<body onload="loadProducts()">
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
</div><!-- /.modal -->
    <!-- *** TOPBAR ***
 _________________________________________________________ -->
    <%--<div id="top">--%>
        <%--<div class="container">--%>

            <%--<div class="col-md-6" data-animate="fadeInDown" style="margin-left: 5%">--%>
                <%--<ul class="menu" style="float: right;z-index: 10">--%>
                    <%--<li>--%>
                        <%--<a href="#" data-toggle="modal" data-target="#login-modal">Login</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="register.jsp">Register</a>--%>
                    <%--</li>--%>

                <%--</ul>--%>
            <%--</div>--%>

        <%--</div>--%>
        <%--<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">--%>
            <%--<div class="modal-dialog modal-sm">--%>

                <%--<div class="modal-content">--%>
                    <%--<div class="modal-header">--%>
                        <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
                        <%--<h4 class="modal-title" id="Login">Customer login</h4>--%>
                    <%--</div>--%>
                    <%--<div class="modal-body">--%>
                        <%--<!--Login Part -->--%>
                        <%--<form onsubmit="return loginHandler()" method="post">--%>
                            <%--<div class="form-group">--%>
                                <%--<input type="email" class="form-control" id="email-modal" placeholder="email">--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<input type="password" class="form-control" id="password-modal" placeholder="password">--%>
                            <%--</div>--%>
                            <%--<p style="color: red" id="errorMsg"></p>--%>
                            <%--<p class="text-center">--%>
                                <%--<button type="submit" class="btn btn-primary" id="loginBtn">--%>
                                    <%--<i class="fa fa-sign-in"></i> Log in</button>--%>
                            <%--</p>--%>

                        <%--</form>--%>
                        <%--<p class="text-center text-muted">Not registered yet?</p>--%>
                        <%--<p class="text-center text-muted">--%>
                            <%--<a href="register.jsp">--%>
                                <%--<strong>Register now</strong>--%>
                            <%--</a>! It is easy and done in 1&nbsp;minute and gives you access to special discounts and much more!</p>--%>

                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

    <%--</div>--%>

    <%--<!-- *** TOP BAR END *** -->--%>

    <%--<!-- *** NAVBAR ***--%>
 <%--_________________________________________________________ -->--%>

    <%--<div class="navbar navbar-default yamm" role="navigation" id="navbar">--%>
        <%--<div class="container">--%>
            <%--<div class="navbar-header">--%>

                <%--<a class="navbar-brand home" href="index.jsp" data-animate-hover="bounce">--%>
                    <%--<img src="img/logo.png" alt="Obaju logo" class="hidden-xs">--%>
                    <%--<img src="img/logo-small.png" alt="Obaju logo" class="visible-xs">--%>
                    <%--<span class="sr-only">Obaju - go to homepage</span>--%>
                <%--</a>--%>
                <%--<div class="navbar-buttons">--%>
                    <%--<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation">--%>
                        <%--<span class="sr-only">Toggle navigation</span>--%>
                        <%--<i class="fa fa-align-justify"></i>--%>
                    <%--</button>--%>
                    <%--<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#search">--%>
                        <%--<span class="sr-only">Toggle search</span>--%>
                        <%--<i class="fa fa-search"></i>--%>
                    <%--</button>--%>
                    <%--<a class="btn btn-default navbar-toggle" href="basket.jsp">--%>
                        <%--<i class="fa fa-shopping-cart"></i>--%>
                        <%--<span class="hidden-xs">3 items in cart</span>--%>
                    <%--</a>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<!--/.navbar-header -->--%>

            <%--<div class="navbar-collapse collapse" id="navigation">--%>

                <%--<ul class="nav navbar-nav navbar-left">--%>
                    <%--<li class="active">--%>
                        <%--<a href="index.jsp">Home</a>--%>
                    <%--</li>--%>

                    <%--<li class="dropdown yamm-fw">--%>
                        <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="200">Categories--%>
                            <%--<b class="caret"></b>--%>
                        <%--</a>--%>
                        <%--<ul class="dropdown-menu">--%>
                            <%--<li>--%>
                                <%--<div class="yamm-content">--%>
                                    <%--<div class="row">--%>
                                        <%--<div class="col-sm-3">--%>
                                            <%--<h5>Clothing</h5>--%>
                                            <%--<ul>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">T-shirts</a>--%>
                                                <%--</li>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">Shirts</a>--%>
                                                <%--</li>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">Pants</a>--%>
                                                <%--</li>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">Accessories</a>--%>
                                                <%--</li>--%>
                                            <%--</ul>--%>
                                        <%--</div>--%>
                                        <%--<div class="col-sm-3">--%>
                                            <%--<h5>Shoes</h5>--%>
                                            <%--<ul>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">Trainers</a>--%>
                                                <%--</li>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">Sandals</a>--%>
                                                <%--</li>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">Hiking shoes</a>--%>
                                                <%--</li>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">Casual</a>--%>
                                                <%--</li>--%>
                                            <%--</ul>--%>
                                        <%--</div>--%>
                                        <%--<div class="col-sm-3">--%>
                                            <%--<h5>Accessories</h5>--%>
                                            <%--<ul>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">Trainers</a>--%>
                                                <%--</li>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">Sandals</a>--%>
                                                <%--</li>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">Hiking shoes</a>--%>
                                                <%--</li>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">Casual</a>--%>
                                                <%--</li>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">Hiking shoes</a>--%>
                                                <%--</li>--%>
                                                <%--<li>--%>
                                                    <%--<a href="category.html">Casual</a>--%>
                                                <%--</li>--%>
                                            <%--</ul>--%>

                                        <%--</div>--%>

                                    <%--</div>--%>
                                <%--</div>--%>
                                <%--<!-- /.yamm-content -->--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>


                <%--</ul>--%>
            <%--</div>--%>
            <%--<!--/.nav-collapse -->--%>

            <%--<div class="navbar-buttons">--%>

                <%--<div class="navbar-collapse collapse right" id="basket-overview">--%>
                    <%--<a href="#" data-toggle="modal" data-target="#login-modal" class="btn btn-primary navbar-btn">--%>
                        <%--<i class="fa fa-shopping-cart"></i>--%>
                        <%--<span class="hidden-sm">items in cart</span>--%>
                    <%--</a>--%>
                <%--</div>--%>
                <%--<!--/.nav-collapse -->--%>

                <%--<div class="navbar-collapse collapse right" id="search-not-mobile">--%>
                    <%--<button type="button" class="btn navbar-btn btn-primary" data-toggle="collapse" data-target="#search">--%>
                        <%--<span class="sr-only">Toggle search</span>--%>
                        <%--<i class="fa fa-search"></i>--%>
                    <%--</button>--%>
                <%--</div>--%>

            <%--</div>--%>

            <%--<div class="collapse clearfix" id="search">--%>

                <%--<form class="navbar-form" role="search">--%>
                    <%--<div class="input-group">--%>
                        <%--<input type="text" class="form-control" placeholder="Search">--%>
                        <%--<span class="input-group-btn">--%>

                            <%--<button type="submit" class="btn btn-primary">--%>
                                <%--<i class="fa fa-search"></i>--%>
                            <%--</button>--%>

                        <%--</span>--%>
                    <%--</div>--%>
                <%--</form>--%>

            <%--</div>--%>
            <%--<!--/.nav-collapse -->--%>

        <%--</div>--%>
        <%--<!-- /.container -->--%>
    <%--</div>--%>
    <%--<!-- /#navbar -->--%>

    <%--<!-- *** NAVBAR END *** -->--%>
<jsp:include page="/head.jsp"/>


    <div id="all">

        <div id="content">

            <div class="container">
                <div class="col-md-12">
                    <div id="main-slider">
                        <div class="item">
                            <img src="img/main-slider1.jpg" alt="" class="img-responsive">
                        </div>
                        <div class="item">
                            <img class="img-responsive" src="img/main-slider2.jpg" alt="">
                        </div>
                        <div class="item">
                            <img class="img-responsive" src="img/main-slider3.jpg" alt="">
                        </div>
                        <div class="item">
                            <img class="img-responsive" src="img/main-slider4.jpg" alt="">
                        </div>
                    </div>
                    <!-- /#main-slider -->
                </div>
            </div>
            <hr>
            <!--Start Product -->
            <div id="hot">


            </div>
            <!--End Product-->
            <div id="footer" data-animate="fadeInUp">

                <div class="container">

                    <div class="row" style="margin-left: 40%;">

                        <div class="col-md-3 col-sm-6">

                            <h4>User section</h4>

                            <ul>
                                <li>
                                    <a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                                </li>
                                <li>
                                    <a href="register.jsp">Regiter</a>
                                </li>
                            </ul>

                            <hr class="hidden-md hidden-lg hidden-sm">

                        </div>
                        <!-- /.col-md-3 -->

                        <div class="col-md-3 col-sm-6">

                            <h4>Categories</h4>



                            <ul>
                                <li>
                                    <a href="category.html">T-shirts</a>
                                </li>
                                <li>
                                    <a href="category.html">Skirts</a>
                                </li>
                                <li>
                                    <a href="category.html">Pants</a>
                                </li>
                                <li>
                                    <a href="category.html">Accessories</a>
                                </li>
                            </ul>

                            <hr class="hidden-md hidden-lg">

                        </div>
                        <!-- /.col-md-3 -->



                    </div>
                    <!-- /.col-md-3 -->

                </div>
                <!-- /.row -->

            </div>
            <!-- /.container -->

        </div>

        <!-- /#footer -->

        <!-- *** FOOTER END *** -->




        <!-- *** COPYRIGHT ***
 _________________________________________________________ -->
        <div id="copyright">
            <div class="container">
                <div class="col-md-6">
                    <p class="pull-left">© 2018 Asmaa Hasnaa Eman Fawzy Bassem </p>

                </div>
                <div class="col-md-6">
                    <p class="pull-right">Template by
                        <a href="https://bootstrapious.com/e-commerce-templates">Bootstrapious</a> &
                        <a href="https://fity.cz">Fity</a>
                        <!-- Not removing these links is part of the license conditions of the template. Thanks for understanding :) If you want to use the template without the attribution links, you can do so after supporting further themes development at https://bootstrapious.com/donate  -->
                    </p>
                </div>
            </div>
        </div>
        <!-- *** COPYRIGHT END *** -->



    </div>
    <!-- /#all -->





</body>

</html>