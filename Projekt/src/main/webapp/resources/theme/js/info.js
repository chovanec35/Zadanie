function detailAjax(id) {
    $.ajax({
        url: "info",
        type: "GET",
        data: {id: id},
        success: function (response) {
            $("#result").css("display", "block");
            document.getElementById('fName').innerHTML = response.data[0].firstName;
            document.getElementById('lName').innerHTML = response.data[0].lastName;
            document.getElementById('description').innerHTML = response.data[0].description;
            var bDate = new Date(response.data[0].birthdate);
            document.getElementById('birthdate').innerHTML = bDate.toLocaleDateString();
            var cDate = new Date(response.data[0].creationTs);
            document.getElementById('creationTs').innerHTML = cDate.toLocaleDateString();
        },
        error: function (data) {
            console.log("Chyba pri zobrazeni detailu");
        }
    });
}

function deleteAjax(id) {
    console.log("Tu som ", id);
    $.ajax({
        url: "delete",
        type: "POST",
        data: {id: id},
        success: function (response) {
            console.log("success");
            location.reload();
        },
        error: function (data) {
            console.log("Chyba pri mazani");
        }
    });
}

function closeModal() {
    $("#result").css("display", "none");
}


var totalPages = '${size}';
$(function () { 
    $('#pagination').pagination({
//        items: "2",
//        itemsOnPage: "2",
        pages: totalPages,
        displayedPages: "3",
        hrefTextPrefix: "${path}/my-contacts?page=",
        currentPage: window.location.href.split('=')[1],
        edges: "0",
        
        
        onPageClick: function (page, evt) {
            console.log("PAGE", page);
            console.log("EVT", evt);
            $('#pagination').pagination('drawPage', page); 
        } 
    });
}); 