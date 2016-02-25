package com.esure.utils.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @description HttpClientUtil
 * @author ligy
 * @date 2015年12月18日 下午3:34:40
 * @module=
 *
 */
public class HttpClientUtil
{
	private static HttpClientBuilder builder = HttpClientBuilder.create();
	
	/**
	 * httpPost请求，传string参数和请求类型参数
	 * @description httpPost
	 * @author ligy
	 * @date 2015年12月18日 下午7:12:28
	 * @method=
	 * @param url
	 * @param param
	 * @param contentType
	 * @return
	 */
	public static HttpResponse httpPost(String url, String param, ContentType contentType) {
		HttpClient client = builder.build();
		HttpResponse response = null;
		
		HttpPost request = new HttpPost(url);
		try
		{
			StringEntity stringEntity = null;
			if(contentType != null) {
				stringEntity = new StringEntity(param, contentType);
//				stringEntity.setContentEncoding("UTF-8");
			} else {
				stringEntity = new StringEntity(param, "UTF-8");
			}
			request.setEntity(stringEntity);
			response = client.execute(request);
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
	
	/**
	 * httpPost，传key-value参数
	 * @description httpPost
	 * @author ligy
	 * @date 2015年12月18日 下午3:34:46
	 * @method=
	 * @param url
	 * @param formparams
	 * @return
	 */
	public static HttpResponse httpPost(String url, List<NameValuePair> formparams)
	{
		HttpClient client = builder.build();

		HttpResponse response = null;
		
		HttpPost request = new HttpPost(url);
		try
		{
			request.setEntity(new UrlEncodedFormEntity(formparams, "UTF-8"));
			response = client.execute(request);
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
	
	/**
	 * httpGet请求
	 * @description httpGet
	 * @author ligy
	 * @date 2015年12月18日 下午3:34:52
	 * @method=
	 * @param url
	 * @return
	 */
	public static HttpResponse httpGet(String url)
	{
		HttpClient client = builder.build();

		HttpResponse response = null;
		
		HttpGet request = new HttpGet(url);
		
		try
		{
			response = client.execute(request);
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}
	
	/**
	 * httpPostEntity请求，传key-value参数
	 * @description httpPostEntity
	 * @author ligy
	 * @date 2015年12月18日 下午3:34:58
	 * @method=
	 * @param url
	 * @param formparams
	 * @return
	 */
	public static String httpPostEntity(String url, List<NameValuePair> formparams)
	{
		try
		{
			return EntityUtils.toString(httpPost(url, formparams).getEntity());
		} catch (ParseException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * httpGetEntity请求
	 * @description httpGetEntity
	 * @author ligy
	 * @date 2015年12月18日 下午3:35:04
	 * @method=
	 * @param url
	 * @return
	 */
	public static String httpGetEntity(String url)
	{
		try
		{
			return EntityUtils.toString(httpGet(url).getEntity());
		} catch (ParseException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
