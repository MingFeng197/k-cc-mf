var text=document.getElementById("text");
var img=document.getElementById("imgId");
function checkOn(){
	if(text.value==null||text.value==""){
		alert("请输入内容");
	}else{
		img.src = "GetQrCode?author=张闫&text="+text.value;
		var down=document.getElementById("down");
		down.href="GetQrCode?author=张闫&down=T&text="+text.value;
	}
}
var w=200;
//window.onresize=changew();
function changew(){//窗口大小改变事件
	w = document.documentElement.clientWidth || document.body.clientWidth;
	//h = document.documentElement.clientHeight || document.body.clientHeight;
	w *= 0.8;
	console.log("get参数列表: ?author=张闫&down=&text=\nauthor=张闫 用来判断浏览器是否存在中文乱码问题\ndown 可选 为T时 将对二维码进行下载\ntext= 必填 二维码的内容 若为空将重定向至本页面");
//	if(w<=640&&w>=200){
//		//alert(w);
//		img.style.width = w+"px";
//		img.style.height = w+"px";
//	}else if(w<=200){
//		img.style.width = "200px";
//		img.style.height = "200px";
//	}
}