var DATA = {
    EmotionList: [],
    ContentList : [],
    OtherContent : []
};

// 得到上个页面传来的emotion
var url = location.search;
var URL = decodeURI(url);
var emotion = URL.substring(URL.lastIndexOf('=')+1, URL.length);

window.onload=function LoadData() {
    $.ajax({
        type:"POST",
        url:"/data",
        async:true,
        data:{"emotion":emotion},
        datatype:"json",
        success:function (response) {
            if (response){
                var result = eval(response);
                console.log(result.content.toString());
                console.log(result.emotions.toString());

            }
        },
        error:function () {
            alert("错了");
        }
    })
};
