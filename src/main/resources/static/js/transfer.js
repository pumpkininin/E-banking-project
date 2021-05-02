var btnCheck = document.querySelector(".btn-check-info");
btnCheck.innerHtml = "a";
var row = document.querySelector(".row .g-3");
var receiverInfo = document.querySelector(".input-group").cloneNode();
btnCheck.addEventListener("click",() => {
    row.appendChild(receiverInfo);
    console.log("hmmmm")
})
