 /*js����������
1.ԭʼ��������
   number ������   ������С����NAN��not a number)
   string: �ַ���
   boolean: t��f
   null: һ������Ϊ�յ�ռλ��
   undefined: δ���壬��һ������û�и���ʼ��ֵ����Ĭ�ϸ�ֵΪundefined
2.������������:����*/


//��ӱ��

 var a_value=document.getElementById("a_value").innerHTML;//��a��ǩ���������ó�������Ȼ��ʱ��ɾ����ʱ����ȡ�������Ӹñ�ǩ�����ȡ���ֿ��Է�ֹ����
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
 //���
document.getElementById("btn_add").onclick=function(){
	var id=document.getElementById("id").value;
	var name=document.getElementById("name").value;
	var gender=document.getElementById("gender").value;
	
	var table=document.getElementsByTagName("table")[0];
table.innerHTML+=" <tr> "+ "<td><input type=\"checkbox\" name=\"cb\"></td>"+
   
      "<td>"+id+"</td>"+
      "<td>"+name+"</td>"+
      "<td>"+gender+"</td>"+
      "<td><a href=\"javascript:void(0)\" onclick=\"delTr(this);\">"+a_value+"</a></td>"+   "</tr>"; //����˫˫�������˫˫�Ļ�������������Ҫ��ת���ַ�\
      
    

}

  //ɾ��  removeChild() ͨ������ǩɾ���ӱ�ǩ   ���ԣ�parentNode��ȡ����ǩ
  function delTr(obj)
  {
	 var tr=obj.parentNode.parentNode;
	 var table=tr.parentNode;
	 table.removeChild(tr);
	  
	  
  }
  //ѡ��ť
  document.getElementById("selectAll").onclick=function()
  {
	  
	  var cbs=document.getElementsByName("cb");//�õ���ѡ��ļ���
	   for(var i=0;i<cbs.length;i++)
		   {
		   cbs[i].checked=true;
		   }
  }
  document.getElementById("unSelectAll").onclick=function()
  {
	  
	  var cbs=document.getElementsByName("cb");//�õ���ѡ��ļ���
	   for(var i=0;i<cbs.length;i++)
		   {
		   cbs[i].checked=false;
		   }
  }
  
  document.getElementById("selectRev").onclick=function()
  {
	  
	  var cbs=document.getElementsByName("cb");//�õ���ѡ��ļ���
	   for(var i=0;i<cbs.length;i++)
		   {
		   cbs[i].checked=!cbs[i].checked;
		   }
  }
  document.getElementById("firstcb").onclick=function()
  {
	  
	  var cbs=document.getElementsByName("cb");//�õ���ѡ��ļ���
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
















