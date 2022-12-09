package jUnitTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class WordsCountTest {

	@Test
	void test()  {
		TextAnalyzer test = new TextAnalyzer();
		Map<String, Integer> stats = new HashMap<String, Integer>();
		
		 try {
			test.countFrequencies("C:\\Users\\fatim\\eclipse-workspace\\JUnitTestingWordAnalyzer\\src\\jUnitTesting\\test file.txt", stats);
			Map<String, Integer> temp = stats.entrySet().stream().sorted(
					Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
					.limit(20).collect(Collectors.toMap(
			                 Map.Entry::getKey,
			                 Map.Entry::getValue,
			                 (e1, e2) -> e1,
			                 LinkedHashMap::new));	
			
			System.out.println(temp.entrySet().iterator().next().getKey());
			assertEquals(temp.entrySet().iterator().next().getKey(), "these");
			
			//System.out.println(temp.entrySet().iterator().next().getValue());
			//assertEquals(temp.entrySet().iterator().next().getValue(),17);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		
	}

}
