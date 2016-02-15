intellimeetApp.controller("PaperController", function ($scope, $http, ngNotify, HOST, PaperService, TopicService) {
        var $this = this;
        $this.searchQuery = function ($event) {
            if ($event.which == 13) {
                PaperService.findAllByTopicName($this.search, function (response) {
                    $this.papers = response.content;
                    $this.totalItems = response.totalElements
                    $this.itemsPerPage = response.size;
                })
            }
        };

        $this.createNewPaper = function (paperJSON) {
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
            });

            hideModal("addPaperModal")

        };

        $this.removePaper = function (paperJSON) {
            var index = $this.papers.indexOf(paperJSON);
            if (confirm("Do You Want To Delete Paper Which is Given By " + paperJSON.givenBy + "...?"))
                PaperService.removePaper(paperJSON.id, function (response) {
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
                $this.papers = response.content
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
                $this.topics = response
            })
        };

        var paperList = function () {
            PaperService.list(function (response) {
                $this.papers = response.content;
                $this.totalItems = response.totalElements
                $this.itemsPerPage = response.size;
                $this.maxSize = 5;
                $this.currentPageNumber = 1;
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


