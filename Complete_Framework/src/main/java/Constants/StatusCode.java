package Constants;

public class StatusCode {

	//level 200
	public static final int OK = 200;
	
    public static final int Created = 201;
	
	public static final int Non_Authoritative_Information = 203;
	
	public static final int No_Content = 204;
	
	//level 300 - Redirection
    public static final int Permanent_Redirect = 301;
	
    public static final int Temporary_Redirest = 302;
	
	public static final int Not_Modified = 304;
	
	//level 400 - Client Error
    public static final int Unauthorized_Error = 401;
	
    public static final int Forbidden = 403;
	
	public static final int Not_Found = 404;
	
	public static final int Method_Not_Allowed = 405;
	
	//level 400 - Server Error
    public static final int Not_Implemented = 501;
	
    public static final int Bad_Gateway = 502;
	
	public static final int Service_Unavailable = 503;
	
	public static final int Gateway_Timeout = 504;
	
}
