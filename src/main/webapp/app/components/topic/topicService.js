intellimeetApp.factory("TopicService", function ($http, HOST,CSRF) {
    var factory = {};
    factory.topicList = function (callback) {
        $http({
            method: "GET",
            url: HOST + "/topic/list"
        }).success(function (response) {
            callback(response)
        })
    };

    factory.listOfTopicNames = function (callback) {
        $http({
            method: "GET",
            url: HOST + "/topic/listOfTopicNames"
        })
            .success(function (response) {
                callback(response)
            })
    };

    factory.uploadFileToUrl = function (file, topicId, uploadUrl, callback) {
        var fd = new FormData();
        fd.append('logo', file);
        fd.append("topicId", topicId);
        $http.post(HOST + uploadUrl+"?_csrf="+CSRF, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
            .success(function (response) {
                callback(response)
            })

            .error(function () {
            });
    };

    factory.findByTopicNameLike = function (name, callback) {
        $http({
            method: "GET",
            url: HOST + "/topic/findByNameLike?name=" + name
        })
            .success(function (response) {
                callback(response)
            })
    }
    return factory
});