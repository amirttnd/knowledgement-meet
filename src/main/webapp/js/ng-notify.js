!function () {
    "use strict";
    var a = angular.module("ngNotify", []), b = !1;
    try {
        angular.module("ngSanitize") && (angular.module("ngNotify").requires.push("ngSanitize"), b = !0)
    } catch (c) {
    }
    var d = '<div class="ngn" ng-class="ngNotify.notifyClass"><span class="ngn-dismiss" ng-click="dismiss()">&times;</span><span ng-if="ngNotify.nofityHtml" ng-bind-html="ngNotify.notifyMessage"></span><span ng-if="!ngNotify.nofityHtml" ng-bind="ngNotify.notifyMessage"></span></div>';
    a.run(["$templateCache", function (a) {
        a.put("templates/ng-notify/ngNotify.html", d)
    }]), a.provider("ngNotify", function () {
        this.$get = ["$document", "$compile", "$log", "$rootScope", "$timeout", "$interval", "$templateCache", function (a, c, d, e, f, g, h) {
            var i, j, k = {
                theme: "pure",
                position: "bottom",
                duration: 3e3,
                type: "info",
                sticky: !1,
                html: !1
            }, l = {
                pure: "",
                prime: "ngn-prime",
                pastel: "ngn-pastel",
                pitchy: "ngn-pitchy"
            }, m = {
                infoClass: "ngn-info",
                errorClass: "ngn-error",
                successClass: "ngn-success",
                warnClass: "ngn-warn",
                grimaceClass: "ngn-grimace"
            }, n = {
                bottom: "ngn-bottom",
                top: "ngn-top"
            }, o = e.$new(), p = c(h.get("templates/ng-notify/ngNotify.html"))(o);
            a.find("body").append(p);
            var q = function (a) {
                var b = (a || k.type) + "Class";
                return m[b] || m.infoClass
            }, r = function (a) {
                var b = a || k.theme;
                return l[b] || l.pure
            }, s = function (a) {
                var b = a || k.position;
                return n[b] || n.bottom
            }, t = function (a) {
                var b = a || k.duration;
                return angular.isNumber(b) ? b : 3500
            }, u = function (a) {
                var b = a || k.sticky;
                return b ? !0 : !1
            }, v = function (a) {
                if (!b)return (a || k.html) && d.debug("ngNotify warning:\nThe ngSanitize script couldn't be located.  In order to use the 'html' option, be sure ngSanitize is included and added as a dependency to your app."), !1;
                var c = a || k.html;
                return c ? !0 : !1
            }, w = function () {
                o.ngNotify = {notifyClass: "", notifyMessage: ""}
            }, x = function (a) {
                return new x.fn(a)
            };
            x.fn = function (a) {
                this.el = a
            }, x.fn.prototype._fade = function (a, b, c, d) {
                var e = 25, f = e / c, h = this.el;
                h.css("opacity", b);
                var i = function () {
                    b += a * f, h.css("filter", "progid:DXImageTransform.Microsoft.Alpha(Opacity=" + 100 * b + ")"), h.css("opacity", b), (0 >= b || b >= 1) && (g.cancel(j), 0 >= b && h.css("display", "none"), d && d())
                };
                j = g(i, e)
            }, x.fn.prototype.fadeIn = function (a, b) {
                this.el.css("filter", "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)"), this.el.css("display", "block"), this._fade(1, 0, a, b)
            }, x.fn.prototype.fadeOut = function (a, b) {
                this._fade(-1, 1, a, b)
            }, o.dismiss = function () {
                y.fadeOut(500, function () {
                    w()
                })
            };
            var y = x(p);
            return {
                config: function (a) {
                    a = a || {}, angular.extend(k, a)
                }, set: function (a, b) {
                    if (a) {
                        g.cancel(j), f.cancel(i);
                        var c = {};
                        "object" == typeof b ? c = {
                            type: b.type || void 0,
                            theme: b.theme || void 0,
                            position: b.position || void 0,
                            duration: b.duration || void 0,
                            sticky: b.sticky || void 0,
                            html: b.html || void 0
                        } : c.type = b;
                        var d = v(c.html), e = u(c.sticky), h = t(c.duration), k = q(c.type) + " " + r(c.theme) + " " + s(c.position);
                        k += e ? " ngn-sticky" : "", o.ngNotify = {
                            nofityHtml: d,
                            notifyClass: k,
                            notifyMessage: a
                        }, y.fadeIn(200, function () {
                            e || (i = f(function () {
                                o.dismiss()
                            }, h))
                        })
                    }
                }, dismiss: function () {
                    o.dismiss()
                }, addTheme: function (a, b) {
                    a && b && (l[a] = b)
                }, addType: function (a, b) {
                    a && b && (m[a + "Class"] = b)
                }
            }
        }]
    })
}();