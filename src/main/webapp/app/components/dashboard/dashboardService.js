intellimeetApp.factory("DashboardService", function ($http, HOST) {
    var factory = {};
    factory.lastIntellimeet = function (callback) {
        $http({
            method: "GET",
            url: HOST + "/intellimeet/lastIntellimeet"
        })
            .success(function (response) {
                callback(response)
            })
    };
    factory.viewIntellimeetOnDate = function (date, callback) {
        $http({
            method: "GET",
            headers: {
                "Content-Type": "Application/json"
            },
            url: HOST + "/intellimeet/view?date=" + date
        })
            .success(function (response) {
                callback(response)
            })
    }

    factory.changeIntellimeetDate = function (date, CSRF, callback) {

        $http({
            method: "PUT",
            url: HOST + "/intellimeet/changeIntellimeetDate?_csrf=" + CSRF,
            headers: {
                "Content-Type": "Application/json"
            },
            data: date
        })
            .success(function (response) {
                console.log(response)
                callback(response)
            })
    }
    return factory
});