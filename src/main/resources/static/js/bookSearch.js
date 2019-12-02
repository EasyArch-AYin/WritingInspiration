$("#bookSearch2").bind('click',function () {
    f()
});

function f() {
    var msg = $("#Search_box").val();

    // var json = {
    //     "Search_Content":msg
    // };
    // alert(json)
    $.ajax({
        type:"POST",
        url:"localhost:8888/get",
        data:{},
        cache:false,
        success:function () {
            alert("success!")
        },
        error:function () {
            alert("error!")
        }
    })
}
