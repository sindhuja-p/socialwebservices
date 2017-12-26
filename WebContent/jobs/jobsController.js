myapp.controller("jobsController", function($scope, $http, $location,$rootScope) {
	function fetchAllJobs() {
		console.log("fetched all jobs")
		$http.get("http://localhost:8181/Collabaration/getAllJobs")

		.then(function(response) {
			$scope.jobsdata = response.data;
			console.log("all jobs fetched")
		});
	};
	fetchAllJobs();
	$scope.insertJobs = function() {
		console.log('entered insertJobs');
		$http.post('http://localhost:8181/Collabaration/insertJobs',
				$scope.jobs).then(fetchAllJobs(), function(response) {
			console.log("successful jobs entered");
			$location.path("/jobs")
		});
	}
});