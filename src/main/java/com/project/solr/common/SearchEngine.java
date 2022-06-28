package com.project.solr.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.project.solr.dto.DiaryDto;
import com.project.solr.entity.DiaryEntity;

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

			JsonArray ret = (JsonArray)((JsonObject)jsonObject.get("response")).get("docs");
			
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new HashMap<>();
	        list.add(getMapFromJsonObject(jsonObject));
//	        List resultList = new ArrayList<>();
//	        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        if( jsonObject != null ){
//	        	DiaryDto diary = new DiaryDto(); 
	            for(Map<String, Object> jsonMap :list) {
	            	map.put("responseHeader", jsonMap.get("responseHeader"));
	            	map.put("response", jsonMap.get("response"));
	            }
//	            for(int i=0; i< ret.size(); i++) {
//	            	JsonObject obj = ret.get(i).getAsJsonObject();
//	            	if(obj.get("diaryId")!=null)
//	            		diary.setDiaryId(obj.get("diary_id").getAsInt());
//	            	if(obj.get("userId")!=null)
//	            		diary.setUserId(obj.get("user_id").getAsInt());
//	            	if(obj.get("title")!=null)
//	            		diary.setTitle(obj.get("title").getAsString());
//	            	if(obj.get("content")!=null)
//	            		
//	            		diary.setContent(obj.get("content").getAsString());
//	            	if(obj.get("createDate")!=null)
//	            		diary.setCreateDate(transFormat.parse(obj.get("create_date").getAsString()));
//	            	if(obj.get("diaryDate")!=null)
//	            		diary.setDiaryDate(transFormat.parse(obj.get("diary_date").getAsString()));
//	            	if(obj.get("bookmark")!=null)
//	            		diary.setBookmark(obj.get("bookmark").getAsString());
//	            	if(obj.get("path")!=null)
//	            		diary.setPath(obj.get("path").getAsString());
//	            	//map.put("title", obj.get("title").getAsString());
//	            	resultList.add(obj);
//	            }
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
			 		o.put("diary_id", o.get("id").toString());
			 		o.put("user_id", o.get("user_id").toString());
			 		o.put("title", o.get("title").toString());
			 		o.put("diary_date", o.get("diary_date").toString());
			 		
			 		if(o.get("content") != null) {
			 			o.put("content", o.get("content").toString());
			 		};
			 		
			 		if(o.get("bookmark") != null) {
			 			o.put("bookmark", o.get("bookmark").toString());
			 		};
			 		
			 		if(o.get("path") != null) {
			 			o.put("path", o.get("path").toString());
			 		};
	        }
		 
		 return list;
	 }
	 
}
