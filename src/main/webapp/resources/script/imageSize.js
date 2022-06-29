/**
 * 
 */
 
const img_count = document.querySelector("#picture-container");

function init() {
    var currentWidthSize=5;
    var imgWidthSize =  window.innerWidth / 5;
    console.log("init")
    for (var i=0;i<img_count.children.length;i++){ 
        console.log(imgWidthSize)
        img_count.children[i].children[0].style.width = `${imgWidthSize}px`; 
        img_count.children[i].children[0].style.left = `${currentWidthSize}px`; 
        currentWidthSize += imgWidthSize + 10;
    }
}


init();


