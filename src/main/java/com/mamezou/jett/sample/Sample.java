package com.mamezou.jett.sample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

import net.sf.jett.transform.ExcelTransformer;

/**
 * JETT Sample
 */
public class Sample {

	public static void main(String[] args) throws Exception {
		Map<String, Object> map = new HashMap<>();

		map.put("string", "Hello!");
		map.put("list", Arrays.asList("one", "two", "three", "four", "five"));
		map.put("formula", "today()");

		ExcelTransformer transformer = new ExcelTransformer();

		InputStream in = Sample.class.getResourceAsStream("./sample.xlsx");
		FileOutputStream out = new FileOutputStream(new File("./output.xlsx"));

		Workbook workbook = transformer.transform(in, map);
		workbook.write(out);
		out.close();
	}

}
