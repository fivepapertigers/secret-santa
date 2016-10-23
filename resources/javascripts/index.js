(function(){
  var app = angular.module('SecretSanta', ['ngResource', 'ngRoute'])

  .config(function($routeProvider, $locationProvider) {
    $routeProvider
      .when('/', {
        templateUrl: template('list_participants'),
        controller: 'ListParticipantsController',
        controllerAs: 'list'
      })

    $locationProvider.html5Mode(true);

    function template (name) {
      return 'templates/'+name+'.html'
    }
  });

  app.controller('AppController', [function(){}])

  /* List Participants */
  app.controller('ListParticipantsController', ['ParticipantStore',
                                                ListParticipantsController])
  function ListParticipantsController (ParticipantStore) {

    var vm = this;

    ParticipantStore.query().then(function(participants){
      vm.participants = participants;
    })

  }

  /* Add Participant */
  app.controller('AddParticipantController', ['ParticipantStore',
                                              AddParticipantController])
  function AddParticipantController (ParticipantStore) {
    var vm = this;
    vm.participant = function(){

    }
  }


  /* Participant Local Store */
  app.service('ParticipantStore', ['$resource', '$q', ParticipantStore]);
  function ParticipantStore ($resource, $q){
    var Participant = $resource('/api/participants/:id', {id: '@id'});

    var participants = {};

    return {
      get: function (id) {
        return $q(function(resolve, reject){
          Participant.get({id: id}, function(participant){
            resolve(updateParticipant(participant))
          }, reject)
        })
      },
      query: function(query_params) {
        return $q(function(resolve, reject){
          Participant.query(query_params, function(participants){
            resolve(participants.map(updateParticipant));
          }, reject)
        })
      }
    }

    function updateParticipant(participant) {
      var id = participant.id;
      participants[id] = participants[id] || {};
      angular.copy(participant, participants[id])
      return participants[id];
    }

  }


})()