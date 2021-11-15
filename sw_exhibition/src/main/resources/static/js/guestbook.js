/* 방명록 리스트 가져오기 */
function guestbookList() {
    $.ajax({
       type: "GET",
       url: "/guestbook/list",
       dataType: "json",
       success : function (response) {
           let str = "";
           for(let i=0; i<response.data.length; i++){
               str +=
                        "<div>" +
                            "<p>============================</p>" +
                            "<p>" + response.data[i].guest_writer + "</p>" +
                            "<p>" + response.data[i].guest_content + "</p>" +
                            "<p>" + response.data[i].guest_date + "</p>" +
                            "<p>============================</p>" +
                        "</div>";
           }
           $("#guestbookList").html(str);
       },
       error : function (err) {
           console.log(err);
       }
    });
}

/* 방명록 등록 */
function addGuestbook() {
    let writer = $("#writer").val();
    let content = $("#content").val();
    let json = {"guest_writer" : writer, "guest_content" : content};

    $.ajax({
        type: "POST",
        url: "/guestbook/add",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        success : function (response) {
            $("#writer").val("");
            $("#content").val("");
            guestbookList();
        },
        error : function (err) {
            console.log(err);
        }
    });
}