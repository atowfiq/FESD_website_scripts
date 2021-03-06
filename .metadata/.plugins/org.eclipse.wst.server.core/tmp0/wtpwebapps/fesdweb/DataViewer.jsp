<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Element</title>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="js/jquery.tmpl.js" type="text/javascript"></script>   

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>


<script type="text/javascript">
var elementName,elementSymbol;

$(document).ready(function(){
	
	
	$.get('DataViewerServlet', {
	
	}, function(data) {
		
		$("#DataContentTemplate").tmpl(data).appendTo("#DataContent");

		
		/*elementName = elementData.ElementObj.Name;
		elementSymbol = elementData.ElementObj.Symbol;
		
		$.each($(".additionalElm"),function(key,elm){
			
			$( elm).autocomplete({
			      source: elementData.AllElements//elementPageData.SpaceGroupSymmetry
			    });
		});
		
		
		$('#elementName').text(elementName);
		$('#elementAtomicNo').text("("+elementSymbol+"-"+elementData.ElementObj.AtomicNo+")");
	
		$.each(elementData.SpaceGroupCellSetting, function (key, value) {

         $("#crystalSystem").append($("<option></option>").val
            (value).html(value));
        });*/
		
	});
	
	
	
});



function Search(atomicNo,ae,isShowAll,spaceGroup,crystalSystem,restrictNumberOfElements)
{
	$("#TotalCount").show();
	$("#TotalCount").text("Searching...");
	 $("#NoResultText").hide();
	 $("#CompoundTable").hide();
	
	$.get('CompoundServlet', {
		 AtomicNo :atomicNo,
		 AE: ae,
		 IsShowAll:isShowAll,
		 SpaceGroup :spaceGroup.length==0? 0:spaceGroup ,
		 CrystalSystem : crystalSystem, 
		 RestrictNumberOfElements:restrictNumberOfElements
		 }, function(compoundList) {
			 $("#TotalCount").hide();
			 if(compoundList.length==0)
			 {
				 $("#NoResultText").show();
				 
			 }
			 else{
				 $("#CompoundTable").show();
				 $("#TotalCount").show();
				 $("#TotalCount").text("Results Found Total: "+compoundList.length);
				 
			 }
			$("#CompoundContent").html('');			
				$("#CompoundListTemplate").tmpl(compoundList).appendTo("#CompoundContent");

	
	});	
}



function ViewCIF(codId)
{
	
	$.get('SingleCompoundServlet', {
		 CODId : codId 
		 }, function(compound) {
			
			var s = compound.Cif.replace(/(?:\r\n|\r|\n)/g, '<br />');
			$('#CompoundFormula').text(compound.Formula);	

			$('#CifModal').modal();	
			$('#content').html(s);

	});

}

function ViewRSPT(codId)
{
	
	$.get('SingleCompoundServlet', {
		 CODId : codId 
		 }, function(compound) {
			
			var s = compound.Cif.replace(/(?:\r\n|\r|\n)/g, '<br />');
			$('#CompoundFormula').text(compound.Formula);	

			$('#CifModal').modal();	
			$('#content').html(s);

	});

}

function DownloadCIF(codId)
{
	window.location = 'CIFServlet?CODId='+codId;
}

function GoToSingleCompound(codId)
{
	location.href =  "\SingleCompound.jsp?CODId="+codId;
}
</script>

<script id="DataContentTemplate"  type="text/x-jquery-tmpl">
<tr>

	
	<td><a style="cursor:pointer;" onclick="GoToSingleCompound( {{html FileName}} )">  {{html FileName}} </a></td>
	<td><a style="cursor:pointer;" onclick="GoToSingleCompound( {{html FileName}} )">  {{html FileCount}} </a></td>
	<td><a style="cursor:pointer;" onclick="GoToSingleCompound( {{html FileName}} )">  {{html Error}} </a></td>
	<td><a style="cursor:pointer;" onclick="GoToSingleCompound( {{html FileName}} )">  {{html OutLog}} </a></td>
	

</tr>
</script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<script>
function goBack() {
    window.history.back();
}
</script>
<style type="text/css">
td { 
    padding: 8px;
}

.additionalElm{
display: none;
}


.modal .modal-body {
    max-height: 420px;
    overflow-y: auto;
}
#CompoundTable td,th{
	text-align: center;
}
</style>
</head>
<body>
<jsp:include page="topBar.jsp"/>
<jsp:include page="leftSidebar.jsp"/>
<div class="main" >
<!--  <table style="width:100%;">
<tr>
<td colspan=7>
	<h1><span  class="label label-default"><span id='elementName'></span><span id='elementAtomicNo'  class="badge"></span></span> </h1>
</td>
<td>
<button style="float:right;" class="btn btn-secondary" onclick="goBack()">Go Back</button>
	<div style="clear: both;"></div>
</td>
</tr>		
<tr>
<td>
	<button id="AddBtn" type="button" class="btn btn-default btn-sm" onclick="AddElement()">
	<span class="glyphicon glyphicon-plus"></span> Add Element
	</button>
</td>
<td><input type='text' style='width:100px;' class='form-control additionalElm'/></td>
<td><input type='text' style='width:100px;' class='form-control additionalElm'/></td>
<td><input type='text' style='width:100px;' class='form-control additionalElm'/></td>
<td><button onclick="RemoveElement()" id="RemoveBtn" disabled="disabled"  type="button" class="btn btn-default btn-sm">
	<span  class="glyphicon glyphicon-minus"></span> Remove Element
	</button></td>
<td><label  class="control-label ">Number of elements:</label> <select style="width: 150px; " class="form-control" id="RestrictNumberOfElements">
			<option value="All">All</option>
			<option value="Binary">Binary</option>
			<option value="Ternary">Ternary</option>
		</select></td>
<td></td>
</tr>
<tr>
<td colspan="3"><label class="radio-inline"><input type="radio" checked="checked" name="filterType" value="showall">Show All</label>
<label class="radio-inline"><input type="radio" name="filterType" value="spacegroup">Space Group</label>
<label class="radio-inline"><input type="radio" name="filterType" value="crystalsystem">Crystal System</label></td>

<td><label  class="control-label">Space Group:</label><input disabled="disabled" id="spaceGroupId" style="width:150px;" class="form-control"></td>

<td>
		<label  class="control-label ">Crystal System:</label> <select disabled="disabled" id="crystalSystem" style="width: 150px; " class="form-control" >
			</select>
</td>

<td colspan=2><button style="width: 100px; float:right;" type="button" class="btn btn-secondary" onclick="SearchCompound()">Search</button></td>
</tr>
</table>
	
<hr>
<div id="TotalCount" style="display: none;"> </div>
-->
<table id="CompoundTable" class="table table-striped">
	    <thead>
	      <tr>
	        
	        
	 
	<th>Files</th>
	<th>Count</th>
	<th>Error</th>
	
	<th>OutLog</th>
	
 <!-- <th>RSPT</th> -->
	      </tr>
	    </thead>
	    <tbody id="DataContent">
	    
	    </tbody>
	    </table>
	    
	    
	         <div style="display: none;" id="NoResultText" >
	    No Result Matched
	    </div>
	
	<div  id="CifModal"  class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg">
     
      <!-- Modal content-->
      
       
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" id="CompoundFormula"></h4>
        </div>
        <div class="modal-body">
       
<div id="content" ></div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>

	
</div>
</body>
</html>