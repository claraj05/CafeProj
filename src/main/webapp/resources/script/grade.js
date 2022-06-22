const grade = document.querySelector(".grade-area #grade");
const btn = document.querySelectorAll(".grade-area button");

var curr;
var prev;

btn.forEach((item)=>{
    item.addEventListener("click",changeValue);
})

function changeValue(event){
    grade.value = event.target.value;
    event.target.style.color="red";

    prev = curr;
    curr = event;

    if(prev != null) {
        prev.target.style.color="black";
    }
    console.log(grade.value);
}

//btn.addEventListener("click",changeValue);