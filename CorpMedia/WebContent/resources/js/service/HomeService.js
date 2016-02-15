'use strict';
//var localhost_port= 'http://122.175.45.182:8090';
App.factory('HomeService', ['$http', '$q', function($http, $q){
var selectedCompany={};
	return {
		
//			searchAction: function(searchObj) {//Fetches category list from server.
//				return $http.post(constants.localhost_port+'/CorpMediaService/SearchController/searchAction',searchObj)
//					.then(
//								function(response){
//									return response.data;
//								}, 
//								function(errResponse){
//									console.error('Error while search Action');
//									return $q.reject(errResponse);
//								}
//						);
//			},
			contriesList:function(){
				return $http.get(constants.localhost_port+'/CorpMediaService/CompanyController/findAllCompanies')
				.then(
				function(response){
					return response.data;
						}, 
				function(errResponse){
					console.error('Error while find all companies Action');
					return $q.reject(errResponse);
						}
					);
			},
			insertSelectedCompany:function(cmp){
				return $http.get(constants.localhost_port+'/CorpMedia/CompanyInfoController/setSelectedCompany/'+cmp)
				.then(
				function(response){
					return response.data;
						}, 
				function(errResponse){
					console.error('Error while insertSelectedCompany into the bean');
					return $q.reject(errResponse);
						}
					);
//			},
//			setSelectedCompany: function (sCompany) {
//				selectedCompany = sCompany;
//			},
//			getSelectedCompany: function () {
//				return selectedCompany;
			}
	};

}]);
