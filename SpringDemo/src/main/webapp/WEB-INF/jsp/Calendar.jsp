<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML> 

<HEAD> 
<title>行事曆</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</HEAD>
<BODY>

<select id="select1">
<option value="2017">2017</option>
<option value="2018">2018</option>
</select>

<c:forEach  begin="1" end="12" varStatus="status1">
                <c:if test="${status1.count%3 == 1}" ><div class="row"></c:if>
                        <div class="col-md-4">
                            <table id="month${status1.count}" class="table table-bordered">
                            <tr><td colspan="7">${status1.count}月</td></tr>
                            <tr>
                                <td class="active" style="background-color: #FF6666">日</td>
                                <td class="active">一</td>
                                <td class="active">二</td>
                                <td class="active">三</td>
                                <td class="active">四</td>
                                <td class="active">五</td>
                                <td class="active" style="background-color: #FF6666">六</td>
                            </tr>
                            </table>
                       </div>
                  <c:if test="${status1.count%3 == 0}" ></div></c:if>
       </c:forEach>
<!--        <form action="add" method="post"> -->
<!--      日期 <input type="text" id="date" name="date" placeholder="yyyy-MM-dd">  -->
<!--   工作日 <input type="text" name="working" placeholder="Y/N"> -->
<!--        星期<input type="text" name="weekday" placeholder="week"> -->
<!--        <input type="submit" value="submit"> -->
<!--        </form> -->
       
       <script>
        $("input").click(function(){
    	  $(this).css("background-color","green")
        })
        $("#select1").change(function(){
        for(var j=1;j<13;j++){
        	$("#month"+j).html('<tbody><tr><td colspan="7">'+j+'月</td></tr>'+
                    '<tr><td class="active" style="background-color: #FF6666">日</td>'+
            '<td class="active">一</td>'+
            '<td class="active">二</td>'+
            '<td class="active">三</td>'+
            '<td class="active">四</td>'+
            '<td class="active">五</td>'+
            '<td class="active" style="background-color: #FF6666">六</td></tr></tbody>')
        }	
          $.getJSON( "list",{year:$("#select1").val()}, function( data ) {
        	  var month=0;
        	  var content="";
			  $.each( data, function(k, v) {
// 				   console.log("key = "+k+" val = "+v.date)
				   if(v.date==01){
					   $("#month"+month).append(content)
					   month++
					   content="<tr>"
					   if(v.weekday==7){
						   
					   }else{
						   for(var i=1;i<v.weekday+1;i++){
							   content+="<td></td>"
						   }
					   }	   
				   }else if(v.weekday==7){
					   content+="<tr>"
				   }
				   if(v.working=="N"){
				   content+="<td class='active' style='background-color: #FF6666'>"+v.date+"</td>"
				   }else{
				   content+="<td class='active'>"+v.date+"</td>"   
				   }
				   if(v.weekday==6){
					   content+="</tr>"
					}
				   
				   
			  });
			  $("#month"+month).append(content)
		  });  
          
        })
         $.getJSON( "list",{year:$("#select1").val()}, function( data ) {
        	  var month=0;
        	  var content="";
			  $.each( data, function(k, v) {
// 				   console.log("key = "+k+" val = "+v.date)
				   if(v.date==01){
					   $("#month"+month).append(content)
					   month++
					   content="<tr>"
					   if(v.weekday==7){
						   
					   }else{
						   for(var i=1;i<v.weekday+1;i++){
							   content+="<td></td>"
						   }
					   }	   
				   }else if(v.weekday==7){
					   content+="<tr>"
				   }
				   if(v.working=="N"){
				   content+="<td class='active' style='background-color: #FF6666'>"+v.date+"</td>"
				   }else{
				   content+="<td class='active'>"+v.date+"</td>"   
				   }
				   if(v.weekday==6){
					   content+="</tr>"
					}
				   
				   
			  });
			  $("#month"+month).append(content)
		  });  
        
        </script> 
</BODY> 
</HTML>

