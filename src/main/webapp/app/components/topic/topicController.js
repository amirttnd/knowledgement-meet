intellimeetApp.controller("TopicController", function ($scope, $http, HOST, TopicService) {

    var $this = this;

    $scope.searchQuery = function () {
        console.log("Search Topic:- " + $scope.search)
    };


    $this.uploadFile = function (topicJSON) {
        var file = $this.logo;
        var uploadUrl = "/topic/uploadLogo";
        TopicService.uploadFileToUrl(file, topicJSON.id, uploadUrl, function (response) {
            topicJSON.imageSrc = response.imageSrc
        });
    };

    $this.init = function () {
        topicList()
    };

    var topicList = function () {
        TopicService.topicList(function (response) {
            $this.topics = response
        })
    }
});