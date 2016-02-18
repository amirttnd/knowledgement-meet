intellimeetApp.factory("LoginService", function ($http, HOST,CSRF) {
    var factory = {}
    factory.changePassword = function (data, callback) {
        $http({
            method: "POST",
            url: HOST + "/home/changePassword?_csrf="+CSRF,
            data: data
        })
            .success(function (response) {
                callback(response)
            })
    }
    return factory
})