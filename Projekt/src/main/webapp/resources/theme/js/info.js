var modal = document.getElementsByClassName("modal")[0];
var span = document.getElementsByClassName("close")[0];
var details = document.getElementsByClassName("details");




span.onclick = function () {
    modal.style.display = "none";
}

for (var i = 0; i < details.length; i++){
    details[i].addEventListener("click", function(){
        modal.style.display = "block";
        console.log(this);
    });
}
