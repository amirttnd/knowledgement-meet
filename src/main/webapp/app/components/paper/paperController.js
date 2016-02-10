intellimeetApp.controller("PaperController", function ($scope, $http, ngNotify, HOST, PaperService, TopicService) {
        var $this = this;
        console.log(HOST);
        $scope.searchQuery = function () {
            console.log("Search Paper:- " + $scope.search)
        };

        $this.createNewPaper = function (paperJSON) {
            console.log(paperJSON);
            $this.topicName = paperJSON.topicName;
            showModal("addPaperModal")
        };

        $this.saveNewPaper = function () {
            var data = {
                agenda: $this.agenda,
                givenBy: $this.givenBy,
                topicName: $this.topicName,
                topicType: $this.topicType
            };

            PaperService.saveNewPaper(data, function (response) {
                _addInPaper(response);
                _addInTopic(response.topic.name);
                ngNotify.set("Successfull Added!", "error");
                console.log(response)
            });

            hideModal("addPaperModal")

        };

        $this.removePaper = function (paperJSON) {
            var index = $this.papers.indexOf(paperJSON);
            if (confirm("Do You Want To Delete Paper Which is Given By " + paperJSON.givenBy + "...?"))
                PaperService.removePaper(paperJSON.id, function (response) {
                    console.log(response);
                    $this.papers.splice(index, 1);
                    ngNotify.set("Sccessfull Deleted!", "error")
                })
        };

        $this.resetModalFieldOnClose = function () {
            $this.topicName = "";
            $this.givenBy = "";
            $this.agenda = ""
        };

        $this.pageChanged = function () {
            var page = parseInt($this.currentPageNumber) - 1;
            var size = $this.itemsPerPage;
            PaperService.paginateList(page, size, function (response) {
                $this.papers = response[0].content
            })
        };


        $this.init = function () {
            $this.papers = [];
            $this.topics = [];
            $this.isAdmin = true;
            $this.emails = ["mohd.amir@tothenew.com", "ajey.singh@tothenew.com", "gaurav.sharma@tothenew.com"];
            listOfTopicNames();
            paperList()

        };

        var listOfTopicNames = function () {
            TopicService.listOfTopicNames(function (response) {
                console.log("Topic List:- " + response);
                $this.topics = response
            })
        };

        var paperList = function () {
            PaperService.list(function (response) {
                $this.papers = response[0].content;
                $this.maxSize = 5;
                $this.itemsPerPage = response[0].size;
                $this.currentPageNumber = 1;
                $this.totalItems = response[0].totalElements
            })
        };

        var _addInPaper = function (paperJSON) {
            $this.papers.unshift({
                id: paperJSON.id,
                topic: {
                    name: paperJSON.topic.name
                },
                agenda: paperJSON.agenda,
                givenBy: paperJSON.givenBy
            })
        };

        var _addInTopic = function (topicName) {
            if ($this.topics.isValueExist(topicName) == false) {
                $this.topics.push(topicName.toString())
            }
        }
    }
);


