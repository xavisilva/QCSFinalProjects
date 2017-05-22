<%--
  Created by IntelliJ IDEA.
  User: xaviersilva
  Date: 06/04/17
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="voter.AllVoterValues" %>


<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DEIabetes</title>

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/portfolio-item.css" rel="stylesheet">

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
            <a class="navbar-brand" href="index.html">DEIabetes</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <!--<li>
                    <a href="#">Services</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>-->
            </ul>

        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

    <!-- Portfolio Item Row -->
    <div class="row">

        <div class="col-lg-12">
            <center>
                <h1 class="page-header">Techincal Information<br>
                    <small>All the information about he insulin dose calculations</small>
                </h1>
            </center>
        </div>
    </div>

    <!-- Portfolio Item Row -->
    <div class="row">

        <div class="container">
            <div class="col-md-12">
                <ol>
                    <h3><li>Number of webservices used in the calculation: <%=AllVoterValues.getNumberOfVersions()%> </li></h3>
                    <h3><li>Result calculated by each web service version</li></h3>
                    <% for(int i = 0; i < AllVoterValues.getVoterValues().size(); i+=1) { %>
                    <p><b>Voter <%=i+1%> result:</b> <%=AllVoterValues.getVoterValues().get(i)%></p>
                    <% } %>
                    <% AllVoterValues.clear();%>
                    <h3><li>Majority result: <%=AllVoterValues.getMajorityResult()%></li></h3>
                </ol>

            </div>

        </div>
    </div>

    <div class="row">
        <center>
            <a href="index.jsp"><button class="btn btn-primary btn-lg">Go back</button ></a>
        </center>

    </div>



    <!-- jQuery -->
    <script src="../js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>

</body>

</html>

