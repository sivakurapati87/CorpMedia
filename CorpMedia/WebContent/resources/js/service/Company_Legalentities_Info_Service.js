'use strict';

App.factory('Company_Legalentities_Info_Service', ['$http', '$q', function($http, $q){
var selectedCompany={};
	return {
		
			getCompanyInfo:function(companyName){
				return $http.get(constants.localhost_port+'/CorpMediaService/CompanyController/getCompanyInfo/'+companyName)
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
