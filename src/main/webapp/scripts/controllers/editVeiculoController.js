

angular.module('ce').controller('EditVeiculoController', function($scope, $routeParams, $location, VeiculoResource ) {
    var self = this;
    $scope.disabled = false;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.veiculo = new VeiculoResource(self.original);
        };
        var errorCallback = function() {
            $location.path("/Veiculos");
        };
        VeiculoResource.get({VeiculoId:$routeParams.VeiculoId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.veiculo);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.veiculo.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Veiculos");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Veiculos");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.veiculo.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});