angular.module('ce').factory('VeiculoResource', function($resource){
    var resource = $resource('rest/veiculos/:VeiculoId',{VeiculoId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});