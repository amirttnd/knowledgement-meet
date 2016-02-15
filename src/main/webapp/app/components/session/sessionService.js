intellimeetApp.factory("SessionService", function ($http, HOST) {
    var factory = {};

    factory.list = function (callback) {
        $http({
            method: "GET",
            url: HOST + "/session/list"
        }).success(function (data) {
            callback(data)
        })
    };

    factory.findAllSessionBySessionStat = function (sessionStat, callback) {
        $http({
            method: "GET",
            url: HOST + "/session/findAllSessionBySessionStat/?sessionStat=" + sessionStat
        })
            .success(function (response) {
                callback(response)
            })
    }

    factory.listOfSessionStat = function (callback) {
        $http({
            method: "GET",
            url: HOST + "/session/listOfSessionStat"
        })
            .success(function (response) {
                callback(response)
            })
    }

    factory.paginateList = function (sessionStat, page, size, callback) {
        $http({
            method: "GET",
            url: HOST + "/session/findAllSessionBySessionStat?sessionStat=" + sessionStat + "&page=" + page + "&size=" + size
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.saveSchedule = function (scheduleId, data, callback) {
        $http({
            method: "PUT",
            headers: {
                "Content-Type": "Application/json"
            },
            url: HOST + "/schedule/update/" + scheduleId,
            data: data
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.removeFromComingIntellimeet = function (id, callback) {
        $http({
            method: "DELETE",
            url: HOST + "/session/removeSessionFromIntellimeet/" + id
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.addToComingIntellimeet = function (id, callback) {
        $http({
            method: "POST",
            url: HOST + "/session/addToComingIntellimeet/" + id
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.addPresenter = function (id, presenter, callback) {
        $http({
            method: 'POST',
            url: HOST + "/session/addPresenter/" + id,
            data: presenter
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.removePresenter = function (id, presenter, callback) {
        $http({
            method: "DELETE",
            url: HOST + "/session/removePresenter/" + id,
            data: presenter
        })
            .success(function (response) {
                callback(response)
            })
    };


    return factory
});