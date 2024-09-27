package api.endpoint;
//https://petstore.swagger.io
public class Routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	
	//user module
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";

//store module url
	//https://petstore.swagger.io/v2/store/order
	// get request https://petstore.swagger.io/v2/store/order/5
	//store/order/{orderId}
	///store/order/{orderId}
	public static String post1_url= base_url+"/store/order";
	
	public static String get1_url= base_url+"/store/order/{orderId}";
	public static String delete1_url=base_url+"/store/order/{orderId}";
	
	
	
	
	
	
	}

	
	
	
	
	//here you will create pet url



	

