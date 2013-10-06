'use strict';

angular.module('ce',['ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/Veiculos',{templateUrl:'views/Veiculo/search.html',controller:'SearchVeiculoController'})
      .when('/Veiculos/new',{templateUrl:'views/Veiculo/detail.html',controller:'NewVeiculoController'})
      .when('/Veiculos/edit/:VeiculoId',{templateUrl:'views/Veiculo/detail.html',controller:'EditVeiculoController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
