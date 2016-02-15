intellimeetApp
    .controller("SessionController", function ($scope, $http, HOST, ngNotify, SessionService, TopicService, CURRENT_MONTH) {

        var $this = this;

        $this.searchQuery = function ($event) {
            if ($event.which == 13) {
                _findAllByTopicName()
            } else if ($this.search == undefined) {
                $this.findAllSessionBySessionStat()
            }
        };

        $this.pageChanged = function () {
            var size = $this.itemsPerPage;
            var currentPageNumber = parseInt($this.currentPageNumber) - 1;
            if ($this.search == undefined) {
                SessionService.paginateListFindAllBySessionStat($this.sessionStat, currentPageNumber, size, function (response) {
                    $this.sessions = response.sessions;
                    $this.itemsPerPage = response.max;
                    $this.totalItems = response.totalItems
                })
            } else {
                SessionService.paginateListFindAllByTopicName($this.search, currentPageNumber, size, function (response) {
                    $this.sessions = response.content;
                    $this.itemsPerPage = response.size;
                    $this.totalItems = response.totalElements
                })
            }
        };

        $this.findAllSessionBySessionStat = function () {
            SessionService.findAllSessionBySessionStat($this.sessionStat, function (response) {
                $this.sessions = response.sessions;
                $this.itemsPerPage = response.max;
                $this.totalItems = response.totalItems
                $this.currentPageNumber = 1

            })
        }


        $this.convertMillisecondToDate = function (self) {
            return new Date(self).toLocaleDateString()
        }

        $this.addPresenter = function (sessionJSON) {

            if (!$this.emails.isValueExist($this.presenter)) {
                $this.emails.push($this.presenter)
            }

            if (sessionJSON.sessionStat == "SCHEDULED") {
                ngNotify.set("Session has been expire you can't add the presenter")
            } else if (!sessionJSON.presenters.isValueExist($this.presenter)) {
                SessionService.addPresenter(sessionJSON.id, $this.presenter, function (response) {
                    sessionJSON.presenters.push($this.presenter);
                    ngNotify.set($this.presenter + ' has been added!', 'error');
                })
            } else {
                ngNotify.set($this.presenter + " is exist!")
            }

        };

        $this.removePresenter = function (sessionJSON, presenter) {
            if (!sessionJSON.isAddedInIntellimeet) {
                var index = sessionJSON.presenters.indexOf(presenter);
                SessionService.removePresenter(sessionJSON.id, presenter, function (response) {
                    sessionJSON.presenters.splice(index, 1);
                    ngNotify.set(presenter + ' has been removed!', 'error');
                })
            } else {
                ngNotify.set("Can't remove presenter because it is added in coming intellimeet", 'error')
            }
        };

        $this.addToComingIntellimeet = function (sessionJSON) {
            if (sessionJSON.presenters.length > 0) {
                SessionService.addToComingIntellimeet(sessionJSON.id, function (response) {
                    if (sessionJSON.id == response.id) {
                        sessionJSON.isAddedInIntellimeet = response.isAddedInIntellimeet;
                        sessionJSON.intellimeet = response.intellimeet;
                        sessionJSON.sessionStat = response.sessionStat
                    }
                    ngNotify.set('Successfull Added in Coming Intellimeet!', 'error');
                })
            } else {
                ngNotify.set("Can't added in coming intellimeet because there is no presenter", 'error')

            }
        };
        $this.removeFromComingIntellimeet = function (sessionJSON) {
            SessionService.removeFromComingIntellimeet(sessionJSON.id, function (response) {
                sessionJSON.isAddedInIntellimeet = response.isAddedInIntellimeet;
                sessionJSON.intellimeet = response.intellimeet
                sessionJSON.sessionStat = response.sessionStat
                ngNotify.set('Successfull Removed from Coming Intellimeet!', 'error');
            })
        };

        $this.updateSchedule = function (sessionJSON) {
            $this.sessionIndex = $this.sessions.indexOf(sessionJSON);
            $this.scheduleId = sessionJSON.schedule.id;
            $this.breakFast = sessionJSON.schedule.breakFast;
            $this.sessionCommencement = sessionJSON.schedule.sessionCommencement;
            $this.lunch = sessionJSON.schedule.lunch;
            $this.discussionAndFeedback = sessionJSON.schedule.discussionAndFeedback;
            $this.wrapUp = sessionJSON.schedule.wrapUp
        };

        $this.saveSchedule = function (sessionIndex) {
            var data = {
                breakFast: $this.breakFast,
                sessionCommencement: $this.sessionCommencement,
                lunch: $this.lunch,
                discussionAndFeedback: $this.discussionAndFeedback,
                wrapUp: $this.wrapUp
            };

            SessionService.saveSchedule($this.scheduleId, data, function (response) {
                $this.sessions[$this.sessionIndex].schedule.breakFast = response.breakFast;
                $this.sessions[$this.sessionIndex].schedule.sessionCommencement = response.sessionCommencement;
                $this.sessions[$this.sessionIndex].schedule.lunch = response.lunch;
                $this.sessions[$this.sessionIndex].schedule.discussionAndFeedback = response.discussionAndFeedback;
                $this.sessions[$this.sessionIndex].schedule.wrapUp = response.wrapUp;
                ngNotify.set('Successfull Updated!', 'error');
            })
        };


        $this.init = function () {
            $this.emails = [
                "mohd.amir@tothenew.com",
                "ajey.singh@tothenew.com",
                "gaurav.sharma@tothenew.com",
                "roni.thomas@tothenew.com"
            ];
            _sessionList()
            _listOfSessionStat()
            _listOfTopic()

        };

        var _findAllByTopicName = function () {
            SessionService.findAllByTopicName($this.search, function (response) {
                console.log(response)
                $this.sessions = response.content
                $this.itemsPerPage = response.size;
                $this.totalItems = response.totalElements
                $this.currentPageNumber = 1
            })
        }

        var _sessionList = function () {
            SessionService.list(function (data) {
                $this.sessions = data;
                $this.maxSize = 5;
                $this.currentPageNumber = 1;
            })
        }

        var _listOfTopic = function () {
            TopicService.listOfTopicNames(function (response) {
                $this.topics = response
            })
        }

        var _listOfSessionStat = function () {
            SessionService.listOfSessionStat(function (response) {
                $this.sessionStatList = response
                $this.sessionStat = CURRENT_MONTH
            })
        }
    }
);