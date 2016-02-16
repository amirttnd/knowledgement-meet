intellimeetApp.factory("PaperService", function ($http, HOST) {
    var factory = {};

    factory.list = function (callback) {
        $http({
            method: "GET",
            url: HOST + "/paper/list"
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.paginateList = function (page, size, callback) {
        $http({
            method: "GET",
            url: HOST + "/paper/list?page=" + page + "&size=" + size
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.paginateListFindAllByTopicName = function (name, page, size, callback) {
        if (name == undefined) {
            name = ''
        }
        $http({
            method: "GET",
            url: HOST + "/paper/findAllByTopicName?name=" + name + "&page=" + page + "&size=" + size
        })
            .success(function (response) {
                callback(response)
            })
    }

    factory.saveNewPaper = function (data, callback) {
        $http({
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            url: HOST + "/paper/create",
            data: data
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.removePaper = function (id, callback) {
        $http({
            method: 'DELETE',
            headers: {'Content-Type': 'application/json'},
            url: HOST + "/paper/delete/" + id
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
            url: HOST + "/paper/findAllByTopicName?name=" + name
        })
            .success(function (response) {
                callback(response)
            })
    }

    return factory
});