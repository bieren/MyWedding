package test;

import java.security.MessageDigest;
import java.util.ArrayList;

import org.junit.Test;

import com.google.gson.Gson;
import com.sp.utils.HttpRequestUtils;

public class Test_HttpRequest {

	
	String localUrl = "http://127.0.0.1:8080/";
	
	String Url120 = "http://120.77.101.181:8080/";
	
	class ProductOfferInfo{
		protected String id;
		protected String selected;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getSelected() {
			return selected;
		}
		public void setSelected(String selected) {
			this.selected = selected;
		}
		
	}
	public final static String MD51(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	
	
	@Test
	public void test15(){}
	
	
	@Test
	public void test121(){
//		before();
		
		ProductOfferInfo productOfferInfo = null;
		
		ArrayList<ProductOfferInfo> arrayList = new ArrayList<ProductOfferInfo>();
		
		
		for (int i = 1; i < 6; i++) {
			productOfferInfo = new ProductOfferInfo();
			
			productOfferInfo.setId(""+i);
			
			productOfferInfo.setSelected(""+(i%2==0?1:0));
			
			arrayList.add(productOfferInfo);
			
		}
		
		String jsonStr =new Gson().toJson(arrayList);
		System.out.println(jsonStr);
		
	}
	
	@Test
	public void test122(){}
	
	
	
	
	
	
	
	

	@Test
	public void test50_addProdSpecComment(){
//		String productSpecId, String comment,String orderId
		String para1 = "productSpecId=46&comment=asdasdasdasd&orderId=567";
		String url2 = localUrl+"OpenAPI/user/customer/addProdSpecComment";
		
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTMxNzgzOTI3ODIsInVpZCI6IjUiLCJpYXQiOjE0OTE4ODIzOTI3ODJ9.vPLh5n15Xl4ewchEyH_vO_0hfpyvRDdmBqB6UxVvnuA";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}
	@Test
	public void test50_getProdOfferLog(){
//		String prodCatName,String placeId,String prodSpecType, String date
		String para1 = "prodCatName=今日菜品&placeId=2&prodSpecType, date";
		String url2 = localUrl+"OpenAPI/user/customer/getProdOfferLog";
//		String url2 = Url120+"OpenAPI/user/customer/getProdOfferLog";
		
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTE2MTM3MzczMTcsInVpZCI6IjIiLCJpYXQiOjE0OTAzMTc3MzczMTd9.LTwPeMh0wK7hGSsPQqPLDLLf-xaGywXxb2Kjh1wHKOw";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}

	@Test
	public void test50_setProductOfferPlace(){
		String para1 = "placeId=1&productOfferInfo=[{'id':'1','selected':'0'},{'id':'2','selected':'1'},{'id':'3','selected':'0'},{'id':'4','selected':'1'},{'id':'5','selected':'0'}]";
		String url2 = localUrl+"OpenAPI/user/customer/setProductOfferPlace";
//		String url2 = Url120+"OpenAPI/user/customer/setProductOfferPlace";
		
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTE2MTM3MzczMTcsInVpZCI6IjIiLCJpYXQiOjE0OTAzMTc3MzczMTd9.LTwPeMh0wK7hGSsPQqPLDLLf-xaGywXxb2Kjh1wHKOw";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}

//	

	@Test
	public void test50_getBundledProdOfferAndCandidateProdSpec(){
		String para1 = "productOfferId=333";
		String url2 = localUrl+"OpenAPI/user/customer/getBundledProdOfferAndCandidateProdSpec";
//		String url2 = "http://192.168.3.18:8080/OpenAPI/user/customer/getBundledProdOfferAndCandidateProdSpec";
		
		
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTM5NDk1MjQxODUsInVpZCI6IjU5IiwiaWF0IjoxNDkyNjUzNTI0MTg1fQ.S2VODv7DVtzfh8op805OWsF3V8uem-X_6GgmW9n2y-U";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}


	@Test
	public void test50_getBundledProdOfferOption(){
		String para1 = "productOfferId=333";
		String url2 = localUrl+"OpenAPI/user/customer/getBundledProdOfferOption";
//		String url2 = "http://192.168.3.18:8080/OpenAPI/user/customer/getBundledProdOfferOption";
		
		
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTM5NDk1MjQxODUsInVpZCI6IjU5IiwiaWF0IjoxNDkyNjUzNTI0MTg1fQ.S2VODv7DVtzfh8op805OWsF3V8uem-X_6GgmW9n2y-U";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}


	@Test
	public void test49_getCandidateProdSpec(){
		String para1 = "prodSpecId=263&type=备选";
		String url2 = localUrl+"OpenAPI/user/customer/getCandidateProdSpec";
		
		
//		2017年3月7日 20:45:24		OpenAPI/user/customer/transfer
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTM5NDk1MjQxODUsInVpZCI6IjU5IiwiaWF0IjoxNDkyNjUzNTI0MTg1fQ.S2VODv7DVtzfh8op805OWsF3V8uem-X_6GgmW9n2y-U";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}


	@Test
	public void test48_suspendIdentCard(){
		String para1 = "cardNum=1985257008";//卡内号
		String url2 = localUrl+"OpenAPI/user/customer/suspendIdentCard";
		
		
//		2017年3月7日 20:45:24		OpenAPI/user/customer/transfer
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTEzMDY1MTMwNzEsInVpZCI6IjMiLCJpYXQiOjE0OTAwMTA1MTMwNzF9.wpJ0II9Lz0b9P49d1WevV0ABhyXTkFc0YRGE047i20o";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}

	

	

	@Test
	public void test47_activateIdentCard(){
		String para1 = "cardNum=00003998";//卡面号
		String url2 = localUrl+"OpenAPI/user/customer/activateIdentCard";
		
		
//		2017年3月7日 20:45:24		OpenAPI/user/customer/transfer
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTEzMDY1MTMwNzEsInVpZCI6IjMiLCJpYXQiOjE0OTAwMTA1MTMwNzF9.wpJ0II9Lz0b9P49d1WevV0ABhyXTkFc0YRGE047i20o";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}

	

	

	@Test
	public void test46_resumeIdentCard(){
		String para1 = "cardNum=1985209856";//卡内号
		String url2 = localUrl+"OpenAPI/user/customer/resumeIdentCard";
		
		
//		2017年3月7日 20:45:24		OpenAPI/user/customer/transfer
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTI4MjM3NDMxMDUsInVpZCI6IjMiLCJpYXQiOjE0OTE1Mjc3NDMxMDV9.3v7qxl2R1hLiFOUD3hQiOvo34zphM544UQzyi1NcFFo";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}


	@Test
	public void test46_applyIdentCard(){
		String para1 = "paymentMethodId=1";
//		String url2 = Url120+"OpenAPI/user/customer/applyIdentCard";
		String url2 = "http://120.77.101.181/OpenAPI/user/customer/applyIdentCard";
		
		
//		2017年3月7日 20:45:24		OpenAPI/user/customer/transfer
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTI4NDY1ODQ1NDgsInVpZCI6IjUiLCJpYXQiOjE0OTE1NTA1ODQ1NDh9.UHssxK0DrDtC1nM4f6q32SiJKZUHjJGrHPU21au4jXk";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}

	
	

	@Test
	public void test45_listIdentCard(){
		String para1 = "aaaa=1111";
//		String url2 = "http://localhost:8080/OpenAPI/user/customer/getPartyRoleAssociation";
		String url2 = Url120+"OpenAPI/user/customer/listIdentCard";
//		String url2 = "http://120.77.101.181/OpenAPI/user/customer/listIdentCar";
		
		
//		2017年3月7日 20:45:24		OpenAPI/user/customer/transfer
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTI4Mjg5Mjg1MDUsInVpZCI6IjUiLCJpYXQiOjE0OTE1MzI5Mjg1MDV9.MbA8zuvHsj3TTVqmVwOdHxoQ3Qfagz48IVsGE0EQSI0";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}

	
	@Test
	public void test44_getPartyRoleAssociation(){
		String para1 = "involvePartyRoleId=3&type=企业-员工 雇用关系&pages=1&dataSize=10";
//		String url2 = "http://localhost:8080/OpenAPI/user/customer/getPartyRoleAssociation";
		String url2 = Url120+"OpenAPI/user/customer/getPartyRoleAssociation";
		
		
//		2017年3月7日 20:45:24		OpenAPI/user/customer/transfer
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTAxODc3MTM3NzMsInVpZCI6IjIiLCJpYXQiOjE0ODg4OTE3MTM3NzN9.-NdDjrdB_6xn4u1CiFxz877PMHqH79MwIy5mt7ETq0c";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}


	@Test
	public void test43_getMessageCenter(){
	
//			String name ,String placeId, String pages, String dataSize

		String para1 = "";
		String url2 = localUrl+"OpenAPI/user/customer/getMessageCenter";
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTAxODc3MTM3NzMsInVpZCI6IjIiLCJpYXQiOjE0ODg4OTE3MTM3NzN9.-NdDjrdB_6xn4u1CiFxz877PMHqH79MwIy5mt7ETq0c";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}
	



	@Test
	public void test42_transfer(){
	
//			String name ,String placeId, String pages, String dataSize

		String para1 = "oppositeMobile=15975294470&amount=1&pwd=123456";
		String url2 = localUrl+"OpenAPI/user/customer/transfer";
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTAxODc3MTM3NzMsInVpZCI6IjIiLCJpYXQiOjE0ODg4OTE3MTM3NzN9.-NdDjrdB_6xn4u1CiFxz877PMHqH79MwIy5mt7ETq0c";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}
	


	@Test
	public void test41_iWantRecharge(){
	
//			String name ,String placeId, String pages, String dataSize

		String para1 = "prodSpecType=个人充值";
		String url2 = "http://192.168.3.18/OpenAPI/user/customer/iWantRecharge";
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTE2MTM3MzczMTcsInVpZCI6IjIiLCJpYXQiOjE0OTAzMTc3MzczMTd9.LTwPeMh0wK7hGSsPQqPLDLLf-xaGywXxb2Kjh1wHKOw";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}
	

	@Test
	public void test40_serviceCenter(){
	
//			String name ,String placeId, String pages, String dataSize

		String para1 = "";
		String url2 = localUrl+"OpenAPI/user/customer/serviceCenter";
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTAxODc3MTM3NzMsInVpZCI6IjIiLCJpYXQiOjE0ODg4OTE3MTM3NzN9.-NdDjrdB_6xn4u1CiFxz877PMHqH79MwIy5mt7ETq0c";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}



	@Test
	public void test39_voteProdOffers(){
	
//			String name ,String placeId, String pages, String dataSize

		String para1 = "name=集体食堂&prodOfferingId=1";
		String url2 = localUrl+"OpenAPI/user/customer/voteProdOffers";
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTMxNzgzOTI3ODIsInVpZCI6IjUiLCJpYXQiOjE0OTE4ODIzOTI3ODJ9.vPLh5n15Xl4ewchEyH_vO_0hfpyvRDdmBqB6UxVvnuA";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}


	@Test
	public void test38_getProdCatProdOffers(){
	
//			String name ,String placeId, String pages, String dataSize

		String para1 = "placeId=1&name=我要投票&pages=1&dataSize=3";
		String url2 = "http://120.77.101.181/OpenAPI/user/customer/getProdCatProdOffers";
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTAxODc3MTM3NzMsInVpZCI6IjIiLCJpYXQiOjE0ODg4OTE3MTM3NzN9.-NdDjrdB_6xn4u1CiFxz877PMHqH79MwIy5mt7ETq0c";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}



	@Test
	public void test37_getProdCategory(){
	
//		String name,String placeId,String prodSpecType,String time,String pages,String dataSize

		String para1 = "placeId=2&prodCatalogType=默认";
		String url2 = "http://36ee0b77.ittun.com/OpenAPI/user/customer/getProdCategory";
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTEwMzQzNzgxODgsInVpZCI6IjMiLCJpYXQiOjE0ODk3MzgzNzgxODh9.9Fk4aKWUXbiXMfU_F0tpWgCCP9joZZG7W9sAYrkncMU";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}


	@Test
	public void test36_getProdCatProdOffersBySpecTypeAndTime(){
	
//		String name,String placeId,String prodSpecType,String time,String pages,String dataSize
//		name,placeId,prodSpecType,time,pages,dataSize,prodCatalogType,endDate
		String para1 = "name=今日菜品&placeId=2&prodSpecType=主菜&time=2017-03-29 00:00:00&endDate=2017-03-30 23:59:59";//&prodCatalogType=午餐
//		String url2 = localUrl+"OpenAPI/user/customer/getProdCatProdOffersBySpecTypeAndTime";
		String url2 = "http://120.77.101.181/OpenAPI/user/customer/getProdCatProdOffersBySpecTypeAndTime";
		
		
		
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTE2MTM3MzczMTcsInVpZCI6IjIiLCJpYXQiOjE0OTAzMTc3MzczMTd9.LTwPeMh0wK7hGSsPQqPLDLLf-xaGywXxb2Kjh1wHKOw";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}

	@Test
	public void test35_getPCService(){
	
//		String placeId, String pages, String orderNumb, String dataSize, String date
		String para1 = "placeId=1&orderNumb=1&&date=2017-03-09&pages=1&dataSize=3";
		String url2 = localUrl+"OpenAPI/user/personal/getPCService";
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTAxODc3MTM3NzMsInVpZCI6IjIiLCJpYXQiOjE0ODg4OTE3MTM3NzN9.-NdDjrdB_6xn4u1CiFxz877PMHqH79MwIy5mt7ETq0c";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}


	@Test
	public void test34_getAllRestaurant(){
	
	
		String para1 = "placeRole=我的餐厅&pages=1&dataSize=5";
		String url2 = localUrl+"OpenAPI/user/personal/getAllRestaurant";
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTAxODc3MTM3NzMsInVpZCI6IjIiLCJpYXQiOjE0ODg4OTE3MTM3NzN9.-NdDjrdB_6xn4u1CiFxz877PMHqH79MwIy5mt7ETq0c";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}



	@Test
	public void test33_homeDataByCustomer(){
	
	
		String para1 = "";
		String url2 = localUrl+"OpenAPI/user/personal/homeDataByCustomer";
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTAxODc3MTM3NzMsInVpZCI6IjIiLCJpYXQiOjE0ODg4OTE3MTM3NzN9.-NdDjrdB_6xn4u1CiFxz877PMHqH79MwIy5mt7ETq0c";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}


	@Test
	public void test32_homeDataByArea(){
	
	
		String para1 = "area=广州";
		String url2 = "http://127.0.0.1:8080/OpenAPI/system/homeDataByArea";
//		2017年3月7日 20:45:24
	    String token1 = "";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}

	@Test
	public void test31_getProdCatProdOfferByProdSpecType(){
	
	
		String para1 = "name=今日菜品&placeId=3&prodSpecType=主菜&pages=1&dataSize=2";
//		String para1 = "name=今日菜品&placeId=3&prodSpecType=主菜";
		String url2 = localUrl+"OpenAPI/user/customer/getProdCatProdOfferByProdSpecType";
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTAxODc3MTM3NzMsInVpZCI6IjIiLCJpYXQiOjE0ODg4OTE3MTM3NzN9.-NdDjrdB_6xn4u1CiFxz877PMHqH79MwIy5mt7ETq0c";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}

	@Test
	public void test30_getCustomerAccountList(){
	
	
		String para1 = "";
		String url2 = "http://127.0.0.1:8080/OpenAPI/user/customer/getCustomerAccountList";
//		2017年2月23日 20:52:29
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODkxNTA4MTgxMDAsInVpZCI6IjYiLCJpYXQiOjE0ODc4NTQ4MTgxMDB9._Q-DMCFb9GSg4_JpXNw2QtT40MllDYJgbAj3gVOPFz8";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}


	@Test
	public void test29_requestHomePageData(){
	
	
		String para1 = "placeRole=集体食堂&name=集体食堂&type=集体食堂&longitude=113.489044&latitude=23.193368&contentType=APP&subType=轮播图&pages=2&dataSize=5";
		String url2 = localUrl+"OpenAPI/user/customer/requestHomePageData";
		

//        String url2 = "http://192.168.3.18:8080/OpenAPI/user/customer/requestHomePageData";
		
//		2017年2月23日 20:52:29
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTQwNTUwMDUzMTgsInVpZCI6IjgiLCJpYXQiOjE0OTI3NTkwMDUzMTh9.z0nIT2V7wTL4XyhPWPYWQaIQd5grfDGcf6Csw4kXmDo";

		//2017年3月24日 11:09:46  天堂秀
//	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTE2MjA5MjUyNDAsInVpZCI6IjEwIiwiaWF0IjoxNDkwMzI0OTI1MjQwfQ.mEuPzjT5Vid81tDHs3X0Q93AvF8O_k-wUgHa4PailhE";
		
	    
	    
	    
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	    
//	    for (int i = 0; i < 100; i++) {}
	    
	    
	}


	
	@Test
	public void test28_myBalance(){


		String para1 = "";
        String url2 = localUrl+"OpenAPI/user/customer/myBalance";
        //2017年3月6日 17:08:02
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTAxNTQ0MDY4NjEsInVpZCI6IjIiLCJpYXQiOjE0ODg4NTg0MDY4NjF9.3E3ivf0fYcsA2-9cQvJyCnq3lHFGKBoOx3Hsg74E2SU";

        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}

	
	@Test
	public void test27_login(){


		String para1 = "username=15322066687&pwd=123456";
        String url2 = Url120+"OpenAPI/device/login";
//        String url2 = localUrl+"OpenAPI/device/login";
        
        String sr=HttpRequestUtils.sendPost(url2,para1,false,null);
        System.out.println(sr);
	}
	
	
	/**
	 * 通过用户名和密码登录
	 * loginByPhone
	 * loginNr	账号	String	
	 * pwd	密码	String	
	 */
	@Test
	public void test26_enterpriseLogin(){


		String para1 = "loginNr=15322066687&pwd=123456";
//        String url2 = Url120+"OpenAPI/system/enterpriseLogin";
        String url2 = localUrl+"OpenAPI/system/enterpriseLogin";
        
        String sr=HttpRequestUtils.sendPost(url2,para1,false,null);
        System.out.println(sr);
	}
	
	
	@Test
	public void test25_Enterprise_getPromotionProdOffer(){
//获取含有促销字样的产品提供
		String para1 = "prodSpecType=企业充值劵";
      String url2 = "http://127.0.0.1:8080/OpenAPI/user/customer/getPromotionProdOffer";
//		String url2 = Url120+"OpenAPI/user/customer/getPromotionProdOffer";

        
        //2017-3-2 14:47:01
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTEwMzQzNzgxODgsInVpZCI6IjMiLCJpYXQiOjE0ODk3MzgzNzgxODh9.9Fk4aKWUXbiXMfU_F0tpWgCCP9joZZG7W9sAYrkncMU";
//      String token1 = null;
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}
	

	
	@Test
	public void test25_addCustEmployee(){

		String para1 = "info={'loginName': '1356031111','name': '昵称','gender': 1,'identNr':'123456789012345678','post': '职务','placeOfBirth': '广东省广州市白云区'}"; 
//		String url2 = "http://localhost:8080/OpenAPI/user/customer/addCustEmployee";
		String url2 = Url120+"OpenAPI/user/customer/addCustEmployee";

        
        //2017-3-2 14:47:01
		String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTEwMzYxMDg3NzMsInVpZCI6IjMiLCJpYXQiOjE0ODk3NDAxMDg3NzN9.78on4o4AzLW1MxHIhExDUu4SoIp3b14LS-2gpn7Az00";
		//      String token1 = null;
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}
	

	
	@Test
	public void test25_addProspect(){

		String para1 = "info={'name':'刘明','mobile':'15623502912','comment':'企业地址：东辉花园，预计人员数量：300，单人次餐费预算：1000w，配餐要求说明：优先配送噼里啪啦等','corporation':'思普计算机'}";
//      String url2 = "http://localhost:8080/OpenAPI/system/addProspect";
		String url2 = Url120+"OpenAPI/system/addProspect";

        
        //2017-3-2 14:47:01
      String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTEwMzQzNzgxODgsInVpZCI6IjMiLCJpYXQiOjE0ODk3MzgzNzgxODh9.9Fk4aKWUXbiXMfU_F0tpWgCCP9joZZG7W9sAYrkncMU";
		//      String token1 = null;
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}
	

	
	@Test
	public void test25_getAllProdCatProdOffers3(){

		String para1 = "name=我要投票&placeId=1&prodSpecType=主菜&date=2017-3-2 14:40:01";
      String url2 = "http://192.168.3.20/OpenAPI/user/customer/getAllProdCatProdOffers";
//		String url2 = "http://120.77.101.181/OpenAPI/user/customer/getAllProdCatProdOffers";
		
		
		
//		String url2 = Url120+"OpenAPI/device/echo";

        
        //2017-3-2 14:47:01
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODk3MzMwODM4OTcsInVpZCI6IjMiLCJpYXQiOjE0ODg0MzcwODM4OTd9.LdyVGUW7slOyKzsWEKrrS8xBYKbRyV6wrmQt91r1ORk";
//      String token1 = null;
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}
	

	
	@Test
	public void test25_getAllProdCatProdOffers4(){

		String para1 = "name=今日菜品&placeId=1&prodSpecType=主菜&date=2017-3-2 14:40:01";
      String url2 = "http://192.168.254.123:8080/OpenAPI/user/customer/getAllProdCatProdOffers";
//		String url2 = Url120+"OpenAPI/device/echo";

        
        //2017-3-2 14:47:01
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODk3MzMwODM4OTcsInVpZCI6IjMiLCJpYXQiOjE0ODg0MzcwODM4OTd9.LdyVGUW7slOyKzsWEKrrS8xBYKbRyV6wrmQt91r1ORk";
//      String token1 = null;
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}
	

	
	@Test
	public void test25_getAllProdCatProdOffers(){

		String para1 = "name=今日菜品&placeId=1&prodSpecType=主菜&date=2017-3-2 14:40:01&pages=1&dataSize=10";
//		{"name":"我要投票","placeId":"1","date":"2017-3-15 12:54:00","pages":"1","dataSize":"10"}
      String url2 = "http://120.77.101.181/OpenAPI/user/customer/getAllProdCatProdOffers";
//		String url2 = localUrl+"OpenAPI/user/customer/getAllProdCatProdOffers";

        
        //2017-3-2 14:47:01
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTA4NTE3MTY4NDMsInVpZCI6IjMiLCJpYXQiOjE0ODk1NTU3MTY4NDN9.pXfIkmJ4aLCYc3njGEYNabVROZO5mE51jCsk57lZebQ";
//      String token1 = null;
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}
	
	@Test
	public void test24_Device_echo(){

		String para1 = "echo=name";
      String url2 = localUrl+"OpenAPI/device/echo";
//		String url2 = Url120+"OpenAPI/device/echo";

        
        //2017年2月6日 17:08:02
//        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODc2Njc4OTMyODcsInVpZCI6IjIiLCJpYXQiOjE0ODYzNzE4OTMyODd9.holffxFkUkFgqGQKDaPmBbwONVR8SEx0VWT7dvnj6kI";
        String token1 = null;
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}
	

	@Test
	public void test23_Device_getProductUserById(){

		String para1 = "deviceId=105&placeId=1&partyRoleId=55";
      String url2 = "http://127.0.0.1:8080/OpenAPI/device/getProductUserById";
//      String url2 = Url120+"OpenAPI/device/getProductUserById";
		
        //2017年2月6日 17:08:02
//        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODc2Njc4OTMyODcsInVpZCI6IjIiLCJpYXQiOjE0ODYzNzE4OTMyODd9.holffxFkUkFgqGQKDaPmBbwONVR8SEx0VWT7dvnj6kI";
        String token1 = null;
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}
	
	
	
	//智能餐台刷卡
	@Test
	public void test22_Device_productUsage(){
//	public static void main(String[] args){

//		String para1 = "partyRoleId=3&productIdList=2_3_4_5&requestId=2_20170227_1&time=2017-02-22 16:40:12";//离线重连
		String para1 = "partyRoleId=8&productIdList=5570&requestId=1_20170407_2";//在线扣费
//        String url2 = localUrl+"OpenAPI/user/customer/productUsage";
		String url2 = "http://120.77.101.181/OpenAPI/user/customer/productUsage";
		
//        String url2 = Url120+"OpenAPI/device/productUsage";
        
        //2017年2月6日 17:08:02
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTI4NDY1ODQ1NDgsInVpZCI6IjUiLCJpYXQiOjE0OTE1NTA1ODQ1NDh9.UHssxK0DrDtC1nM4f6q32SiJKZUHjJGrHPU21au4jXk";
//        String token1 = null;
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}

	//智能餐台初始化
//	@Test
	
	@Test
	public void test21_Device_init(){
//	public static void main(String[] args){

		String para1 = "deviceId=1&placeId=1";
//      String url2 = localUrl+"OpenAPI/device/init";
      String url2 = Url120+"OpenAPI/device/init";
		
        //2017年2月6日 17:08:02
//        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODc2Njc4OTMyODcsInVpZCI6IjIiLCJpYXQiOjE0ODYzNzE4OTMyODd9.holffxFkUkFgqGQKDaPmBbwONVR8SEx0VWT7dvnj6kI";
        String token1 = null;
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}
	
	
		
		//获取热门问题详情页
		@Test
		public void test20_getFreqAskedQuestList(){

			String para1 = "type=取餐问题";
			 String url2 = localUrl+"OpenAPI/user/customer/getFreqAskedQuestList";
			 
//				2017年3月7日 20:45:24
			    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTAxODc3MTM3NzMsInVpZCI6IjIiLCJpYXQiOjE0ODg4OTE3MTM3NzN9.-NdDjrdB_6xn4u1CiFxz877PMHqH79MwIy5mt7ETq0c";
			

	        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	        System.out.println("test:"+sr);
		}
	

		@Test
		public void test19_getCustOrderDetail(){

			String para1 = "custOrderId=39";

			String url2 = "http://120.77.101.181/OpenAPI/user/customer/getCustOrderDetail";
			//15975294479  ID7
//			String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODkxMTM3MDkxNjUsInVpZCI6IjciLCJpYXQiOjE0ODc4MTc3MDkxNjV9.QO8h9g2X7Miah6FMg8oZGIsSAlJS5RL-hF1AbRshbyY";
			
//			13560389295  ID2
			String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODkxMzEzNDA3NTcsInVpZCI6IjIiLCJpYXQiOjE0ODc4MzUzNDA3NTd9.Mq2xzCVctw0z_IV89By4n5EAtyQfg25sPYxF5K_rqLw";
			
			
			
//			String url2 = "http://120.77.101.181/OpenAPI/user/customer/getCustOrderList";
//		    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODYxMTE5NjUxODAsInVpZCI6IjIiLCJpYXQiOjE0ODQ4MTU5NjUxODB9.FWyuC6N0TJdbhj0OLyHDTDvZZq9Ll51kh41wzhBgB1M";

		    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
//		    CustomerOrderStatus
		    System.out.println("test:"+sr);
		}
		

	@Test
	public void test18_getCustOrderList(){

		String para1 = "prodCatalogType=FL&pages=1&dataSize=10";

		String url2 = localUrl+"OpenAPI/user/customer/getCustOrderList";
		//15975294479  ID7
//		String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODkxMTM3MDkxNjUsInVpZCI6IjciLCJpYXQiOjE0ODc4MTc3MDkxNjV9.QO8h9g2X7Miah6FMg8oZGIsSAlJS5RL-hF1AbRshbyY";
		
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTAxODc3MTM3NzMsInVpZCI6IjIiLCJpYXQiOjE0ODg4OTE3MTM3NzN9.-NdDjrdB_6xn4u1CiFxz877PMHqH79MwIy5mt7ETq0c";
		
		
		
//		String url2 = "http://120.77.101.181/OpenAPI/user/customer/getCustOrderList";
//	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODYxMTE5NjUxODAsInVpZCI6IjIiLCJpYXQiOjE0ODQ4MTU5NjUxODB9.FWyuC6N0TJdbhj0OLyHDTDvZZq9Ll51kh41wzhBgB1M";

	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
//	    CustomerOrderStatus
	    System.out.println("test:"+sr);
	}
	
	

	@Test
	public void test17_custOrderClosing(){

		String para1 = "custOrderId=3";

		String url2 = "http://192.168.254.120:8080/OpenAPI/user/customer/custOrderClosing";
//		String url2 = "http://120.77.101.181/OpenAPI/user/customer/gotoOrdering";

		//15975294479  ID7
//		String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODkxMTM3MDkxNjUsInVpZCI6IjciLCJpYXQiOjE0ODc4MTc3MDkxNjV9.QO8h9g2X7Miah6FMg8oZGIsSAlJS5RL-hF1AbRshbyY";
		
//		13560389295  ID2
		String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODkxMzEzNDA3NTcsInVpZCI6IjIiLCJpYXQiOjE0ODc4MzUzNDA3NTd9.Mq2xzCVctw0z_IV89By4n5EAtyQfg25sPYxF5K_rqLw";
		
		
//		String url2 = "http://120.77.101.181/OpenAPI/user/customer/gotoOrdering";

	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}


	@Test
	public void test16_getShoppingCartTotalAmount(){

		//String para1 = "prodofferList=[{'id':'deee4167-2682-4643-9a50-2723123deaeb','prodOfferId':'33','prodSpecId':'39','applicableDate':'2017-03-27 20:10:47.816'},{'id':'871f3b28-1ef4-4238-9273-1fc27b9baa90','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'20','prodSpecId':'20','applicableDate':'2017-03-27 20:10:47.816'},{'id':'8876fbc2-a5a0-4c3d-b903-be6b48011660','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'50','prodSpecId':'22','applicableDate':'2017-03-27 20:10:47.816'},{'id':'3cf1019c-4094-4ff7-80be-5b594552d75c','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'51','prodSpecId':'12','applicableDate':'2017-03-27 20:10:47.816'},{'id':'eefe4d7b-5f82-47c4-ada0-8f01e204c527','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'53','prodSpecId':'37','applicableDate':'2017-03-27 20:10:47.816'},{'id':'a9b7ca0f-6969-424a-aa35-ce5a05465ad7','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'54','prodSpecId':'26','applicableDate':'2017-03-27 20:10:47.816'},{'id':'e6bf1f37-c420-4c57-babe-8a35666a994d','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'52','prodSpecId':'14','applicableDate':'2017-03-27 20:10:47.816'}]";

		String para1 = "prodofferList=5_8";

//		String url2 = localUrl+"OpenAPI/user/customer/getShoppingCartTotalAmount";
		String url2 = "http://120.77.101.181/OpenAPI/user/customer/getShoppingCartTotalAmount";

//      String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTE2MTM3MzczMTcsInVpZCI6IjIiLCJpYXQiOjE0OTAzMTc3MzczMTd9.LTwPeMh0wK7hGSsPQqPLDLLf-xaGywXxb2Kjh1wHKOw";
  
		
//		String url2 = "http://120.77.101.181/OpenAPI/user/customer/gotoOrdering";
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTE5ODExMDY5NTcsInVpZCI6IjIiLCJpYXQiOjE0OTA2ODUxMDY5NTd9.0qn4IH12wBG1MNlot3KTsn_YQ2fQcQhLeYZJi2_u85g";

	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}
	


	@Test
	public void test16_gotoOrdering(){

//		String para1 = "gotoOrderList=[{'id':'deee4167-2682-4643-9a50-2723123deaeb','prodOfferId':'33','prodSpecId':'39','applicableDate':'2017-03-27 20:10:47.816'},{'id':'871f3b28-1ef4-4238-9273-1fc27b9baa90','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'20','prodSpecId':'20','applicableDate':'2017-03-27 20:10:47.816'},{'id':'8876fbc2-a5a0-4c3d-b903-be6b48011660','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'50','prodSpecId':'22','applicableDate':'2017-03-27 20:10:47.816'},{'id':'3cf1019c-4094-4ff7-80be-5b594552d75c','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'51','prodSpecId':'12','applicableDate':'2017-03-27 20:10:47.816'},{'id':'eefe4d7b-5f82-47c4-ada0-8f01e204c527','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'53','prodSpecId':'37','applicableDate':'2017-03-27 20:10:47.816'},{'id':'a9b7ca0f-6969-424a-aa35-ce5a05465ad7','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'54','prodSpecId':'26','applicableDate':'2017-03-27 20:10:47.816'},{'id':'e6bf1f37-c420-4c57-babe-8a35666a994d','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'52','prodSpecId':'14','applicableDate':'2017-03-27 20:10:47.816'}]&deliveryPlaceId=4&paymentMethodId=1&type=JC";

//		String para1 = "gotoOrderList=[{'id':'deee4167-2682-4643-9a50-2723123deaeb','prodOfferId':'33','prodSpecId':'39','applicableDate':'2017-03-27 20:10:47.816'},{'id':'871f3b28-1ef4-4238-9273-1fc27b9baa90','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'20','prodSpecId':'20','applicableDate':'2017-03-27 20:10:47.816'},{'id':'8876fbc2-a5a0-4c3d-b903-be6b48011660','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'50','prodSpecId':'22','applicableDate':'2017-03-27 20:10:47.816'},{'id':'3cf1019c-4094-4ff7-80be-5b594552d75c','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'51','prodSpecId':'12','applicableDate':'2017-03-27 20:10:47.816'},{'id':'eefe4d7b-5f82-47c4-ada0-8f01e204c527','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'53','prodSpecId':'37','applicableDate':'2017-03-27 20:10:47.816'},{'id':'a9b7ca0f-6969-424a-aa35-ce5a05465ad7','parentId':'deee4167-2682-4643-9a50-2723123deaeb','parentOfferId':'33','prodOfferId':'54','prodSpecId':'26','applicableDate':'2017-03-27 20:10:47.816'}]&deliveryPlaceId=4&paymentMethodId=1&type=JC";

		String para1 = "gotoOrderList=43&deliveryPlaceId=4&paymentMethodId=1&type=FL";

		String url2 = localUrl+"OpenAPI/user/customer/gotoOrdering";
//		String url2 = "http://120.77.101.181/OpenAPI/user/customer/gotoOrdering";

      String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTQwNTUwMDUzMTgsInVpZCI6IjgiLCJpYXQiOjE0OTI3NTkwMDUzMTh9.z0nIT2V7wTL4XyhPWPYWQaIQd5grfDGcf6Csw4kXmDo";
  
		
//		String url2 = "http://120.77.101.181/OpenAPI/user/customer/gotoOrdering";
//	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODYxMTE5NjUxODAsInVpZCI6IjIiLCJpYXQiOjE0ODQ4MTU5NjUxODB9.FWyuC6N0TJdbhj0OLyHDTDvZZq9Ll51kh41wzhBgB1M";

	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}
	
	
	
	@Test
	public void test15_updateCustomerInfo(){
	
		String para1 = "info={'name':'终极董事长','gender':1,'post':'职务','birthday':'2888-01-01 08:08:08','placeOfBirth':'广东省广州市番禺区','legalName':'是撒旦','identNr':'441225155533552534','corpAddress':'广东省广州市天河区天府路东晖花园旭日居二栋502'}";
	
		String url2 = localUrl+"OpenAPI/user/customer/updateCustomerInfo";
//		2017年3月7日 20:45:24
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTA0MzkxNzc2NjcsInVpZCI6IjUwIiwiaWF0IjoxNDg5MTQzMTc3NjY3fQ.XooB_CUJC3AeSvoiCCLxcZ55bLwexelUqZ37sbANF7A";

	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}


	@Test
	public void test14_Weal_updateDeliveryAddress(){
	
	
		//String para1 = "info={'contact': '联系人ren','contactNumber': '联系号码','postcode': '邮政编码','address': '广东省广州市番禺区天府路东晖花园旭日居二栋502','province': {'id': 2,'name': '广东省'},'city': {'id': 5,'name': '广州市'},'district': {'id': 1,'name': '番禺区'}}";
		String para1 = "info={'id':7,'contact': '联系人ren','contactNumber': '564654654654','postcode': '123545','address': '广东省广州市番禺区天府路东晖花园旭日居二栋5023333333','province': {'id': 2,'name': '广东省'},'city': {'id': 5,'name': '广州市'},'district': {'id': 5,'name': '番禺区'}}";
//		String para1 = "info={'contactNumber': '联系号码','postcode': '邮政编码','address': '广东省广州市番禺区天府路东晖花园旭日居二栋5023333333','province': {'id': 2,'name': '广东省'},'city': {'id': 5,'name': '广州市'},'district': {'id': 1,'name': '番禺区'}}";
		String url2 = Url120+"OpenAPI/user/customer/updateDeliveryAddress";
	//	2017年2月23日 20:52:20
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTIzMTA4MzY5NzgsInVpZCI6IjIiLCJpYXQiOjE0OTEwMTQ4MzY5Nzh9.rU4xMRvCrQ5upJXOPJXeuupnk1s2_fRcnS8qTo4mvnI";
	
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}


	@Test
	public void test13_Weal_SetDeliveryPlace(){
	
	
		String para1 = "partyRolePlaceId=11&modifier=默认收货地址";
		String url2 = "http://192.168.254.120:8080/OpenAPI/user/customer/setDeliveryPlace";
	//	2017年2月23日 20:52:29
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODkxNTA4MTgxMDAsInVpZCI6IjYiLCJpYXQiOjE0ODc4NTQ4MTgxMDB9._Q-DMCFb9GSg4_JpXNw2QtT40MllDYJgbAj3gVOPFz8";
	
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}



	@Test
	public void test12_Weal_getPlaceSelect(){
	
	
		String para1 = "placeRole=我的收货地址";
		String url2 = localUrl+"OpenAPI/user/customer/getPlaceSelect";
//		2017年2月23日 20:52:29
	    String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTM3OTM5MzkwOTUsInVpZCI6IjM1IiwiaWF0IjoxNDkyNDk3OTM5MDk1fQ.sKSFJcZ6pnggDKORD8vmOLbDEZQXnOOSRmKmAaX5tuU";
		
	    String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
	    System.out.println("test:"+sr);
	}



	@Test
	public void test11_DeliveryAddress(){


		//String para1 = "info={'contact': '联系人ren','contactNumber': '联系号码','postcode': '邮政编码','address': '广东省广州市番禺区天府路东晖花园旭日居二栋502','province': {'id': 2,'name': '广东省'},'city': {'id': 5,'name': '广州市'},'district': {'id': 1,'name': '番禺区'}}";
		//String para1 = "info={'id':11,'contact': '联系人ren','contactNumber': '联系号码','postcode': '邮政编码','address': '广东省广州市番禺区天府路东晖花园旭日居二栋5023333333','province': {'id': 2,'name': '广东省'},'city': {'id': 5,'name': '广州市'},'district': {'id': 1,'name': '番禺区'}}";
		String para1 = "info={'contact': '联系人ren','contactNumber': '1111111','postcode': '222222','address': '广东省广州市番禺区天府路东晖花园旭日居二栋5023333333'}";
//		String url2 = "http://192.168.254.196:8080/OpenAPI/user/customer/updateDeliveryAddress";
		String url2 = "http://192.168.254.120:8080/OpenAPI/user/customer/createDeliveryAddress";
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODc2Njc4OTMyODcsInVpZCI6IjIiLCJpYXQiOjE0ODYzNzE4OTMyODd9.holffxFkUkFgqGQKDaPmBbwONVR8SEx0VWT7dvnj6kI";

        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}


	

	@Test
	public void test10_myHome(){


//		String para1 = "serviceName = 主菜&prodName = 附菜&placeId = 3&orderBy = 1&orderNumb = 3&maxresultNumb = id&date 2017-1-12";
//		session, "今日菜品", place, "主菜"Place place = new PlaceDao(session).load(""+1);
		String para1 = "prodSpecType=个人充值";
//		String para1 = "name=主菜&placeId=1&prodSpecType=精选服务";
        String url2 = "http://127.0.0.1:8080/OpenAPI/user/customer/myHome";
        //2017年2月6日 17:08:02
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODc2Njc4OTMyODcsInVpZCI6IjIiLCJpYXQiOjE0ODYzNzE4OTMyODd9.holffxFkUkFgqGQKDaPmBbwONVR8SEx0VWT7dvnj6kI";

        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}




	
	/**
	 * 测试加载福利页
	 * 
	 */
	@Test
	public void test09_getServiceList(){


//		String para1 = "serviceName = 主菜&prodName = 附菜&placeId = 3&orderBy = 1&orderNumb = 3&maxresultNumb = id&date 2017-1-12";
//		session, "今日菜品", place, "主菜"Place place = new PlaceDao(session).load(""+1);
//		String para1 = "serviceName = 主菜";
		String para1 = "name=特惠产品&placeId=1&prodSpecType=特惠产品";
        String url2 = "http://127.0.0.1:8080/OpenAPI/user/customer/getServiceList";
        
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTM3OTM5MzkwOTUsInVpZCI6IjM1IiwiaWF0IjoxNDkyNDk3OTM5MDk1fQ.sKSFJcZ6pnggDKORD8vmOLbDEZQXnOOSRmKmAaX5tuU";

        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}

	@Test
	public void test08_getCommentList(){


		String para1 = "productSpecId=26&comment=&orderId=";
		
        String url2 = "http://127.0.0.1:8080/OpenAPI/user/customer/getCommentList";
        
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODkxMzEzNDA3NTcsInVpZCI6IjIiLCJpYXQiOjE0ODc4MzUzNDA3NTd9.Mq2xzCVctw0z_IV89By4n5EAtyQfg25sPYxF5K_rqLw";
		
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}

	
	
	
	/**
	 * 测试
	 * 加载福利
	 * 
	 */
	@Test
	public void test07_getService(){


		String para1 = "serviceName=精选服务&prodName=特惠产品&placeId=3&orderNumb=1&maxresultNumb=3&orderBy=id&date=2017-02-27";
//		session, "今日菜品", place, "主菜"Place place = new PlaceDao(session).load(""+1);

        String url2 = localUrl+"OpenAPI/user/customer/getService";
//        String url2 = Url120+"OpenAPI/user/customer/getService";
        
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODkxMzEzNDA3NTcsInVpZCI6IjIiLCJpYXQiOjE0ODc4MzUzNDA3NTd9.Mq2xzCVctw0z_IV89By4n5EAtyQfg25sPYxF5K_rqLw";
		
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println("test:"+sr);
	}

	
	
	
	
	

	/**
	 * 通过用户输入获取附近的地点
	 * myPlace	我的地点	String	如我的饭堂
	 * type	位置类别	String	如 我的餐厅
	 */
	@Test
	public void test06_getAdjcentPlaceByUserInput(){


		String para1 = "myPlace=集体食堂&placeRole=广";
        String url2 = localUrl+"OpenAPI/user/customer/getAdjcentPlaceByUserInput";

        
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTM0NzA5NzI0MzIsInVpZCI6IjIiLCJpYXQiOjE0OTIxNzQ5NzI0MzJ9.t0V8XOD9D7kN3s62HJPmC1G3n-cL_JxTY0xvG6QpTGA";
        
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println(sr);
	}  

	@Test
	
	public void test06_getAdjcentPlaceByGPS(){


		String para1 = "longitude=113&latitude=123&type=我的餐厅&placeRole=我的餐厅";
        String url2 = Url120+"OpenAPI/system/getAdjcentPlaceByGPS";

        
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0OTE2MTM3MzczMTcsInVpZCI6IjIiLCJpYXQiOjE0OTAzMTc3MzczMTd9.LTwPeMh0wK7hGSsPQqPLDLLf-xaGywXxb2Kjh1wHKOw";
        
        String sr=HttpRequestUtils.sendPost(url2,para1,false,token1);
        System.out.println(sr);
	}

	
	
	
	/**
	 * 通过用户名和密码登录
	 * loginByPhone
	 * loginNr	账号	String	
	 * pwd	密码	String	
	 */
	@Test
	public void test05_loginByPwd(){


//		String para1 = "loginNr=18565082276&pwd=123456";
		String para1 = "loginNr=15975294479&pwd=123456";
//		String para1 = "loginNr=13100221463&pwd=123456";
//		String para1 = "loginNr=13560389295&pwd=123456";
        String url2 = localUrl+"OpenAPI/system/loginByPwd";
//        String url2 = "http://192.168.3.18:8080/OpenAPI/system/loginByPwd";
        
        String sr=HttpRequestUtils.sendPost(url2,para1,false,null);
        System.out.println(sr);
	}

	/**
	 * 通过手机号登录
	 * loginByPhone
	 * 
	 */
	@Test
	public void test04_loginByPhone(){


		String para1 = "mobileNumber=15975294479&veriCode=4869";
        String url2 = "http://127.0.0.1:8080/OpenAPI/system/loginByPhone";
        
        String sr=HttpRequestUtils.sendPost(url2,para1,false,null);
        System.out.println(sr);
	}
	
	/**
	 * 验证短信验证码
	 * verifyMobileNumber
	 * 调用过此接口后短信验证码失效
	 */
	@Test
	public void test03_verifyMobileNumber(){


		String para1 = "mobileNumber=15975294479&veriCodeType=手机号登陆&veriCode=3056";
        String url2 = "http://127.0.0.1:8080/OpenAPI/system/verifyMobileNumber";
        
        String sr=HttpRequestUtils.sendPost(url2,para1,false,null);
        System.out.println(sr);
	}
	

	/**
	 * 测试获取短信验证码
	 * ★测试通过
	 * mobileNumber	账号	String	11位手机号
	 * mobileNumber
	 * veriCodeType	类型	String	1.手机号登陆 2.注册.3忘记密码 4首次登陆验证手机号
	 * veriCodeType
	 */
	@Test
	public void test02_getPhoneCode(){


		String para1 = "mobileNumber=15975294479&veriCodeType=手机号登陆";
        String url2 = "http://127.0.0.1:8080/OpenAPI/system/getPhoneCode";
        
        
        String sr=HttpRequestUtils.sendPost(url2,para1,false,null);
        System.out.println(sr);
	}

	/**
	 * 测试注册接口
	 * ★测试通过
	 */
	@Test
	public void test01_custRegister(){


		String para1 = "info={'loginName':'15975294470','pwd':'12345655','name':'昵称','gender':1,'post':'职务','birthday':'2016-01-01','placeOfBirth':'北京北京市朝阳区'}";
//        String url2 = localUrl+"OpenAPI/system/custRegister";
		String url2 = "http://www.csbfxc.com:8080/"+"OpenAPI/system/custRegister";
        
        
        String sr=HttpRequestUtils.sendPost(url2,para1,false,null);
        System.out.println(sr);
	}
	
}
