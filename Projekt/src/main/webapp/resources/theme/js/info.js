var pageIndex = window.location.href.split('=')[6];
var totalPages = '${size}';
var countContacts = '${countContacts}';
var searchURL = '${searchURL}';
var value = '${value}';

function detailAjax(id) {
    $.ajax({
        url: "info",
        type: "GET",
        data: {id: id},
        success: function (response) {
            $("#overlay").css("display", "block");
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
    $("#overlay").css("display", "block");
    $('#modalDialog').dialog({
        modal: true,
        zIndex: 10000,
        autoOpen: true,
        dialogClass: "modalDialog",
        resizable: false,
        buttons: [
            {
                text: "Yes",
                "class": 'dialogButtonYesNo',
                click: function () {
                    doFunctionForYes(id);
                    $("#overlay").css("display", "none");
                    $(this).dialog("close");
                }
            },
            {
                text: "No",
                "class": 'dialogButtonYesNo',
                click: function () {
                    $("#overlay").css("display", "none");
                    $(this).dialog("close");
                }
            }
        ]
    });
}

function doFunctionForYes(id) {
    $.ajax({
        url: "delete",
        type: "POST",
        data: {id: id},
        success: function (response) {
            if (String(totalPages) == String(pageIndex) && (countContacts % 5) == 1) {
                window.location = "${path}/my-contacts" + searchURL + "&page=" + (pageIndex - 1);
            } else {
                window.location.reload();
            }
        },
        error: function (data) {
            console.log("Chyba pri mazani");
        }
    });
}

function closeModal() {
    $("#result").css("display", "none");
    $("#overlay").css("display", "none");
}

$(document).ready(function () {
    $("#modalDialog").hide();

    $(function () {
        $('#pagination').pagination({
            pages: totalPages,
            hrefTextPrefix: "${path}/my-contacts" + searchURL + "&sort=" + "&page=",
            currentPage: window.location.href.split('=')[6],
            edges: "0",
            onPageClick: function (page, evt) {
                $('#pagination').pagination('drawPage', page);
            }
        });
    });
});

function sortByValue(value) {
    $.ajax({
        url: "sort",
        type: "GET",
        success: function (response) {
            console.log(value);
        },
        error: function (data) {
            console.log("Chyba pri sort");
        }
    });
}

function sortByLname() {
    console.log("sortByLname");
}

function sortByCategory() {
    console.log("sortByCategory");
}