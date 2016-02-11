intellimeetApp.factory("LoginService", function ($http, HOST) {
    var factory = {}
    factory.changePassword = function (data, callback) {
        $http({
            method: "POST",
            url: HOST + "/home/changePassword",
            data: data
        })
            .success(function (response) {
                callback(response)
            })
    }
    return factory
})