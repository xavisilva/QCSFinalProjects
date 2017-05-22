<%--
  Created by IntelliJ IDEA.
  User: xaviersilva
  Date: 06/04/17
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>DEIabetes</title>

  <!-- Bootstrap Core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="css/portfolio-item.css" rel="stylesheet">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->


</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">DEIabetes</a>
    </div>
  </div>
  <!-- /.navbar-collapse -->
  </div>
  <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

  <!-- Portfolio Item Heading -->
  <div class="row">
    <div class="col-lg-12">
      <h1 class="page-header"><center>Welcome to DEIabetes<br>
        <small>Your life saving platform</small></center>
      </h1>
    </div>
  </div>
  <!-- /.row -->

  <!-- Portfolio Item Row -->
  <div class="row">
    <center>
      <h3>Please choose an option</h3>
      <a href="standard-insulin.jsp"><button class="btn btn-primary btn-lg">Mealtime insulin dose - standard insulin sensitivity</button ></a>
    </center>
    <p></p>
  </div>

  <div class="row">
    <center>
      <a href="personal-insulin.jsp"><button class="btn btn-primary btn-lg">Mealtime insulin dose - personal insulin sensitivity</button ></a>
      <p></p>
    </center>
  </div>

  <div class="row">
    <center>
      <a href="background-insulin.jsp"><button class="btn btn-primary btn-lg">Background insulin dose</button ></a>
    </center>
  </div>

</div>

  <!-- jQuery -->
  <script src="js/jquery.js"></script>

  <!-- Bootstrap Core JavaScript -->
  <script src="js/bootstrap.min.js"></script>

</body>


</html>
