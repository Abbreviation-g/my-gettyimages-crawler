package com.my.crawler.common;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CommonTest {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException, ParseException {
//		test1();
//		test2();
		test3();
		test5();
	}
	
	static void test3() {
		String str = "Sun May 28 19:22:25 +0800 2023";
		Date date = new Date(str);
		System.out.println(date);
		System.out.println(date.getDay());
	}
	
	static void test5() throws ParseException {
//		SimpleDateFormat format = new SimpleDateFormat("EEE MMMMM dd HH:mm:ss Z YYYY", Locale.ENGLISH);
//		String str = "Thu Jul 13 17:59:54 +0800 2023";
		SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z",Locale.ENGLISH);
//		System.out.println(format.format(new Date()));;
		String str = "Wed, 1 Jul 2001 12:08:56 -0700";
//		"EEE, MMM d, ''yy"  
//		Wed, Jul 4, '01  
		Date date = format.parse(str);
		System.out.println(date);
		System.out.println(date.getDay());
	}

	static void test1() {
		File outputFolder = new File("D:\\weibo\\赵露思");
		for (File sub : outputFolder.listFiles()) {
			String subName = sub.getName();
			if (subName.contains("ๅนด")) {
				subName = subName.replace("ๅนด", "年");
			}
			sub.renameTo(new File(outputFolder, subName));
		}
	}

	static void test2() throws ScriptException, NoSuchMethodException {
//		ScriptEngineManager engineManager = new ScriptEngineManager();
//		ScriptEngine jsEngine= engineManager.getEngineByName("nashorn");
//		jsEngine.eval("function() {console.log('hello')}()");

//		ScriptEngineManager factory = new ScriptEngineManager();
//		// 创建一个JavaScript引擎
//		ScriptEngine engine = factory.getEngineByName("nashorn");
//		// 执行JavaScript代码
//		engine.eval("print('Hello, World')");
		
		String script = "function run(arg){if (arg>500){return 0}else{return arg}}";
        System.out.println(jsRun("run", script, 100));
	}

	/**
	 *
	 * @param methodName js脚本方法名
	 * @param script     js 脚本内容
	 * @param args       js方法参数
	 * @return
	 * @throws ScriptException
	 * @throws NoSuchMethodException
	 */
	public static Object jsRun(String methodName, String script, Object... args)
			throws ScriptException, NoSuchMethodException {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine javaScriptEngine = scriptEngineManager.getEngineByName("JavaScript");
		javaScriptEngine.eval(script);
		Invocable inv = (Invocable) javaScriptEngine;
		return inv.invokeFunction(methodName, args);
	}
}
