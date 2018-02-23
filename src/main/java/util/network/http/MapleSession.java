package util.network.http;

import mapleCore.exception.MapleSessionException;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by williamallen on 1/22/18.
 */
public class MapleSession {


    /** URL for current session **/
    URL url;

    /** Headers for current session **/
    Map<String, String> headers = new HashMap<>();

    /** Request type for current session **/
    HTTPRequest requestType;

    /** Parameters for current session **/
    HTTPParameterStringBuilder parameters;

    /** Java.net connection object **/
    HttpURLConnection connection;


    /** Cookie manager object **/
    CookieManager cookieManager = new CookieManager();

    /** Connect timeout (5 sec default) **/
    int connectTimeout = 5000;

    /** Connect timeout (5 sec default) **/
    int readTimeout = 5000;


    /** Follow redirects (true default) **/
    boolean followRedirects = true;






    /**
     * Default param
     */
    public MapleSession(){

    }
    /**
     * Init a session with URL and designated request
     */
    public MapleSession(String conURL, HTTPRequest requestType) throws MalformedURLException {
       url = new URL(conURL);
       this.requestType = requestType;
    }

    /**
     * Init a session with URL and designated request type
     */
    public MapleSession(String conURL, HTTPRequest requestType, HTTPParameterStringBuilder parameters) throws MalformedURLException {
        url = new URL(conURL);
        this.requestType = requestType;
        this.parameters = parameters;
    }



    /**
     * Init a session with URL, designated request type and header payload
     */
    public MapleSession(String conURL, HTTPRequest requestType, HTTPParameterStringBuilder parameters, Map<String, String> headers) throws MalformedURLException {
        url = new URL(conURL);
        this.requestType = requestType;
        this.parameters = parameters;
        this.headers = headers;
    }



    /** Set custom cookie policies **/
    public void setCookiePolicy(){




    }





    public void openConnection() throws MapleSessionException, IOException {



        if(requestType == null){
            throw new MapleSessionException("Missing HTTP request type");
        }


        connection = (HttpURLConnection) url.openConnection();
        switch(requestType){
            case GET: connection.setRequestMethod("GET");
            case POST: connection.setRequestMethod("POST");
            case PUT: connection.setRequestMethod("PUT");
            case DELETE: connection.setRequestMethod("DELETE");
            case OPTIONS: connection.setRequestMethod("OPTIONS");
            case TRACE: connection.setRequestMethod("TRACE");

            default: throw new MapleSessionException("Invalid or unsupported HTTP request type " + requestType);
        }








    }

    public void closeConnection() throws MapleSessionException{

    }



    public void setURL(URL url){
        this.url = url;

    }

    public URL getURL(){
        return url;
    }

    public void setRequestType(HTTPRequest requestType){

        this.requestType = requestType;
    }

    public HTTPRequest getRequestType(){
        return requestType;
    }

    public void setParameters(HTTPParameterStringBuilder parameters){
        this.parameters = parameters;

    }

    public HTTPParameterStringBuilder getParameters(){
        return parameters;
    }







}
