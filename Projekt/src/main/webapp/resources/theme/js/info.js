//
//document.getElementById("modal").style.visibility = "hidden";
//$("#openDialog").button().on("click", function () {
//    document.getElementById("modal").style.visibility = "none";
//    dialog.dialog("open");
//});
//
//$(function () {
//    document.getElementById("modal").style.visibility = "none";
//    $("#modal").dialog();
//});
//
//data = "";
//load = function () {
//    
//    $.ajax({
//        url: 'list',
//        contentType: "application/json",
//        dataType:"json" , 
//        type: 'POST',
//        success: function (response) {
//            console.log("tu som");
//            data = response.data;
//            $('.tr').remove();
//            for (i = 0; i < response.data.length; i++) {
//                $("#table").append("<tr class='tr'> <td> " + response.data[i].user_name + "\
//                    </td> <td> " + response.data[i].email + " </td> <td> <a href='#' onclick= edit(" + i + ");> Edit </a>  </td> </td> <td> \n\
//                    <a href='#' onclick='delete_(" + response.data[i].user_id + ");'> Delete </a>  </td> </tr>");
//            }
//        },
//        error :function(response){
//            console.log("chyba");
//        }
//    });
//
//}


//  $( function() {
//    $( "#dialog" ).dialog({
//        
//      autoOpen: false,
//      show: {
//        //effect: "blind",
//        duration: 1000
//      },
//      hide: {
//        //effect: "explode",
//        duration: 1000
//      }
//    });
// 
//    $( "#opener" ).on( "click", function() {
//      $( "#dialog" ).dialog( "open" );
//    });
//  } );

function crunchifyAjax() {
    console.log("Tu som ");
        $.ajax({
            url : 'ajaxtest',
//            success : function(data) {
//                $('#result').html(data);
//            }
        });
    }
