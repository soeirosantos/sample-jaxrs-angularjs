
angular.module('ce').controller('NewVeiculoController', function ($scope, $location, locationParser, VeiculoResource ) {
    $scope.disabled = false;
    $scope.veiculo = $scope.veiculo || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Veiculos/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        VeiculoResource.save($scope.veiculo, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Veiculos");
    };
});