var selects=document.getElementsByTagName("select");
var len=selects.length;

for (var i=0; i< len; i++){
selects[i].setAttribute("class","ui-selectonemenu-trigger ui-state-default ui-corner-right");
}