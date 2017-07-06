package test;
/**   
 * @ClassName:  PrivateKeyTest   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: panzhican
 * @date:   2017年7月6日 下午5:42:55   
 */
public class PrivateKeyTest {
    public static void main(String[] args){
        Test test = new Test();
        
//        System.out.println(Test.privateKey);
//        String msg = new String(Test.resultBytes);
        
        byte[] decBytes = Test.decrypt(Test.privateKey, Test.resultBytes);
        String dec = new String(decBytes);
        
        System.out.println("用私钥加密后的结果是:" + dec);
    }
}
