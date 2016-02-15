'use strict';

App.factory('PFInfoService', ['$http', '$q', function($http, $q){
var selectedCompany={};
	return {
		
			getPFInfo:function(companyId){
				return $http.get(constants.localhost_port+'/CorpMediaService/PFController/findAllCompanyPF/'+companyId)
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
			getSelectedCompany:function(){
				return $http.get(constants.localhost_port+'/CorpMedia/CompanyInfoController/getSelectedCompany')
				.then(
				function(response){
					return response.data;
						}, 
				function(errResponse){
					console.error('Error while getSelectedCompany from bean');
					return $q.reject(errResponse);
						}
					);
			}
	};

}]);
