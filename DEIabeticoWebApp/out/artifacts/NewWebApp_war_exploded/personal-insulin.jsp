<%@ page import="voter.AllVoterValues" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
                <a class="navbar-brand" href="index.jsp">DEIabetes</a>
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

        <!-- Portfolio Item Heading -->
            <%AllVoterValues.clear();%>
        <div class="row">
            <div class="col-lg-12">
                 <h1 class="page-header">Mealtime insulin dose - personal insulin sensitivity</h1>
            </div>
        </div>
        <!-- /.row -->

        <!-- Portfolio Item Row -->
        <div class="row">

         <div class="container">
        <div class="col-md-4">
            <form class="form-group" action="PersonalInsulin" method="post">
                <div class="form-group">
                    <label>Amount of carbohydrates in the meal (g)</label>
                    <input class="form-control" name="carbsInMeal">

                    <label>Carbohydrates processes by 1 unit of rapid acting insulin (g)</label>
                    <select name="carbsRatio" class="form-control">
                        <option value="12">12</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                    </select>

                    <label>Actual blood sugar level (before the meal)</label>
                    <input class="form-control" name="bloodSugarLevel">

                    <label>Target blood sugar (before the meal)</label>
                    <input class="form-control" name="targetBloodSugar">

                    <label>Today's physical activity level</label>
                    <select name="physicalAct" class="form-control">
                          <option value="0">0 (no activity)</option>
                          <option value="1">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                          <option value="4">4</option>
                          <option value="5">5</option>
	                      <option value="6">6</option>
	                      <option value="7">7</option>
	                      <option value="8">8</option>
	                      <option value="9">9</option>
	                      <option value="10">10 (high activity)</option>
                    </select>

                    <label>Samples of physical activity</label>

                    <div class="input_fields_wrap">
                        <button class="add_field_button">Add More Fields</button>
                        <div><select name="physicalSamples" class="form-control">
                            <option value="0">0 (no activity)</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10 (high activity)</option>
                        </select></div>
                    </div>

                    <label>Samples of drops in blood sugar</label>
                    <div class="input_fields_wrap2">
                        <button class="add_field_button2">Add More Fields</button>
                        <div><input class="form-control" name="bloodSample"></div>
                    </div>

                </div>
                <button type="submit" class="btn btn-primary btn-lg">Calculate insulin dose</button>
            </form>
        </div>


        </div>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>