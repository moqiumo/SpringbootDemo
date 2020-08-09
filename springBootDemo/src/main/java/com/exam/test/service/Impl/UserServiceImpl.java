package com.exam.test.service.Impl;

import com.exam.test.mapper.UserMapper;
import com.exam.test.service.UserService;
import com.exam.test.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
*@author: cl
*@version : 2018年12月3日 下午4:45:30
*
*
*/
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findAllUser() {
		return userMapper.findAllUser();
	}

    @Override
    public User findUserById(Integer userid) {

		return userMapper.findUserById(userid);
	}

	@Override
	public User findByName(String username, String password) {
		return userMapper.findByName(username, password);
	}

	@Override
	public String getPassword(String username) {
		return userMapper.getPassword(username);
	}
//	/**post 发送作业数据*/
//	public static  void doPost(String data,String url) {
//		//创建httpclient对象
//		try{
//			CloseableHttpClient client = HttpClients.createDefault();
//			//创建post方式请求对象
//			HttpPost httpPost = new HttpPost(url);
//			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//			nvps.add(new BasicNameValuePair("imageBase64",data));
//			//url格式编码
//			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvps, "UTF-8");
//			httpPost.setEntity(uefEntity);
//			CloseableHttpResponse response = client.execute(httpPost);
//			// 检验返回码
//			int statusCode = response.getStatusLine().getStatusCode();
//			if(statusCode != 200){
//				httpPost.abort();
//				httpPost.releaseConnection();
//			}else {
//				HttpEntity entity = response.getEntity();
//				InputStream stream = entity.getContent();
//				String string = changeInputStream(stream, "utf-8");
//				System.out.println(string + "-----------");
//			}
//			httpPost.releaseConnection();
//		}catch (IOException io){
//			io.printStackTrace();
//			System.out.println(io + "send homeworkJson error");
//		}
//	}
}
