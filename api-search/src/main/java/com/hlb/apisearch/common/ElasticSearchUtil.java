package com.hlb.apisearch.common;

import java.net.InetAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.hlb.app.core.framework.helper.ConfigHelper;

public class ElasticSearchUtil {
	
	private static  Log logger=LogFactory.getLog(ElasticSearchUtil.class);	
	
	private static String clusterKey;
	private static String clusterValue;
	private static String clusterIp;
	private static Integer port = 9300;
	
	private static volatile TransportClient client = null;
	 public static TransportClient getTransportClient() {  
         if (client == null) {    
           synchronized (TransportClient.class) {    
              if (client == null) {    
            	  try{
            		  client = initClient();  
            	  }catch(Exception ex){}
              }    
           }    
         }   
      return client;  
    }
	
	static{
		try{
			ConfigHelper config = ConfigHelper.getInstance();
			clusterKey = config.getParamValue("es.clusterKey");
			clusterValue = config.getParamValue("es.clusterValue");
			clusterIp = ConfigHelper.getInstance().getParamValue("es.clusterIp");
			try{
			   port = Integer.parseInt(ConfigHelper.getInstance().getParamValue("es.port"));
			}catch(Exception ex){
				port = 9300;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	

	/**
	 * 初始化client
	 * @return
	 * @throws Exception
	 */
	public static TransportClient initClient()throws Exception{
		Settings settings = Settings.builder().put(clusterKey, clusterValue).build();
		@SuppressWarnings("resource")
		TransportClient client = new PreBuiltTransportClient(settings)
		   .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(clusterIp), port));
		return client;
	}
	public Settings getIndexSettings(){
		Settings indexSettings = Settings.builder()
                .put("number_of_shards", 5)
                .put("number_of_replicas", 2)
                .build();
		return indexSettings;
	}
	
	/**
	 * 判断索引是否存在
	 * @param indexName
	 * @return
	 */
	public Boolean isIndexExists(String indexName) {
        try {
        	TransportClient client = ElasticSearchUtil.getTransportClient();
        	IndicesExistsResponse indicesExistsResponse = client.admin().indices()
            		.exists(new IndicesExistsRequest(new String[] { indexName })).actionGet();
            if (indicesExistsResponse.isExists()) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
	
	public static void main( String[] args ) throws Exception
    {

    	
    	
    	Settings settings = Settings.builder().put("cluster.name", "my-application").build();
		@SuppressWarnings("resource")
		TransportClient client = new PreBuiltTransportClient(settings)
		   .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.8.8"), 9300));
		//SearchResponse sr = client.prepareSearch().execute().actionGet();
		
		/*client.prepareIndex("product", "product", "1")
        .setSource(json)
        .get();*/
		/*DeleteIndexResponse d = client.admin().indices().prepareDelete("product")
                .execute().actionGet();*/
		//DeleteRequest dRequest = new DeleteRequest();
		//dRequest.
		//client.delete(request)
		/*DeleteResponse dResponse = client.prepareDelete("product", "product", "1").execute()
                .actionGet();*/
		//搜索数据
        //GetResponse response = client.prepareGet("good", "good", "11449196019353").execute().actionGet();
        //输出结果
        //System.out.println(response.getSourceAsString());
        //关闭client
		
        //QueryBuilder qb1 = termQuery("name", "kimchy");   
        QueryBuilder qb2= QueryBuilders.multiMatchQuery("文胸", "companyName","goodsName");
        SearchResponse response = client.prepareSearch("product").setTypes("product").setQuery(qb2).execute()
                .actionGet();
        SearchHits hits = response.getHits();
        
        if (hits.totalHits() > 0) {
            for (SearchHit hit : hits) {
                System.out.println("score:"+hit.getScore()+":\t"+hit.getSource());
            }
        } else {
            System.out.println("搜到0条结果");
        }
        
		
		
		/*QueryBuilder bqb =  QueryBuilders.boolQuery()//.filter(QueryBuilders.termQuery("brandEnName","唯棉坊"))
				.must(QueryBuilders.termQuery("categoryId", "0"))
				//.must(QueryBuilders.termQuery("brandId", "11449060609540"))
				//.mustNot(QueryBuilders.termQuery("regionIds", "980"))
                //.must(QueryBuilders.termQuery("brandEnName","唯棉坊"))
                .should(QueryBuilders.termQuery("goodsName", "柯诗怡内衣配套中腰平脚内裤单件（普通包装）FS14F020"))
                .should(QueryBuilders.termQuery("companyName", "柯诗怡内衣配套中腰平脚内裤单件（普通包装）FS14F020"));
		
		
        SearchResponse response = client.prepareSearch("product").setTypes("product")
        		//.setQuery(qb3)
        		.setQuery(bqb)
        		//.addSort("stockNum",SortOrder.DESC)
        		//.setFrom(0).setSize(5)
        		.execute()
                .actionGet();
        SearchHits hits = response.getHits();
        
        if (hits.totalHits() > 0) {
            for (SearchHit hit : hits) {
                System.out.println("score:"+hit.getScore()+":\t"+hit.getSource());
            }
        } else {
            System.out.println("搜到0条结果");
        }*/
        
		
		
		client.close();
		

		//ElasticSearchUtil util  = new ElasticSearchUtil();
		//util.createBrandMapping();
    }

	
}
