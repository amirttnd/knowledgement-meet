intellimeetApp.controller("ScheduleController", function ($scope, $http, HOST, ScheduleService) {
    var $this = this;


    $this.message = "Hello";

    $this.saveDefaultSchedule = function () {
        $this.scheduleJSON.breakFast = $this.breakFast;
        $this.scheduleJSON.sessionCommencement = $this.sessionCommencement;
        $this.scheduleJSON.lunch = $this.lunch;
        $this.scheduleJSON.discussionAndFeedback = $this.discussionAndFeedback;
        $this.scheduleJSON.wrapUp = $this.wrapUp
    };


    $this.init = function () {
        $this.scheduleJSON = {};

        ScheduleService.fullDaySchedule(function (response) {
            console.log(response);
            $this.scheduleJSON = response
        });
        $this.breakFast = $this.scheduleJSON.breakFast;
        $this.sessionCommencement = $this.scheduleJSON.sessionCommencement;
        $this.lunch = $this.scheduleJSON.lunch;
        $this.discussionAndFeedback = $this.scheduleJSON.discussionAndFeedback;
        $this.wrapUp = $this.scheduleJSON.wrapUp
    }
});