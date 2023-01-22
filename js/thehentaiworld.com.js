var thumbContainer = document.getElementById("thumbContainer");
var imgs = thumbContainer.getElementsByTagName("img");

var urlList=[];
for(var i=0;i<imgs.length;i++) {
	var url0=imgs[i].getAttribute("src");
	url0 = url0.replace("-220x147","");
	urlList.push(url0);
}
urlList.toString();

