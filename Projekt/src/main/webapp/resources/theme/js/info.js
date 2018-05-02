function crunchifyAjax(id) {
    
    console.log("Tu som ", id);
    $.ajax({
        url: "info",
        type: "GET",
        data: {id: id},
        success: function (response) {
            document.getElementById('fname').innerHTML = response.data[0].firstName;
            console.log(response);
            console.log("Success 1");
        },
        error: function (data) {
            //console.log(response);
            console.log("Chyba 11458");
        }
    });
} 