var dir = "../images/template/";
var images = ["banner1.jpg",
    "banner2.jpg",
    "banner3.jpg",
    "banner4.jpg",
    "banner5.jpg"];
var randomCount = Math.floor(Math.random() * images.length);
document.getElementById("banner").style.backgroundImage = "url(" + dir + images[randomCount] + ")"; 