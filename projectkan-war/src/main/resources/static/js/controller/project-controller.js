/**
 * Created by willlobato on 03/08/16.
 */
'use strict';

angular.module('mainApp').controller('ProjectController', ['$scope', 'ProjectService', function($scope, ProjectService) {
    var self = this;
    self.user={id:null,username:'',address:'',email:''};
    self.users=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllUsers();

    function fetchAllUsers(){
        ProjectService.fetchAllUsers()
            .then(
                function(d) {
                    self.users = d;
                },
                function(errResponse){
                    console.error('Error while fetching Users');
                }
            );
    }

    function createUser(user){
        ProjectService.createUser(user)
            .then(
                fetchAllUsers,
                function(errResponse){
                    console.error('Error while creating User');
                }
            );
    }

    function updateUser(user, id){
        ProjectService.updateUser(user, id)
            .then(
                fetchAllUsers,
                function(errResponse){
                    console.error('Error while updating User');
                }
            );
    }

    function deleteUser(id){
        ProjectService.deleteUser(id)
            .then(
                fetchAllUsers,
                function(errResponse){
                    console.error('Error while deleting User');
                }
            );
    }

    function submit() {
        if(self.user.id===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.id);
            console.log('User updated with id ', self.user.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(id);
    }


    function reset(){
        self.user={id:null,username:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);