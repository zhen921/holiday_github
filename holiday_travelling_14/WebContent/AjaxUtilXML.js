function creatAjaxObj(){
	var req;
	if(window.XMLHttpRequest()){
		req=new XMLHttpRequest();
	}else {
		req=new ActiveXObject("Msxml2.XMLHTTP");
	}
	return req;
}
function sendAjaxReq(method,url,param,asychn,handle200,loading,handle404,handle500){
	var req=creatAjaxObj();
	 req.onreadystatechange=function(){
         if(4==req.readyState){
             if(200==req.status){
            	 if(handle200){//不为空
            		 var xmlDoc=req.responseXML;
            		 //alert(xmlDoc);
            		// if(xmlDoc!=null){
            			 var result=req.responseText;
            		// alert(result);
            			 xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
            			 xmlDoc.loadXML(result);
            	//	 }
            		 handle200(result);
            	 }
             }else if(404==req.status){
            	 if(handle404){
            		 handle404();
            	 }
             }else if(500==req.status){
            	 if(handle500){
            		 handle500();
            	 }
             }
         }else{
        	 if(loading){
        		 loading();
        	 }
         }
	 };
     if("get"==method.toLowerCase()){
    	 req.open(method,url+(param==null?"":"?"+param),asychn);//判断参数是否为空
    	 req.send(null);
     }else if("post"==method.toLowerCase()){
    	 req.open(method,url,asychn);
    	 req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    	 req.send(param);
     }
         
	
}