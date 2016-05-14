intellimeetApp.controller("TopicController", function ($scope, $http, HOST, TopicService, CLOUDE_NAME, UPLOAD_PRESET) {

    var $this = this;

    $this.searchQuery = function ($event) {
        if ($this.search == undefined || $this.search == '' || $this.search == null) {
            topicList()
        } else if ($event.which == 13) {
            TopicService.findByTopicNameLike($this.search, function (response) {
                $this.topics = response
            })
        }

    };


    $this.uploadFile = function (topicJSON) {
        var file = $this.logo;
        var uploadUrl = "/topic/uploadLogo";
        TopicService.uploadFileToUrl(file, topicJSON.id, uploadUrl, function (response) {
            topicJSON.imageSrc = response.imageSrc
        });
    };


    $this.uploadFileToCloudinary = function (topicJSON) {
        var file = $this.logo;
        TopicService.uploadFileToCloudinary(file, function (response) {
            console.log(response)
            TopicService.saveCloudinaryUrl(topicJSON.id, response.secure_url, function (response) {
                topicJSON.imageSrc = response.imageSrc
            })
        })
    }

    $this.init = function () {
        topicList()
        listOfTopicNames()
    };

    var topicList = function () {
        TopicService.topicList(function (response) {
            $this.topics = response
        })
    }

    var listOfTopicNames = function () {
        TopicService.listOfTopicNames(function (response) {
            $this.topicName = response
        })
    };
});