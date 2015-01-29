var rankApp = angular.module('rankApp',['ngTable'])
.controller('rankController',['$scope', '$http','ngTableParams',  function($scope, $http, ngTableParams){

	$scope.title = "직급관리";
	
	var dataRank = $http.get("rank_list.do").
	  success(function(data, status, headers, config) {
		    // this callback will be called asynchronously
		    // when the response is available
		  //$scope.names = data;
		  
		  $scope.tableParams = new ngTableParams({
              page: 1,            // show first page
              count: 10           // count per page
          }, {
              total: data.length, // length of data
              getData: function($defer, params) {
                  $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
              }
          });
		  
	  }).
	  error(function(data, status, headers, config) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
	  });
	
	
}]);