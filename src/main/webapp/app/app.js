var intellimeetApp = angular.module("intellimeetApp", ["ui.router", "ngMaterial", 'ngAnimate', 'ui.bootstrap', 'ngNotify','textAngular']);
intellimeetApp.constant("HOST", location.protocol + "//" + window.location.host);
intellimeetApp.constant("CURRENT_MONTH", "Current Month")
intellimeetApp.constant("CSRF",$.cookie("_csrf"))
intellimeetApp.constant("CLOUDE_NAME","knowledgemeet")
intellimeetApp.constant("UPLOAD_PRESET","r4zvcesz")
intellimeetApp.config(function ($stateProvider) {
    $stateProvider
        .state("root", {
            url: "",
            templateUrl: "./app/components/dashboard/index.html"
        })

        .state("topic", {
            url: "/topics",
            templateUrl: "./app/components/topic/list.html"
        })

        .state("topic.create", {
            url: "/create",
            templateUrl: "./app/components/topic/create.html"
        })
        .state("dashboard", {
            url: "/dashboard",
            templateUrl: "./app/components/dashboard/index.html"
        })
        .state("session", {
            url: "/sessions",
            templateUrl: "./app/components/session/list.html"
        })
        .state("schedule", {
            url: "/schedule",
            templateUrl: "./app/components/schedule/index.html",
            controller: "ScheduleController"
        })

        .state("schedule.create", {
            url: "/create",
            templateUrl: "./app/components/schedule/create.html",
            controller: "ScheduleController"
        })

        .state("paper", {
            url: "/paper",
            templateUrl: "./app/components/paper/list.html"
        })

        .state("login", {
            url: "/resetPassword",
            templateUrl: "./app/components/login/resetPasswd.html"
        })

});