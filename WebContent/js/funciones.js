var selects=document.getElementsByTagName("select");
var len=selects.length;

for (var i=0; i< len; i++){
selects[i].setAttribute("class","ui-selectonemenu-trigger ui-state-default ui-corner-right");
selects[i].value=-1;
}

var inputs=document.querySelectorAll("input[type=text]");
len=inputs.length;
for(var i=0; i<len; i++){
	inputs[i].value="";
}