/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var emojiButtonStatus = false;
var emojisIsCraeted = false;

function emoji() {
    var $emojiWrapper = $('#emojiWrapper');
    if (emojiButtonStatus) {
        $emojiWrapper.hide();
        console.log(" Try to hide emoji ~ ");
        emojiButtonStatus = false;
    } else if (!emojiButtonStatus){
        console.log(" Try to show emoji ~ ");
        if (!emojisIsCraeted) {
            createEmojis();
            emojisIsCraeted = true;
            addEmojiClick();
        }
       
        $emojiWrapper.show();
        emojiButtonStatus = true;
    }
}
function createEmojis() {
    console.log(" Try to create emoji ~ ");
    var $emojiWrapper = $('#emojiWrapper');
    var emojiSrcPrefix = "<img class='emoji' src='./image/2x/";
    var emojiSrcSuffix = ".png' ";
    var emojiTitlePrefix = " title=' ";
    var emojiTitleSuffix = " ' >";
    var emojis = "";
    for (var i = 1; i < 10; i++) {
        emojis = emojis + emojiSrcPrefix + "1f60" +i + emojiSrcSuffix + emojiTitlePrefix + i + emojiTitleSuffix;
    }
    for (var i = 10; i < 38; i++) {
        emojis = emojis + emojiSrcPrefix + "1f6" +i + emojiSrcSuffix + emojiTitlePrefix + i + emojiTitleSuffix;
    }
    var $emojis = $(emojis);
    $emojis.appendTo($emojiWrapper);
}
//为emoji 添加点击事件 ： 
//  获取 被点击的dom 元素，将其添加到msgInput元素的末尾。
//  关闭emojiWrapper 
function addEmojiClick (){
    var $emojiWrapper = $('#emojiWrapper');
    $emojiWrapper.mouseleave(function(){
        $emojiWrapper.hide();
        console.log(" Try to hide emoji ~ ");
        emojiButtonStatus = false;
    });
    $('.emoji').click(function (){
        console.log($(this).attr('title'));
        var $msgInput = $('#msgInput');
        var $emoji = $(this).clone();
        $msgInput.append($emoji); 
        emoji();
        console.log("Try to add emoji to msgInput");
    });
}


