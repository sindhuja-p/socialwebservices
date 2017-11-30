var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/home", {
        templateUrl : "home.html",
    })
    
     .when("/about", {
        templateUrl : "about.html",
        
    })
    
     .when("/contact", {
        templateUrl : "contact.html",
        
    })
    
    .when("/login", {
        templateUrl : "login.html",
        
    })
   
    .when("/registration", {
        templateUrl : "registration.html",
        
    })
   
        

});
