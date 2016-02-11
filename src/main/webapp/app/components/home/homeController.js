var intellimeetApp = angular.module("intellimeetWeb", []);
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

});