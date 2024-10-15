package com.eergun.mobilet.constants;

public class RestApis {

    private static final String VERSION = "/v1";
    private static final String DEVELOPER = "/dev";

    private static final String ROOT = VERSION + DEVELOPER;

    public static final String ANONYMOUS = ROOT + "/anonymous";
    public static final String CARD = ROOT + "/card";
    public static final String CARDUSER = ROOT + "/carduser";
    public static final String VEHICLE = ROOT + "/vehicle";
    public static final String CARDWITHBALANCE = ROOT + "/card-with-balance";
    public static final String TAPPING = ROOT + "/tapping";
    public static final String CARD_WITH_DISCOUNT = ROOT + "/card-with-discount";
    public static final String CARD_WITH_SUBSCRIPTION = ROOT + "/card-with-subscription";
    
    public static final String GETALL = "/getall";
    public static final String FINDBYCARDSERIALNUMBER = "/find-by-card-serial-number";
    public static final String ODEME = "/odeme";
    
   
    public static final String PAY = "/pay";
    public static final String ADD = "/add";
}