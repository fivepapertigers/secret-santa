(function(){
  var app = angular.module('SecretSanta', ['ngResource'])

  app.service('ParticipantFactory', ['$resource', function($resource){
    return $resource('/api/participants/:id', {id: '@id'})
  }])

  app.controller('HomeController', ['ParticipantFactory', function(ParticipantFactory){
      var vm = this;
      vm.participants = ParticipantFactory.query()
    }])

})()