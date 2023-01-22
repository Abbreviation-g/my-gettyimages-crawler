var articleEle=document.getElementsByTagName("article")[0];

var albumEles=articleEle.getElementsByClassName("x1i10hfl xjbqb8w x6umtig x1b1mbwd xaqea5y xav7gou x9f619 x1ypdohk xt0psk2 xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd x16tdsg8 x1hl2dhg xggy1nq x1a2a7pz _a6hd");

var baseUrl = "https://www.instagram.com/"
var albumUrls=[];
for(var i=0;i<albumEles.length;i++) {
    var albumEle = albumEles[i];
    var albumUrl = baseUrl + albumEle.getAttribute("href");
	albumUrls.push(albumUrl);
}

console.log(JSON.stringify(albumUrls))
