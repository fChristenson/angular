/**
 * 
 */
app.controller("mainController",["$scope", "$http", function($scope, $http){
    $scope.name;
    $scope.email;
    $scope.people = [];
    
    $http.get("getAllPeople.json").success(function(data){
        $scope.people = data; 
    });
    
    $scope.addLove = function(){
        if($scope.name === undefined || $scope.email === undefined){
            $scope.name = undefined;
            $scope.email = undefined;            
           
            return;
        }
        
      var person = {id:$scope.people.length, name:$scope.name, email:$scope.email};
      $scope.people.push(person);

      $scope.name = undefined;
      $scope.email = undefined;
      
      console.log(person);
      $http.post("addPerson.json", person);
    };
    
}]);