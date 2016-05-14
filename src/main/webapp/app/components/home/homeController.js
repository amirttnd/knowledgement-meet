var intellimeetApp = angular.module("intellimeetWeb", ['textAngular']);
intellimeetApp.constant("HOST", location.protocol+"//"+window.location.host);
intellimeetApp.constant("SESSION_COMMENCEMENT", "09:30");

intellimeetApp.controller("HomeController", function ($scope, $http, HOST, ScheduleService, DashboardService, SESSION_COMMENCEMENT) {
    var $this = this;
    $this.init = function () {
        lastIntellimeet();
        fullDaySchedule()
    };

    $this.showAgenda=function(sessionJSON){
        $this.agenda=sessionJSON.paper.agenda;
        $this.topic=sessionJSON.paper.topic.name;
        $this.schedule=sessionJSON.schedule;
        $this.imageSrc=sessionJSON.paper.topic.imageSrc
    };
    $this.carouselInitializer = function() {
        $(".owl-carousel").owlCarousel({
            items: 3,
            navigation: true,
            pagination: false,
            navigationText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"]
        });
    };
    var fullDaySchedule = function () {
        ScheduleService.fullDaySchedule(function (resoponse) {
            $this.intellimeetDay = resoponse.intellimeetDay;
            $this.breakFast = resoponse.breakFast;
            $this.sessionCommencement = resoponse.sessionCommencement;
            $this.lunch = resoponse.lunch;
            $this.discussionAndFeedback = resoponse.discussionAndFeedback;
            $this.wrapUp = resoponse.wrapUp
        })
    };

    var lastIntellimeet = function () {
        DashboardService.lastIntellimeet(function (response) {
            $this.lastIntellimeet = response;
            eventWillStart()
        })
    };

    var eventWillStart = function () {
        var timeRemaining;
        setInterval(function () {
                if ($this.lastIntellimeet.intellimeetDate != null) {
                    timeRemaining = _getRemainingTime($this.lastIntellimeet.intellimeetDate + " " + SESSION_COMMENCEMENT);
                    /* e.g timeRemaining = 27-February, 2016 10:00 */
                    $scope.$apply(function () {
                        $this.days = timeRemaining.days < 0 ? 0 : timeRemaining.days;
                        $this.hours = timeRemaining.hours < 0 ? 0 : timeRemaining.hours;
                        $this.minutes = timeRemaining.minutes < 0 ? 0 : timeRemaining.minutes;
                        $this.seconds = timeRemaining.seconds < 0 ? 0 : timeRemaining.seconds
                    })
                }
            }
            , 1000)
    };

    function _getRemainingTime(endtime) {
        var t = Date.parse(endtime) - Date.parse(new Date());
        var seconds = Math.floor((t / 1000) % 60);
        var minutes = Math.floor((t / 1000 / 60) % 60);
        var hours = Math.floor((t / (1000 * 60 * 60)) % 24);
        var days = Math.floor(t / (1000 * 60 * 60 * 24));
        return {
            'total': t,
            'days': days,
            'hours': hours,
            'minutes': minutes,
            'seconds': seconds
        };
    }
    $scope.items2 = [1,2,3,4,5,6,7,8,9,10];

});

intellimeetApp.directive("owlCarousel",function(){
    return{
        restrict:'A',
        link:function(scope,element,attr){
            $(element).owlCarousel({
                loop: true,
                margin: 10,
                responsiveClass: true,
                responsive: {
                    0: {
                        items: 1,
                        nav: true
                    },
                    600: {
                        items: 3,
                        nav: false
                    },
                    1000: {
                        items: 5,
                        nav: true,
                        loop: false
                    }
                }
            })
        }
    }
})

intellimeetApp.directive("owlCarousel", function() {
    return {
        restrict: 'E',
        transclude: false,
        link: function (scope) {
            scope.initCarousel = function(element) {
                // provide any default options you want
                var defaultOptions = {
                };
                var customOptions = scope.$eval($(element).attr('data-options'));
                // combine the two options objects
                for(var key in customOptions) {
                    defaultOptions[key] = customOptions[key];
                }
                // init carousel
                $(element).owlCarousel(defaultOptions);
            };
        }
    };
})
    .directive('owlCarouselItem', [function() {
        return {
            restrict: 'A',
            transclude: false,
            link: function(scope, element) {
                // wait for the last item in the ng-repeat then call init
                if(scope.$last) {
                    scope.initCarousel(element.parent());
                }
            }
        };
    }])