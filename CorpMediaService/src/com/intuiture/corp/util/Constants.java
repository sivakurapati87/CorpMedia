package com.intuiture.corp.util;

import java.util.ResourceBundle;

public class Constants {
	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String DATEFORMAT = "dd-MMM-yyyy";
	public static final ResourceBundle RB = ResourceBundle.getBundle("config");
	public static final String SERVICEURL = RB.getString("RESTWebServiceUrl");
	public static final String CAPTCHASTRING = "012345abcdefghijklmnopqurstuvwxyz6789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String ALGO = "AES";
	public static final byte[] KEYVALUE = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };
	public static final String GENID = "ELG";
	public static final String CHANGEPWDPOPUPID = "editProfilePopupId";
	public static final String LINKBLACK = "link_black";
	public static final String LINKLIGHTBLACK = "link_lightblack";
	public static final String CITYTYPE = "cities";
	public static final String MAINCITIESTYPE = "maincities";
	public static final String PROPERTYTYPE = "propertyType";
	public static final String STATESTYPE = "states";
	public static final String UNITSTYPE = "units";
	public static final String APARTMENTS = "apartments";
	public static final String NOTICEPERIODTYPE = "noticeperiod";
	public static final String SPACEAVAILABLE = "spaceAvailable";
	public static final String LISTOFFLOORSTYPE = "listOfFloors";
	public static final String FLOORINGTYPE = "flooring";
	public static final String PROPERTYFACINGTYPE = "propertyFacing";
	public static final String PARKINGFACILITYTYPE = "parkingFacility";
	public static final String AGEOFCONSTRUCTIONTYPE = "ageOfConstruction";
	public static final String COMMERCIALEXTERNALFACILITIESTYPE = "commercialExternalFacilities";
	public static final String COMMERCIALFURNISHEDTYPE = "commercialFurnished";
	public static final String COMMERCIALFACILITIESTYPE = "commercialFicilities";
	public static final String LANDFACILITIESTYPE = "landFicilities";
	public static final String LANGUAGESKNOWNTYPE = "languagesKnown";
	public static final String COMMERCIAL = "commercial";
	public static final String RESIDENTIAL = "residential";
	public static final String LANDS = "lands";
	public static final String PENTHOUSE = "Penthouse";
	public static final String BEDROOMSTYPE = "bedroomsList";
	public static final String ATTACHEDBATHROOMSTYPE = "attachedBathRoomsList";
	public static final String COMMONBATHROOMSTYPE = "commonBathRoomsList";
	public static final String DRAWINGROOMAMENITIESTYPE = "drawingRoomAmenities";
	public static final String BEDROOMAMENITIESTYPE = "bedroomAmenities";
	public static final String KITCHENAMENITIESTYPE = "kitchenAmenities";
	public static final String DININGROOMAMENITIESTYPE = "diningRoomAmenities";
	public static final String BATHROOMAMENITIESTYPE = "bathRoomAmenities";
	public static final String MISCITEMSAMENITIESTYPE = "miscItemsAmenities";
	public static final String DOGSRESTRICTIONTYPE = "dogsRestriction";
	public static final String CATSRESTRICTIONTYPE = "catsRestriction";
	public static final String SMOKINGRESTRICTIONTYPE = "smokingRestriction";
	public static final String RESIDENTIALFURNISHEDTYPE = "residentialFurnished";
	public static final String GMAPURL = "http://maps.googleapis.com/maps/api/geocode/json?address=";
	public static final Integer REQUIREDHEIGHT = 620;
	public static final Integer RECORDSPERPAGE = 8;
	public static final String COMPANYJSONFILE = "\\companies.txt";
	public static final String BANKJSONFILE = "\\banks.txt";
	public static final String SIGNATORSJSONFILE = "\\signators.txt";
	public static final String UPLOADEDVIDEOSPATH = "\\EasyLotUploads\\videos";
	public static final String UPLOADEDDOCPATH = "\\EasyLotUploads\\documents";

	public static class Login {
		public static final String LOGINACTION = SERVICEURL + "/LoginController/loginAction";
		public static final String GETPWDACTION = SERVICEURL + "/LoginController/getPasswordAction";
	}
}
