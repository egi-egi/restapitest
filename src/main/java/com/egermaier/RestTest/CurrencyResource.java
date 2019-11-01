package com.egermaier.RestTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

@Path("currencies")
public class CurrencyResource {
	
	CurrencyRepository repo = new CurrencyRepository();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Currency> getCurrencies(@DefaultValue("false") @QueryParam("usedb") boolean usedb) {
		List<Currency> currs = new ArrayList<>();
		
		if(usedb) {
			//data z databáze
			currs = repo.getCurrs();
		} else {
			//aktuální data + uložit do databáze
			try {
				
			String url = "https://www.csast.csas.cz/webapi/api/v1/rates/exchangerates?web-api-key=86d63706-3a9c-4762-bd7a-415651cc26f8";
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = in.readLine())!=null) {
				response.append(inputLine);
			}
			in.close();
			String s = response.toString();
						
			JSONParser parser = new JSONParser();
			Object o = parser.parse(s);
	        JSONArray array = (JSONArray)o;
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		    
	        for(Object element : array) {
	        	JSONObject joo = (JSONObject)element;
	        	Currency c = new Currency();
	        	c.setAmount(Double.parseDouble(joo.get("amount").toString()));
	        	c.setCnbMid(Double.parseDouble(joo.get("cnbMid").toString()));
	        	c.setCountry(joo.get("country").toString());
	        	c.setCurrencyBuy(Double.parseDouble(joo.get("currBuy").toString()));
	        	c.setCurrencySell(Double.parseDouble(joo.get("currSell").toString()));
	        	c.setCurrMid(Double.parseDouble(joo.get("currMid").toString()));
	        	c.setMove(Double.parseDouble(joo.get("move").toString()));
	        	c.setName(joo.get("name").toString());
	        	c.setShortName(joo.get("shortName").toString());
	        	c.setValBuy(Double.parseDouble(joo.get("valBuy").toString()));
	        	c.setValidFrom(sdf.parse(joo.get("validFrom").toString()));
	        	c.setValMid(Double.parseDouble(joo.get("valMid").toString()));
	        	c.setValSell(Double.parseDouble(joo.get("valSell").toString()));
	        	c.setVersion(Double.parseDouble(joo.get("version").toString()));
	        	currs.add(c);
	        	
	        }
	        repo.create(currs);
			
			} catch(ParseException pe) {
				System.out.println("position: " + pe.getPosition());
		        System.out.println(pe);		
			} catch(Exception e) {
				System.out.println(e);
			}
			
		}
		
		return currs;
     
    }

}
