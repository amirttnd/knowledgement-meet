intellimeetApp.factory("SessionService", function ($http, HOST, CSRF) {
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

    factory.paginateListFindAllBySessionStat = function (sessionStat, page, size, callback) {
        $http({
            method: "GET",
            url: HOST + "/session/findAllSessionBySessionStat?sessionStat=" + sessionStat + "&page=" + page + "&size=" + size
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.paginateListFindAllByTopicName = function (name, page, size, callback) {
        $http({
            method: "GET",
            url: HOST + "/session/findAllByTopicName?name=" + name + "&page=" + page + "&size=" + size
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
            url: HOST + "/schedule/update/?_csrf=" + CSRF + scheduleId,
            data: data
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.removeFromComingIntellimeet = function (id, callback) {
        $http({
            method: "DELETE",
            url: HOST + "/session/removeSessionFromIntellimeet/" + id + "?_csrf=" + CSRF
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.addToComingIntellimeet = function (id, callback) {
        $http({
            method: "POST",
            url: HOST + "/session/addToComingIntellimeet/" + id + "?_csrf=" + CSRF
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.addPresenter = function (id, presenter, callback) {
        $http({
            method: 'POST',
            url: HOST + "/session/addPresenter/" + id + "?_csrf=" + CSRF,
            data: presenter
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.removePresenter = function (id, presenter, callback) {
        $http({
            method: "DELETE",
            url: HOST + "/session/removePresenter/" + id + "?_csrf=" + CSRF,
            data: presenter
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.findAllByTopicName = function (name, callback) {
        if (name == undefined) {
            name = ''
        }
        $http({
            method: "GET",
            url: HOST + "/session/findAllByTopicName?name=" + name
        })
            .success(function (response) {
                callback(response)
            })
    }

    return factory
});