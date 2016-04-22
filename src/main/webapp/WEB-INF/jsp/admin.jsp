<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- CSS (load bootstrap) -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="./images/icon/meeting-icon.svg"/>

    <title>KnowledgeMeet | TOTHENEW-Digital</title>

    <!-- Bootstrap Core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <link href="./css/metisMenu.min.css" rel="stylesheet">

    <link href="./css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="./css/sb-admin-2.css" rel="stylesheet">

    <link href="./css/morris.css" rel="stylesheet">

    <link href="./css/font-awesome-4.3.0/css/font-awesome.min.css"
          rel="stylesheet" type="text/css">
    <link
            href="./css/font-awesome-4.3.0/css/font-awesome-animation.min.css?comiple=false"
            rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="./css/typeahead.min.css">
    <link rel="stylesheet" href="./css/custom/common.css">
    <link rel="stylesheet" href="./css/ng-notify.css">
    <style>
        .navbar {
            border-radius: 0;
        }
    </style>
    <link rel="stylesheet"
          href="./css/angular-material/angular-material.min.css">
    <link rel="stylesheet" href="./css/jquery.datetimepicker.css">


    <!-- <link rel="stylesheet"
        href="./css/datetime-picker/jquery.datetimepicker.css"> -->

    <!-- JS (load angular, ui-router, and our custom js file) -->
    <script src="./app/angular.min.js"></script>
    <script src="./app/angular-ui-router.js"></script>

    <script src="./js/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="./js/bootstrap.min.js"></script>

    <!-- <script src="./js/datetime-picker/jquery.datetimepicker.full.js"></script> -->

    <script src="js/jquery.datetimepicker.full.js" type="text/javascript"></script>

    <script src="./js/metisMenu.min.js"></script>

    <script src="./js/raphael-min.js"></script>
    <script src="./js/morris.min.js"></script>

    <!-- <script src="./js/typeahead.min.js"></script> -->

    <script type="text/javascript" src="./js/cookie/jquery.cookie.js"></script>
    <script src="./js/sb-admin-2.js"></script>
    <script src="./app/angular.min.js"></script>
    <script src="./app/angular-ui-router.js"></script>

    <!-- used for typeahead -->
    <script src="./js/ui-bootstrap-tpls-0.14.3.js"></script>
    <script src="./js/ng-notify.js"></script>

    <script src="./app/app.js"></script>


    <script src="./js/angular-material/angular-animate.min.js"></script>
    <script src="./js/angular-material/angular-aria.min.js"></script>
    <script src="./js/angular-material/angular-messages.min.js"></script>

    <!-- Angular Material Library -->
    <script src="./js/angular-material/angular-material.min.js"></script>


    <script src="./app/components/topic/topicController.js"></script>
    <script src="./app/components/dashboard/dashboardController.js"></script>
    <script src="./app/components/schedule/scheduleController.js"></script>
    <script src="./app/components/paper/paperController.js"></script>
    <script src="./app/components/session/sessionController.js"></script>
    <script src="./app/components/session/sessionService.js"></script>
    <script src="./app/components/paper/paperService.js"></script>
    <script src="./app/components/topic/topicService.js"></script>
    <script src="./app/components/dashboard/dashboardService.js"></script>
    <script src="./app/components/schedule/scheduleService.js"></script>
    <script src="./app/components/login/loginService.js"></script>
    <script src="./app/components/login/loginController.js"></script>
    <script src="./app/filter/filter.js"></script>
    <script src="./app/directive/directive.js"></script>

    <script src="./js/custom/common.js"></script>


    <link rel="stylesheet" href="./css/textEditor/textEditor.css" type="text/css">

    <script src='./js/textEditor/textAngular-rangy.min.js'></script>

    <script src='./js/textEditor/textAngular-sanitize.min.js'></script>

    <script src='./js/textEditor/textAngular.min.js'></script>
</head>

<!-- apply our angular app to our site -->
<body ng-app="intellimeetApp">

<nav class="navbar navbar-default navbar-static-top" role="navigation"
     style="margin-bottom: 0">
    <div class="navbar-header">
        <button class="navbar-toggle" data-target=".navbar-collapse"
                data-toggle="collapse" type="button">
            <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
            <span class="icon-bar"></span> <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand fa fa-users" href="">&nbsp;&nbsp;Knowledge Meet</a>
    </div>

    <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown"><a class="dropdown-toggle"
                                data-toggle="dropdown" href="#">${username}</a></li>

        <li class="dropdown"><a class="dropdown-toggle"
                                data-toggle="dropdown" href=""> <i class="fa fa-user fa-fw"></i>
            <i class="fa fa-caret-down"></i>
        </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="#/resetPassword"><i class="fa fa-lock fa-fw"></i> Change Password</a></li>
                <li class="divider"></li>
                <li><a href="/logout"><i class="fa fa-sign-out fa-fw"></i>
                    Logout</a></li>
            </ul>
            </a>
        </li>
    </ul>

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">

                <li><a href="#/dashboard"><i class="fa fa-dashboard fa-fw "></i>
                    Dashboard</a></li>

                <li><a href="#/sessions"><i class="fa fa-table fa-fw"></i>
                    Session</a></li>
                <li><a href="#/topics"><i class="fa fa-edit fa-fw"></i>
                    Topic</a></li>
                <li><a href="#/paper"><i class="fa fa-newspaper-o "></i>
                    Paper</a></li>
                <li><a href="#/schedule"><i class="fa fa-clock-o "></i>
                    Schedule</a></li>

            </ul>
        </div>
    </div>
</nav>

<div id="page-wrapper">
    <div ui-view></div>

</div>
</body>
</html>
