intellimeetApp.factory("ScheduleService", function ($http, HOST) {
    var factory = {};
    factory.fullDaySchedule = function (callback) {
        $http({
            method: 'GET',
            url: HOST + "/schedule/fullDaySchedule"
        }).success(function (response) {
            callback(response)
        })
    };
    return factory
});