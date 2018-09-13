
//定义一个全局变量，用于存放XmlHttpRequest对象
var xmlhttp=null;

function verfy(){
	var myText=document.getElementById("text").value;//获取输入框中的文本内容
	/**
	 * 创建XmlHttpRequest对象，需要针对不同浏览器使用不同的方式来获取
	 * 
	 */
	if(window.XMLHttpRequest)//针对firfox,IE7,IE8,mozillar,opera
	{
		xmlhttp=new XMLHttpRequest();
		
		if(xmlhttp.overrideMimeType)//针对某些浏览器上的bug进行修正
		{
			xmlhttp.overrideMimeType("text/xml");
		}
		
	}
	else if(window.ActiveXObject)//针对IE6,IE5.5,IE5内核的浏览器
	{
		//由于使用ActiveXObject的浏览器的版本不同，要针对不同版本去获取
		var activexName=["Msxml2.XMLHTTP","Microsoft.XMLHTTP"];
		for(var i=0;i<activexName.length;i++){
			try{
				xmlhttp=new ActiveXObject(activexName[i]);
				break;
			}catch(e){
				
			}
		}
		if(!xmlhttp){
			alert("浏览器版本过低！");
			return;
		}
	}
	//注册回调函数。每当state属性的值变化时都会触发一次指定的js函数
	xmlhttp.onreadystatechange=callback;
	
	xmlhttp.open("GET","AjaxServlet?text="+myText,true);
	
	xmlhttp.send(null);
}
//回调函数
function callback(){
	//数据交互完成
	if(xmlhttp.readyState==4){
		//服务器返回的状态码，数据交互成功
		if(xmlhttp.status==200){
			var responseText=xmlhttp.responseText;
			paseJson(responseText);
//			//alert(responseText);
//			var responseXml=xmlhttp.responseXML;
//			var n=responseXml.getElementsByTagName("text");
//			var t=n[0].firstChild;
//			alert(t.nodeValue);
		}
	}
}


function paseJson(json){
	var jobject=eval("("+json+")");
	for(var i in jobject){
		alert(jobject[i]);
	}
}

