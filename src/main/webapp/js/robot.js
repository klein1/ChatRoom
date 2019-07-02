var arr=["你好","今天天气很棒啊","你吃饭了吗？","我最美我最美","我是可爱的僵小鱼","你忍心这样子对我吗？","spring天下无敌，实习工资850","我不管，我最帅，我是你们的小可爱","段友出征，寸草不生","一入段子深似海，从此节操是路人","馒头：嗷","突然想开个车：www.jq22.com","段子界混的最惨的两个狗：拉斯，普拉达。。。"];

function reply(text){
    /*  var aa=Math.floor((Math.random()*arr.length));
    if(Math.floor((Math.random()*3)))
        return arr[aa]
    else
        return text*/
    var apikey = "f019f00167b447b4a091c69f4a1bf027";

    $.ajax({
        type:"GET",
        url:'http://www.tuling123.com/openapi/api',
        data:{key:apikey, info:text},
        dataType:"json",
        success:function(result){
            // alert(result.text);
            answer = result['text'];
            if(answer.indexOf('一直在学习中，问我点别的吧') != -1)
                answer = arr[Math.floor((Math.random()*arr.length))];
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert("服务器错误");
        }
    });
}