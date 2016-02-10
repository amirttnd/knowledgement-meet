<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- SEO -->
    <meta name="author" content="Surjith S M">
    <meta name="description"
          content="Gather is a responsive Template for Events, Meetups, Conference and other gatherings.">
    <meta name="keywords" content="gather, responsive, event, meetup, template, conference, gather, rsvp, download">


    <!-- Favicons -->
    <link rel="shortcut icon" href="./images/icon/meeting-icon.svg"/>

    <!-- Page Title -->
    <title>KnowledgeMeet | TOTHENEW-Digital</title>

    <%--Angular js--%>
    <script src="./app/angular.min.js"></script>
    <script src="./app/angular-ui-router.js"></script>
    <%--<script src="./app/app.js"></script>--%>
    <script src="./app/components/home/homeController.js"></script>
    <script src="./app/components/schedule/scheduleService.js"></script>
    <script src="./app/components/dashboard/dashboardService.js"></script>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Google Font : Open Sans & Montserrat -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300,600' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>

    <!-- Plugins -->
    <link href="css/plugins/animate.css" rel="stylesheet">
    <link href="css/plugins/slick.css" rel="stylesheet">
    <link href="css/plugins/magnific-popup.css" rel="stylesheet">
    <link href="./css/font-awesome-4.3.0/css/font-awesome.min.css"
          rel="stylesheet" type="text/css">
    <link href="css/plugins/streamline-icons.css" rel="stylesheet">

    <!-- Event Style -->
    <link href="css/event.css" rel="stylesheet">

    <!-- Color Theme -->
    <!-- Options: green, purple, red, yellow, mint, blue, black  -->
    <link href="css/themes/red.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>

    <script src="js/ie/respond.min.js"></script>
    <![endif]-->

    <!-- Modernizr -->
    <script src="js/modernizr.min.js"></script>
    <!-- Subtle Loading bar -->
    <script src="js/plugins/pace.js"></script>
    <style type="text/css">
        .speaker-slider img {
            height: 130px;
            width: 130px;
        }

        .no-round {
            border-radius: 0% !important;
        }

        .navbar-logo {
            border: 3px solid #999;
            padding: 5px 10px;
            font-weight: bold;
            color: #999;
            font-size: 24px;
        }

    </style>

</head>

<body class="animate-page" data-spy="scroll" data-target="#navbar" data-offset="100">
<!--Preloader div-->

<div ng-app="intellimeetWeb" ng-controller="HomeController as home" ng-init="home.init()">
    <div class="preloader"></div>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top reveal-menu js-reveal-menu reveal-menu-hidden">
        <div class="container">
            <div class="navbar-header">
                <!-- <a class="navbar-brand" href="#"><img src="images/event-logo-dark.png" alt="Gather"> </a> -->
                <a class="navbar-brand navbar-logo" href="#">KnowledgeMeet</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="#top">Home</a></li>
                    <li><a href="#sessions">Sessions</a></li>
                    <li><a href="#schedule">Schedule</a></li>
                    <li><a href="#gallery">Gallery</a></li>
                    <li><a href="#faq">FAQ's</a></li>
                    <li><a href="#highlight">Contact</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </nav>
    <!-- // End Fixed navbar -->

    <header id="top" class="header">
        <div class="container">

            <div class="header_top-bg">
                <div class="logo">
                    <h3 style="border:4px solid #fff; display:inline-block; padding:5px 10px;"
                        class="headline-support wow fadeInDown">KnowledgeMeet</h3>
                    <!-- <a href="#" class="headline-support wow fadeInDown">IntelliMeet</a> -->
                </div>
            </div>

            <h3 class="headline-support wow fadeInDown">A Knowledge Sharing Quest</h3>

            <h1 class="headline wow fadeInDown" data-wow-delay="0.1s">LEARN. SHARE. INSPIRE. </h1>

            <div class="when_where wow fadeIn" data-wow-delay="0.4s">
                <p class="event_when">{{home.intellimeetDay}}</p>

                <p class="event_where">Logix Techno Park, Sec-127, Noida</p>
            </div>

            <div class="header_bottom-bg">
                <a class="btn btn-default btn-xl" data-wow-delay="0.3s" href="http://www.tothenew.com">TO THE NEW
                    Digital</a>

                <p class="cta_urgency">
                    <small>A Premium Digital Services Company</small>
                </p>
            </div>

        </div>
        <!-- end .container -->
    </header>
    <!-- end .header -->

    <!--
     Highlight Section
     ====================================== -->

    <section class="highlight">

        <div class="container">
            <p class="lead text-center">
                This proposal aims at detecting <b>the key forces</b> in a Knowledge Sharing network. We made the design
                of
                the canvas to be memorable, easy to draw, recognizable and helpful regarding writing answers on it,
                within any kind of technological and cultural environment.
                We can't wait on your feedback. We hope it will complete the tools you use to design, forecast, decide,
                excell.
            </p>

            <div class="countdown_wrap">

                <h6 class="countdown_title text-center">EVENT WILL START IN</h6>

                <!-- Countdown JS for the Event Date Starts here.
    TIP: You can change your event time below in the Same Format.  -->
                <ul id="countdown" data-event-date="">
                    <li class="wow zoomIn" data-wow-delay="0s"><span class="days">{{home.days}}</span>

                        <p class="timeRefDays">days</p>
                    </li>
                    <li class="wow zoomIn" data-wow-delay="0.2s"><span class="hours">{{home.hours}}</span>

                        <p class="timeRefHours">hours</p>
                    </li>
                    <li class="wow zoomIn" data-wow-delay="0.4s"><span class="minutes">{{home.minutes}}</span>

                        <p class="timeRefMinutes">minutes</p>
                    </li>
                    <li class="wow zoomIn" data-wow-delay="0.6s"><span class="seconds">{{home.seconds}}</span>

                        <p class="timeRefSeconds">seconds</p>
                    </li>
                </ul>
            </div>
            <!-- end .countdown_wrap -->

            <div class="text-center">

                <!-- Add to Calendar Plugin.
                     For Customization, Visit https://addtocalendar.com/ -->

                <span class="addtocalendar atc-style-theme">
                <a class="atcb-link"><i class="fa fa-calendar"> </i> Add to My Calendar</a>
                  <var class="atc_event">
                      <var class="atc_date_start">2015-09-26 09:30:00</var>
                      <var class="atc_date_end">2015-09-26 17:30:00</var>
                      <var class="atc_timezone">Asia/Kolkata</var>
                      <var class="atc_title">KnowledgeMeet</var>
                      <var class="atc_description">Knowledge Sharing Session</var>
                      <var class="atc_location">Logix Techno Park, Sec-127, Noida</var>
                      <var class="atc_organizer">KnowledgeMeet Team</var>
                      <var class="atc_organizer_email">tech-grails-intellimeet-team@tothenew.com</var>
                  </var>
               </span>

            </div>

        </div>
        <!-- end .container -->

    </section>
    <!-- end section.highlight -->

    <!--
     Our Speakers
     ====================================== -->


    <section class="sessions" id="sessions">
        <div class="container">

            <div class="section-title wow fadeInUp">
                <h4>OUR SESSIONS</h4>
            </div>

            <div class="speaker-slider">

                <div ng-repeat="session in home.lastIntellimeet.sessions" class="speaker-info wow fadeIn col-sm-3"
                     data-wow-delay="0s" style="height: 260px">
                    <a href="" ng-click="home.showAgenda(session)" data-toggle="modal" data-target="#myModal">
                        <img src="{{session.paper.topic.imageSrc}}" alt="avatar"
                             class="img-responsive center-block no-round">
                    </a>

                    <p> {{session.paper.topic.name}}</p>
                    <span ng-repeat="presenter in session.presenters">{{presenter}} <br></span>
                </div>

                <!-- end .speaker-info -->
            </div>
        </div>
        <!-- end .container -->
    </section>
    <!-- end section.speakers -->


    <div class="container">

        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">
                            <img src="{{home.imageSrc}}" height="32px" width="32px">
                            {{home.topic}}
                        </h4>
                    </div>
                    <div class="modal-body">
                        <h6>Agenda</h6>
                        <blockquote>{{home.agenda}}</blockquote>
                        <h6>Schedule</h6>
                        <blockquote>
                            <small> Session Commencement : {{home.schedule.sessionCommencement}}</small>
                            <small> Lunch Timing : {{home.schedule.lunch}}</small>
                            <small> Wrap Up : {{home.schedule.wrapUp}}</small>
                        </blockquote>
                    </div>


                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>

    </div>


    <!--
     Our Schedule
     ====================================== -->

    <section class="schedule" id="schedule">

        <div class="container">
            <div class="section-title wow fadeInUp">
                <h4>FULL DAY SCHEDULE</h4>
            </div>

            <div class="nav-center">
                <!-- Nav tabs -->
                <ul class="nav nav-pills" role="tablist" id="schedule-tabs">
                    <li role="presentation" class="active"><a href="#day1" aria-controls="day1" role="tab"
                                                              data-toggle="tab">{{home.intellimeetDay}}</a></li>
                </ul>

            </div>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="day1">

                    <!-- ########## Schedule Timeline DAY 01 Starts ########### -->

                    <section class="timeline">
                        <div class="timeline-block">
                            <div class="timeline-bullet wow zoomIn" data-wow-delay="0s">

                            </div>
                            <!-- timeline-bullet -->

                            <div class="timeline-content">
                                <h2 class="wow flipInX" data-wow-delay="0.3s"> Breakfast</h2>
                                <span class="date wow flipInX" data-wow-delay="0.3s"
                                      ng-model="home.breakFast">{{home.breakFast}}</span>
                            </div>
                            <!-- timeline-content -->
                        </div>
                        <!-- timeline-block -->

                        <div class="timeline-block">
                            <div class="timeline-bullet wow zoomIn" data-wow-delay="0s">

                            </div>
                            <!-- timeline-bullet -->

                            <div class="timeline-content">
                                <h2 class="wow flipInX" data-wow-delay="0.3s"> Session Commencement</h2>

                                <%--<p class="wow flipInX" data-wow-delay="0.3s">All</p>--%>
                                <span class="date wow flipInX" data-wow-delay="0.3s">{{home.sessionCommencement}}</span>
                            </div>
                            <!-- timeline-content -->
                        </div>
                        <!-- timeline-block -->

                        <div class="timeline-block">
                            <div class="timeline-bullet wow zoomIn" data-wow-delay="0s">

                            </div>
                            <!-- timeline-bullet -->

                            <div class="timeline-content">
                                <h2 class="wow flipInX" data-wow-delay="0.3s"> Lunch</h2>
                                <span class="date wow flipInX" data-wow-delay="0.3s">
                                <span ng-repeat="lunch in home.lunch track by $index">
                                    <i class="fa fa-clock-o"></i> {{lunch}}<br>
                                </span>
                                <span class="label label-warning" ng-show="home.lunch.length>0"> +45 min according to your schedule.</span>

                                </span>
                            </div>
                            <!-- timeline-content -->
                        </div>
                        <!-- timeline-block -->
                        <div class="timeline-block">
                            <div class="timeline-bullet wow zoomIn" data-wow-delay="0s">

                            </div>
                            <!-- timeline-bullet -->

                            <div class="timeline-content">
                                <h2 class="wow flipInX" data-wow-delay="0.3s"> Discussions &amp; Feedbacks</h2>

                                <%--<p class="wow flipInX" data-wow-delay="0.3s">Intra Session</p>--%>
                                <span class="date wow flipInX"
                                      data-wow-delay="0.3s">{{home.discussionAndFeedback}}</span>
                            </div>
                            <!-- timeline-content -->
                        </div>
                        <!-- timeline-block -->
                        <div class="timeline-block">
                            <div class="timeline-bullet wow zoomIn" data-wow-delay="0s">

                            </div>
                            <!-- timeline-bullet -->

                            <div class="timeline-content">
                                <h2 class="wow flipInX" data-wow-delay="0.3s"> Wrap Up</h2>

                                <%--<p class="wow flipInX" data-wow-delay="0.3s">All Sessions </p>--%>
                                <span class="date wow flipInX" data-wow-delay="0.3s">{{home.wrapUp}}</span>
                            </div>
                            <!-- timeline-content -->
                        </div>
                        <!-- timeline-block -->
                    </section>
                    <!-- timeline -->

                    <!-- ########### End Schedule Timeline  DAY 01  ########### -->

                </div>
                <!-- <div role="tabpanel" class="tab-pane" id="day2">..22222.</div> -->
                <!-- <div role="tabpanel" class="tab-pane" id="day3">..33333.</div> -->
            </div>

        </div>
        <!-- end .container -->

    </section>
    <!-- end section.schedule -->

    <!--
     Embeded Twitter Testimonials
     ====================================== -->

    <section class="embed_twitter">

        <div class="container">
            <div class="section-title wow fadeInUp">
                <h4>WHAT PEOPLE SAY</h4>

                <p>They love it. Read what the previous attendees had to say!</p>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <div class="embed-tweet-item wow fadeInLeft">
                        <blockquote class="twitter-tweet" lang="en" data-width="550" data-link-color="#e44948"
                                    data-align="center">
                            <a href="https://twitter.com/manishkapoor_89/status/614812541047324673"></a>
                        </blockquote>
                    </div>
                    <!-- end .embed-tweet-item -->
                </div>

                <!-- end .col -->
                <div class="col-md-4">
                    <div class="embed-tweet-item wow fadeInUp">
                        <blockquote class="twitter-tweet" data-cards="hidden" lang="en" data-width="550"
                                    data-link-color="#e44948" data-align="center">
                            <a href="https://twitter.com/farjinaarad/status/614697623199440896"></a>
                        </blockquote>
                    </div>
                    <!-- end .embed-tweet-item -->
                </div>
                <!-- end .col -->

                <div class="col-md-4">
                    <div class="embed-tweet-item wow fadeInRight">
                        <blockquote class="twitter-tweet" data-cards="hidden" lang="en" data-width="550"
                                    data-link-color="#e44948" data-align="center">
                            <a href="https://twitter.com/bhagwatkumar/status/571601797774630912"></a>
                        </blockquote>
                    </div>
                    <!-- end .embed-tweet-item -->
                </div>
                <!-- end .col -->
            </div>
            <!-- end .row -->

        </div>
        <!-- end .container -->
    </section>
    <!-- end section.sponsors -->

    <!--
     Gallery
     ====================================== -->

    <section class="gallery" id="gallery">
        <div class="container">
            <div class="section-title">
                <h4>GALLERY</h4>
            </div>

            <div class="nav-center bottom-space-lg">
                <!-- Nav tabs -->
                <ul class="nav nav-pills" role="tablist">
                    <li role="presentation" class="active"><a href="#photo-gallery" aria-controls="photo-gallery"
                                                              role="tab"
                                                              data-toggle="tab">Photos</a></li>
                </ul>

            </div>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="photo-gallery">

                    <div class="popup-gallery">

                        <div class="row">

                            <div class="col-md-6">
                                <div class="row">

                                    <div class="col-sm-6">
                                        <a href="images/session-img1.jpg" title=""><img src="images/session-img1.jpg"
                                                                                        alt="gallery image"
                                                                                        class="img-responsive wow fadeIn"
                                                                                        data-wow-delay="0.2s"></a>
                                    </div>

                                    <div class="col-sm-6">
                                        <a href="images/session-img2.jpg" title=""><img src="images/session-img2.jpg"
                                                                                        alt="gallery image"
                                                                                        class="img-responsive wow fadeIn"
                                                                                        data-wow-delay="0.2s"></a>
                                    </div>

                                </div>
                                <!-- end .row -->

                                <div class="row">

                                    <div class="col-sm-6">
                                        <a href="images/session-img3.jpg" title=""><img src="images/session-img3.jpg"
                                                                                        alt="gallery image"
                                                                                        class="img-responsive wow fadeIn"
                                                                                        data-wow-delay="0.4s"></a>
                                    </div>

                                    <div class="col-sm-6">
                                        <a href="images/session-img4.jpg" title=""><img src="images/session-img4.jpg"
                                                                                        alt="gallery image"
                                                                                        class="img-responsive wow fadeIn"
                                                                                        data-wow-delay="0.4s"></a>
                                    </div>

                                </div>
                                <!-- end .row -->

                            </div>

                            <div class="col-md-6">
                                <div class="row">

                                    <div class="col-sm-6">
                                        <a href="images/session-img5.jpg" title=""><img src="images/session-img5.jpg"
                                                                                        alt="gallery image"
                                                                                        class="img-responsive wow fadeIn"
                                                                                        data-wow-delay="0.2s"></a>
                                    </div>

                                    <div class="col-sm-6">
                                        <a href="images/session-img6.jpg" title=""><img src="images/session-img6.jpg"
                                                                                        alt="gallery image"
                                                                                        class="img-responsive wow fadeIn"
                                                                                        data-wow-delay="0.2s"></a>
                                    </div>

                                </div>
                                <!-- end .row -->

                                <div class="row">

                                    <div class="col-sm-6">
                                        <a href="images/session-img7.jpg" title=""><img src="images/session-img7.jpg"
                                                                                        alt="gallery image"
                                                                                        class="img-responsive wow fadeIn"
                                                                                        data-wow-delay="0.4s"></a>
                                    </div>

                                    <div class="col-sm-6">
                                        <a href="images/session-img8.jpg" title=""><img src="images/session-img8.jpg"
                                                                                        alt="gallery image"
                                                                                        class="img-responsive wow fadeIn"
                                                                                        data-wow-delay="0.4s"></a>
                                    </div>

                                </div>
                                <!-- end .row -->

                            </div>

                        </div>
                        <!-- end .row -->

                    </div>
                    <!-- end .popup-gallery -->
                </div>
                <!-- end .tabpanel -->

                <div role="tabpanel" class="tab-pane" id="video-gallery">

                    <div class="row">
                        <div class="col-sm-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2 text-center media-video">
                            <div class="video-wrapper">
                                <iframe width="640" height="360"
                                        src="https://player.vimeo.com/video/119217423?color=3d96d2&amp;title=0&amp;badge=0&amp;byline=0&amp;portrait=0"
                                        allowfullscreen=""></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="media-thumb">
                        <div class="row">
                            <div class="col-xs-6 col-sm-3 play-video"
                                 data-video-url="http://www.youtube.com/embed/RcGyVTAoXEU"><img
                                    src="images/video_thumb_1.jpg" class="img-responsive center-block" alt="media">

                                <p>STRESS MANAGEMENT</p>
                            </div>
                            <div class="col-xs-6 col-sm-3 play-video"
                                 data-video-url="https://player.vimeo.com/video/110246120?color=3d96d2&amp;title=0&amp;byline=0&amp;portrait=0">
                                <img src="images/video_thumb_2.jpg" class="img-responsive center-block" alt="media">

                                <p>ON LEADING</p>
                            </div>
                            <div class="col-xs-6 col-sm-3 play-video"
                                 data-video-url="http://www.youtube.com/embed/eIho2S0ZahI"><img
                                    src="images/video_thumb_3.jpg" class="img-responsive center-block" alt="media">

                                <p>HOW TO SPEAK</p>
                            </div>
                            <div class="col-xs-6 col-sm-3 play-video"
                                 data-video-url="https://player.vimeo.com/video/119217423?color=3d96d2&amp;title=0&amp;byline=0&amp;portrait=0">
                                <img src="images/video_thumb_4.jpg" class="img-responsive center-block" alt="media">

                                <p>TECH TALKS</p>
                            </div>
                        </div>
                        <!-- // end row -->
                    </div>
                    <!--  // end .media-thumb -->
                </div>
                <!-- // end tab-pane -->
            </div>
            <!-- end .tab-content -->

        </div>
        <!-- end .container -->
    </section>
    <!-- end section.gallery -->

    <!--
     FAQ
     ====================================== -->

    <section class="faq" id="faq">

        <div class="container">

            <div class="section-title">
                <h5>Frequently Asked Questions</h5>
            </div>
            <div class="row">
                <div class="col-md-6 wow fadeInLeft" data-wow-duration="2s">
                    <h6 class="faq-title">How can I get to the venue?</h6>

                    <p>Shuttle from Botanical Garden metro station will leave by 9:00 AM and those who avail cab
                        facility
                        for home drop and pickup can contact their cab driver for the same.</p>
                    <h6 class="faq-title">Is is necessary to attend IntelliMeet?</h6>

                    <p>This day is a working day, if not present you will be marked absent.</p>
                </div>
                <div class="col-md-6 wow fadeInRight" data-wow-duration="2s">

                    <h6 class="faq-title">Can I own a session?</h6>

                    <p>Yes, you are always welcome to share your knowledge. Just let us know by submitting your agenda
                        <a
                                href="http://goo.gl/forms/93dega9dlp" target="_blank">here</a> as and we will get back
                        to you.
                    </p>

                    <h6 class="faq-title">What if my plan changes after filling the survey?</h6>

                    <p>If for some reason, your plan changes after filling the survey, please talk to the IntelliMeet
                        organizers personally, explaining the reason why you wouldn’t be able to attend the upcoming
                        Intellimeet.
                        The above information is to be handed out by the EOD on the last Thursday before the
                        Intellimeet.</p>

                </div>
            </div>
        </div>
    </section>
    <!-- end section.faq -->

    <!--
     Contact us
     ====================================== -->

    <div class="highlight" id="highlight">
        <div class="container">

            <div class="row">
                <div class="col-sm-6">
                    <div class="contact-box">
                        <img src="images/location-icon.png" alt="location icon" class="wow zoomIn">
                        <h5>ADDRESS</h5>

                        <p>4th Floor, Tower B,
                            <br>Logix Techno Park,
                            <br> Sector 127, Noida
                            <br>
                            <br>Time: 9:30 AM to 5:30 PM</p>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="contact-box">
                        <img src="images/email-icon.png" alt="email icon" class="wow zoomIn" data-wow-delay="0.3s">
                        <h5>CONTACT</h5>

                        <p><a href="mailto:tech-grails-intellimeet-team@tothenew.com">tech-grails-intellimeet-team@tothenew.com</a>
                            <br><br>
                            <br>
                            <br>
                            <br>
                        </p>
                    </div>
                </div>
            </div>
            <!--  // end .row -->
        </div>
    </div>
    <!-- //  end .highlight -->
    <!-- // end .container -->

    <footer>

        <div class="social-icons">
            <a href="#" class="wow zoomIn"> <i class="fa fa-twitter"></i> </a>
            <a href="#" class="wow zoomIn" data-wow-delay="0.2s"> <i class="fa fa-facebook"></i> </a>
            <a href="#" class="wow zoomIn" data-wow-delay="0.4s"> <i class="fa fa-linkedin"></i> </a>
        </div>
        <p>
            <small class="text-muted">TOTHENEW - Digital</small>
        </p>

    </footer>

    <a href="#top" class="back_to_top"><img src="images/back_to_top.png" alt="back to top"></a>


    <!--
     Javascripts : Nerd Stuff :)
     ====================================== -->

    <!-- jQuery Library -->
    <script src="js/jquery.min.js"></script>

    <!-- Bootstrap JS -->
    <script src="js/bootstrap.min.js"></script>

    <!-- 3rd party Plugins -->
    <script src="js/plugins/countdown.js"></script>
    <script src="js/plugins/wow.js"></script>
    <script src="js/plugins/slick.js"></script>
    <script src="js/plugins/magnific-popup.js"></script>
    <script src="js/plugins/validate.js"></script>
    <script src="js/plugins/appear.js"></script>
    <script src="js/plugins/count-to.js"></script>
    <script src="js/plugins/nicescroll.js"></script>

    <!-- Google Map -->
    <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script src="js/plugins/infobox.js"></script>
    <script src="js/plugins/google-map.js"></script>
    <script src="js/plugins/directions.js"></script>

    <!-- JS Includes -->
    <script src="js/includes/subscribe.js"></script>
    <script src="js/includes/contact_form.js"></script>

    <!-- Main Script -->
    <script src="js/main.js"></script>
</div>
</body>

</html>
