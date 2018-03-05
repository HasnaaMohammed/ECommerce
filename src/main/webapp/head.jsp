<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<head>
    <%--<script src="js/jquery-1.11.0.min.js"></script>--%>
        <script src="js/myJs/loginScript.js"></script>
        <script src="js/myJs/header.js"></script>
</head>
<body>

<div id="top">
    <div class="container">

        <div class="col-md-6" data-animate="fadeInDown" style="margin-left: 5%">
            <ul class="menu" style="float: right;z-index: 10">
                <li>
                    <a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                </li>
                <li>
                    <a href="register.jsp">Register</a>
                </li>

            </ul>
        </div>

    </div>
    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
        <div class="modal-dialog modal-sm">

            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="Login">Customer login</h4>
                </div>
                <div class="modal-body">
                    <!--Login Part -->
                    <form onsubmit="return loginHandler()" method="post">
                        <div class="form-group">
                            <input type="email" class="form-control" id="email-modal" placeholder="email">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="password-modal" placeholder="password">
                        </div>
                        <p style="color: red" id="errorMsg"></p>
                        <p class="text-center">
                            <button type="submit" class="btn btn-primary" id="loginBtn">
                                <i class="fa fa-sign-in"></i> Log in
                            </button>
                        </p>

                    </form>
                    <p class="text-center text-muted">Not registered yet?</p>
                    <p class="text-center text-muted">
                        <a href="register.jsp">
                            <strong>Register now</strong>
                        </a>! It is easy and done in 1&nbsp;minute and gives you access to special discounts and much
                        more!</p>

                </div>
            </div>
        </div>
    </div>

</div>

<!-- *** TOP BAR END *** -->

<!-- *** NAVBAR ***
_________________________________________________________ -->

<div class="navbar navbar-default yamm" role="navigation" id="navbar">
    <div class="container">
        <div class="navbar-header">

            <a class="navbar-brand home" href="index.jsp" data-animate-hover="bounce">
                <img src="img/logo.png" alt="Obaju logo" class="hidden-xs">
                <img src="img/logo-small.png" alt="Obaju logo" class="visible-xs">
                <span class="sr-only">Obaju - go to homepage</span>
            </a>
            <div class="navbar-buttons">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation">
                    <span class="sr-only">Toggle navigation</span>
                    <i class="fa fa-align-justify"></i>
                </button>
                <a class="btn btn-default navbar-toggle" href="basket.jsp">
                    <i class="fa fa-shopping-cart"></i>
                    <span class="hidden-xs">items in cart</span>
                </a>
            </div>
        </div>
        <!--/.navbar-header -->

        <div class="navbar-collapse collapse" id="navigation">

            <ul class="nav navbar-nav navbar-left">
                <li class="active">
                    <a href="index.jsp">Home</a>
                </li>

                <li class="dropdown ">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="200">Categories
                        <b class="caret"></b>
                    </a>

                    <ul id="categoryList" class="dropdown-menu">
                    </ul>
                </li>


            </ul>
        </div>
        <!--/.nav-collapse -->

        <div class="navbar-buttons">

            <div class="navbar-collapse collapse right" id="basket-overview">
                <a href="#" data-toggle="modal" data-target="#login-modal" class="btn btn-primary navbar-btn">
                    <i class="fa fa-shopping-cart"></i>
                    <span class="hidden-sm">${fn:length(sessionScope.cartProductList)}&nbspitems in cart</span>
                </a>
            </div>
            <!--/.nav-collapse -->

            <div class="navbar-collapse collapse right" id="search-not-mobile">
                <button type="button" class="btn navbar-btn btn-primary" data-toggle="collapse" data-target="#search">
                    <span class="sr-only">Toggle search</span>
                    <i class="fa fa-search"></i>
                </button>
            </div>

        </div>

        <div class="collapse clearfix" id="search">

            <form class="navbar-form" role="search">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-btn">

<button type="submit" class="btn btn-primary">
<i class="fa fa-search"></i>
</button>

</span>
                </div>
            </form>

        </div>
        <!--/.nav-collapse -->

    </div>
    <!-- /.container -->
</div>
<!-- /#navbar -->
</body>