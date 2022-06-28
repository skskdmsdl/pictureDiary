package com.project.solr.common;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SolrScheduler {
	
	//@Scheduled(fixedDelay = 5000)
	public void importSchedule() {
//		System.out.println("========================-1분마다 실행====================");
		try {
			// delta-import
			URL url = new URL("http://localhost:8983/solr/solrProject/dataimport?command=delta-import&commit=true");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				System.out.println("-- solr delta-import success --");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 참고용
//	@Scheduled(fixedDelay = 5000)
//	public void test() {
//		System.out.println("========================-5초마다 실행====================");
//	}
//	
//	@Scheduled(cron="*/5 * * * * *") 
//    public void test2(){
//		System.out.println("========================-5초마다 실행====================");
//    }

}
