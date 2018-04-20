
showInfo = function () {
    var popup = document.getElementById('modal');
    console.log();
    popup.style.display = "block";
}
window.onclick = function(event){
    var popup = document.getElementById('modal');
    if (event.target = popup){
        popup.style.display = "none";
    }
}

close = function(){
    var popup = document.getElementById('modal');
    popup.style.display = "none";
}