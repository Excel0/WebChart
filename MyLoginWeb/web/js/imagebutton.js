/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var imageButtonStatus = false;
function image(){
    var $imagefile=$("#imagefile");
    if(!imageButtonStatus){
        $imagefile.show();
        imageButtonStatus=true;
        console.log("Try to show readfile!");
    }else if(imageButtonStatus){
        $imagefile.hide();
        imageButtonStatus=false;
        console.log("Try to hide readfile");
    }
}
//js 读取文件
    function jsReadFiles(files) {
        var $imagefile=$("#imagefile");
        if (files.length) {
            var file = files[0];
            var reader = new FileReader();//new一个FileReader实例
            if (/text+/.test(file.type)) {//判断文件类型，是不是text类型
                reader.onload = function() {
                    //$('body').append('<pre>' + this.result + '</pre>')
                    $imagefile.hide();;
                    document.getElementById("msgInput").innerHTML=this.result;
                    console.log("Try to add text");
                }
                reader.readAsText(file);
            } else if(/image+/.test(file.type)) {//判断文件是不是imgage类型
                reader.onload = function() {
                    //$('body').append('<img src="' + this.result + '"/>');
                    $imagefile.hide();
                    document.getElementById("msgInput").innerHTML='<img src="' + this.result + '"/>';
                    console.log("Try to add image");
                }
                reader.readAsDataURL(file);
            }
        }
    }