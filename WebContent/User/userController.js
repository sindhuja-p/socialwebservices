myapp.controller("userController", function($scope, $http, $location,$rootScope) {
	$scope.user={username:'',password:'',role:'',firstname:'',lastname:'',email:'',contact:'',isOnline:'',uid:''}
	$scope.allusers;
	$scope.user;
	
	var BASE_URL='http://localhost:8181/Collabaration'
	$scope.register=function()
	{
		console.log("enter register");
		$http.post(BASE_URL+"/register",$scope.user).then(function(response)
				{
					console.log("successfully registered");
					$location.path("/login");
				});
	}
	$scope.login=function()
	{
		console.log("loggin function");
		
		$http.post(BASE_URL+"/login",$rootScope.currentUser)
		.then(function(response){
			$scope.user=response.data;
			$rootScope.currentUser=response.data;
			console.log($rootScope.currentUser.role);
			$location.path("/")
		});
	};
	function fetchAllUsers()
	{
		console.log("fetching all users");
		$http.get("http://localhost:8181/Collaboration/getAllUsers")
		.then(function(response)
				{
					$scope.allusers=response.data;
				});
				};
				fetchAllUsers();
	});



