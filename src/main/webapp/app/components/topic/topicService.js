intellimeetApp.factory("TopicService", function ($http, HOST, CSRF, UPLOAD_PRESET, CLOUDE_NAME) {
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
        $http.post(HOST + uploadUrl + "?_csrf=" + CSRF, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
            .success(function (response) {
                callback(response)
            })

            .error(function () {
            });
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


    factory.saveCloudinaryUrl = function (topicId, imageUrl, callback) {
        $http({
            method: "GET",
            url: HOST + "/topic/saveCloudinaryUrl?topicId=" + topicId + "&imageUrl=" + imageUrl
        })
            .success(function (response) {
                callback(response)
            })
    }

    factory.uploadFileToCloudinary = function (file, successCallback) {
        var fd = new FormData();
        fd.append('upload_preset', UPLOAD_PRESET);
        fd.append('file', file);

        $http
            .post('https://api.cloudinary.com/v1_1/' + CLOUDE_NAME + '/image/upload', fd, {
                headers: {
                    'Content-Type': undefined,
                    'X-Requested-With': 'XMLHttpRequest'
                }
            })
            .success(function (cloudinaryResponse) {
                successCallback(cloudinaryResponse)

            })
    }
    return factory
});