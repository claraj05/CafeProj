/**
 * 
 */
 
const cafeSectorOne = document.querySelectorAll(".sector-one figure");
const cafeSectorTwo = document.querySelectorAll(".sector-one figure");

cafeSectorOne.forEach((item)=>{
    item.addEventListener("click",moveLink);
});
cafeSectorTwo.forEach((item)=>{
    item.addEventListener("click",moveLink);
});

function moveLink(event) {
    console.log(event);
    console.log("click");
}

