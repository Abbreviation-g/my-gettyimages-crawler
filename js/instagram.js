var articleEle=document.getElementsByTagName("article")[0];

var albumEles=articleEle.getElementsByClassName("x1i10hfl xjbqb8w x6umtig x1b1mbwd xaqea5y xav7gou x9f619 x1ypdohk xt0psk2 xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd x16tdsg8 x1hl2dhg xggy1nq x1a2a7pz _a6hd");

var baseUrl = "https://www.instagram.com/"
var albumUrls=[];
for(var i=0;i<albumEles.length;i++) {
    var albumEle = albumEles[i];
    var albumUrl = baseUrl + albumEle.getAttribute("href");
	
	window.open(albumUrl,"_self")
	// albumUrls.push(albumUrl);
}

console.log(JSON.stringify(albumUrls))

// ["https://www.instagram.com//p/CdX5UXkpA1y/","https://www.instagram.com//p/CTlUyK6AV0q/","https://www.instagram.com//p/CPM51eKBzG5/","https://www.instagram.com//p/CnOg4GcO43v/","https://www.instagram.com//p/CnL4nZ_Sx3H/","https://www.instagram.com//p/CnJboSzOzJF/","https://www.instagram.com//p/CnHbrDbynji/","https://www.instagram.com//p/CnGiiD-SWj9/","https://www.instagram.com//p/Cm6F3MdOA8r/","https://www.instagram.com//p/Cm053CfuUV1/","https://www.instagram.com//p/CmtLE7_O_ju/","https://www.instagram.com//p/CmiaefXS1ti/"]

// https://scontent-nrt1-1.cdninstagram.com/v/t51.2885-15/324395667_113314854981154_3648868853361913387_n.jpg?stp=dst-jpg_e35_p1080x1080&_nc_ht=scontent-nrt1-1.cdninstagram.com&_nc_cat=110&_nc_ohc=YgIfyYm4B68AX_DRck5&tn=an659CnV2HiFhQxz&edm=ACWDqb8BAAAA&ccb=7-5&ig_cache_key=MzAxMjQ4OTc4NzU1NTMwODU5OA%3D%3D.2-ccb7-5&oh=00_AfCibNklnXGedonPu5TjMNReQjN7HN7px2VBzZ_0-Aldtw&oe=63C1EF84&_nc_sid=1527a3 
// https://scontent-nrt1-1.cdninstagram.com/v/t51.2885-15/324399663_844093093544162_1230423898978062909_n.jpg?stp=dst-jpg_e35_p1080x1080&_nc_ht=scontent-nrt1-1.cdninstagram.com&_nc_cat=102&_nc_ohc=Dlaq1QimOIsAX9y34Pt&tn=an659CnV2HiFhQxz&edm=ACWDqb8BAAAA&ccb=7-5&ig_cache_key=MzAxMjQ4OTc4NzU1NTI4NjM1MA%3D%3D.2-ccb7-5&oh=00_AfBRFqplZfY3i4h8ReTyo7AELo1CE1DiSoxmDYbub8d3UA&oe=63C245C8&_nc_sid=1527a3 



function sleep(numberMillis) {
    var now = new Date();
    var exitTime = now.getTime() + numberMillis;
    while (true) {
        now = new Date();
        if (now.getTime() > exitTime){
            return;
        }
    }
}

var i=0;
while(i<10) {
	var nextBtn =document.getElementsByClassName(" _9zm2");
	if(nextBtn.length >0){
		nextBtn[0].click();
		sleep(2*1000);
		var imgParent=document.getElementsByClassName("_aatk _aatl")[0]
		var imgEle=imgParent.getElementsByClassName("x5yr21d xu96u03 x10l6tqk x13vifvy x87ps6o xh8yej3")[1];
		var srcset = imgEle.getAttribute("srcset");
		var imgUrlStr = srcset.split(' ')[0];
		
		console.log(imgUrlStr);
	} else {
		break;
	}
	i++;
}
