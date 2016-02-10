intellimeetApp.controller("DashboardController", function ($scope, $http, HOST, DashboardService) {
    var $this = this;
    $this.intellimeetJSON = {};
    $this.sessions = [];
    $this.init = function () {
        lastIntellimeet()
        datepicker()
        datePickerForChangeKnowledgeMeet()
    };

    var lastIntellimeet = function () {
        DashboardService.lastIntellimeet(function (response) {
            $this.intellimeetJSON = response;
            console.log(response)
        })
    }

    $this.changeIntellimeetDate = function () {
        var date = $this.changeDate;
        DashboardService.changeIntellimeetDate(date, function (response) {
            $this.intellimeetJSON = response
            console.log(response)
        })
    }

    var datepicker = function () {
        $('.datetimepicker').datetimepicker({
            dayOfWeekStart: 1,
            lang: 'en',
            format: 'd/m/Y',
            timepicker: false,
            startDate: new Date(),
            step: 1,
            onChangeDateTime: function (dp, $input) {
                viewIntellimeetOnDate(dp, $input)
            }
        });
    }

    var datePickerForChangeKnowledgeMeet = function () {
        $('#datePickerForIntellimeet').datetimepicker({
            dayOfWeekStart: 1,
            lang: 'en',
            format: 'd/m/Y',
            timepicker: false,
            startDate: new Date(),
            step: 1,
            onChangeDateTime: function (dp, $input) {
                $this.changeDate = $input.val()
            }
        });
    }

    var viewIntellimeetOnDate = function (dp, $input) {
        var date = $input.val()
        if (date != null && date != '') {
            DashboardService.viewIntellimeetOnDate(date, function (response) {
                $this.intellimeetJSON = response;
            })
        }
    }
});