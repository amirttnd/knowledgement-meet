intellimeetApp.controller("LoginController", function (LoginService, HOST, ngNotify) {
    var $this = this

    $this.changePassword = function () {
        var oldPassword = $this.oldPassword
        var newPassword = $this.newPassword
        var reTypePassword = $this.reTypePassword
        if (newPassword != reTypePassword) {
            ngNotify.set("Re-Type Password does not match")
        } else {
            var data = {
                oldPassword: oldPassword,
                newPassword: newPassword
            }
            LoginService.changePassword(data, function (response) {
                ngNotify.set(response.msg, "error")
            })
        }
    }

})