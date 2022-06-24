package com.project.solr.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SearchEngine {
	private int totalCnt = 0;
	private String qTime;
	private String fieldName;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> process(String queryURL) {

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			URL url = new URL(queryURL);
			
			//커넥션으로부터 결과를 inputstream으로 받아온다.
			URLConnection connection = url.openConnection();
			connection.setConnectTimeout(60000);	//커넥션 타임아웃 60초
			connection.setReadTimeout(60000);		//리딩 타임아웃 60초

			InputStream is = connection.getInputStream();
			JsonObject jsonObject = JsonParser.parseReader(new InputStreamReader(is, "UTF-8")).getAsJsonObject();

			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new HashMap<>();
	        list.add(getMapFromJsonObject(jsonObject));
			
	        if( jsonObject != null ){
	            for(Map<String, Object> jsonMap :list) {
	            	map.put("responseHeader", jsonMap.get("responseHeader"));
	            	map.put("response", jsonMap.get("response"));
	            }
	        }
	        
	        List<Map<String, Object>> searchList = substringValue((ArrayList)((HashMap<String, Object>)map.get("response")).get("docs"));
	        
	        resultMap.put("qTime", ((HashMap<String, Object>)map.get("responseHeader")).get("QTime"));		// 걸린 시간
	        resultMap.put("totalCount", ((HashMap<String, Object>)map.get("response")).get("numFound"));	// 총 데이터 수
	        resultMap.put("searchList", searchList);		// 조회 결과
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultMap;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMapFromJsonObject( JsonObject jsonObj ) {
	        Map<String, Object> map = null;
	        
	        try {
	            
	            map = new ObjectMapper().readValue(jsonObj.toString(), Map.class) ;
	            
	        } catch (JsonParseException e) {
	            e.printStackTrace();
	        } catch (JsonMappingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	        return map;
	    }
	 
	 public static List<Map<String, Object>> substringValue(List<Map<String, Object>> searchList){
		 List<Map<String, Object>> list = searchList;
		 for(Map<String, Object> o : searchList) {
			 		String diaryId = o.get("diary_id").toString();
			 		String userId = o.get("user_id").toString();
			 		String title = o.get("title").toString();
			 		String diaryDate = o.get("diary_date").toString();
			 		
			 		o.put("diary_id", diaryId);
			 		o.put("user_id", userId.substring(1, userId.length()-1));
			 		o.put("title", title.substring(1, title.length()-1));
			 		o.put("diary_date", diaryDate.substring(1, diaryDate.length()-1));
			 		
			 		if(o.get("content") != null) {
			 			String content = o.get("content").toString();
			 			o.put("content", content.substring(1, content.length()-1));
			 		};
			 		
			 		if(o.get("path") != null) {
			 			String path = o.get("path").toString();
			 			o.put("path", path.substring(1, path.length()-1));
			 		};
	        }
		 
		 return list;
	 }
	 
}
