 /*js的数据类型
1.原始数据类型
   number ：数字   整数，小数，NAN（not a number)
   string: 字符串
   boolean: t和f
   null: 一个对象为空的占位符
   undefined: 未定义，若一个变量没有给初始化值，则默认赋值为undefined
2.引用数据类型:对象*/


//添加表格

 var a_value=document.getElementById("a_value").innerHTML;//将a标签的内容先拿出来，不然到时候删除的时候会获取不到，从该标签里面获取文字可以防止乱码
/*document.getElementById("btn_add").onclick=function(){
	var id=document.getElementById("id").value;
	var name=document.getElementById("name").value;
	var gender=document.getElementById("gender").value;
	
	var td_id=document.createElement("td");
	var text_id=document.createTextNode(id);
	td_id.appendChild(text_id);
	var td_name=document.createElement("td");
	var text_name=document.createTextNode(name);
	td_name.appendChild(text_name);
	var td_gender=document.createElement("td");
	var text_gender=document.createTextNode(gender);
	td_gender.appendChild(text_gender);
	
	var td_a=document.createElement("td");
	var ele_a =document.createElement("a");
	ele_a.setAttribute("href","javascript:void(0);");
	ele_a.setAttribute("onclick","delTr(this);");
	
	var a_text=document.createTextNode(a_value);//
	ele_a.appendChild(a_text);
	td_a.appendChild(ele_a);
	
	var tr=document.createElement("tr");
	tr.appendChild(td_id);
	tr.appendChild(td_name);
	tr.appendChild(td_gender);
	tr.appendChild(td_a);
	
	var table=document.getElementsByTagName("table")[0];
	table.appendChild(tr);
}*/
 //添加
document.getElementById("btn_add").onclick=function(){
	var id=document.getElementById("id").value;
	var name=document.getElementById("name").value;
	var gender=document.getElementById("gender").value;
	
	var table=document.getElementsByTagName("table")[0];
table.innerHTML+=" <tr> "+ "<td><input type=\"checkbox\" name=\"cb\"></td>"+
   
      "<td>"+id+"</td>"+
      "<td>"+name+"</td>"+
      "<td>"+gender+"</td>"+
      "<td><a href=\"javascript:void(0)\" onclick=\"delTr(this);\">"+a_value+"</a></td>"+   "</tr>"; //不能双双引，如果双双的化里面或外面的需要用转义字符\
      
    

}

  //删除  removeChild() 通过父标签删除子标签   属性：parentNode获取父标签
  function delTr(obj)
  {
	 var tr=obj.parentNode.parentNode;
	 var table=tr.parentNode;
	 table.removeChild(tr);
	  
	  
  }
  //选择按钮
  document.getElementById("selectAll").onclick=function()
  {
	  
	  var cbs=document.getElementsByName("cb");//得到复选框的集合
	   for(var i=0;i<cbs.length;i++)
		   {
		   cbs[i].checked=true;
		   }
  }
  document.getElementById("unSelectAll").onclick=function()
  {
	  
	  var cbs=document.getElementsByName("cb");//得到复选框的集合
	   for(var i=0;i<cbs.length;i++)
		   {
		   cbs[i].checked=false;
		   }
  }
  
  document.getElementById("selectRev").onclick=function()
  {
	  
	  var cbs=document.getElementsByName("cb");//得到复选框的集合
	   for(var i=0;i<cbs.length;i++)
		   {
		   cbs[i].checked=!cbs[i].checked;
		   }
  }
  document.getElementById("firstcb").onclick=function()
  {
	  
	  var cbs=document.getElementsByName("cb");//得到复选框的集合
	   for(var i=1;i<cbs.length;i++)
		   {
		   cbs[i].checked=this.checked;
		   }
  }
  
  var trs=document.getElementsByTagName("tr");
  for(var i=0;i<trs.length;i++)
	  {
	   trs[i].onmouseover=function()
	   {this.className="over";
	   }
	   
	   trs[i].onmouseout=function()
	   {this.className="out";}
	  
	  }
















