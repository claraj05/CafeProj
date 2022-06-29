const grade = document.querySelector(".grade-area #grade");
const btn = document.querySelectorAll(".grade-area button");

var curr;
var prev;

btn.forEach((item)=>{
    item.addEventListener("click",changeValue);
})

function changeValue(event) {
    grade.value = event.target.value;
    event.target.style.color = "red";

    if (event.target.localName === "span") {
        grade.value = event.target.parentElement.value;
    }

    prev = curr;
    curr = event;
    
    if(prev === curr) {
        event.target.style.color = "red";
    }
    if (prev != null) {
        prev.target.style.color = "black";
    }
    console.log(grade.value);
}

//btn.addEventListener("click",changeValue);