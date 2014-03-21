/**
 * 
 */
var app = angular.module("angular", ["ui.router"])
.config(function($stateProvider, $urlRouterProvider){
    $urlRouterProvider.otherwise("/");
    
    $stateProvider.state("home", {
        url: "/home",
        templateUrl: "se/fidde/angular/view/template/home.html",
        controller:"mainController"
    
    }).state("message", {
        url: "/message",
        templateUrl: "se/fidde/angular/view/template/message.html"
    });
});