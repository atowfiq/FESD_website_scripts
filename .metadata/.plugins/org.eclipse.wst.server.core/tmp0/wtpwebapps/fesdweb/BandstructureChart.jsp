<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bandstructure</title>
<script src="https://cdn.plot.ly/plotly-latest.min.js"></script>

<style type="text/css">


.modal .modal-body {
    max-height: 800px;
    overflow-y: auto;
}
.modal {
  text-align: center;
}

@media screen and (min-width: 768px) {
  .modal:before {
    content: " ";
    display: inline-block;
    height: 100%;
    vertical-align: middle;
  }
}

.modal-dialog {
  display: inline-block;
  text-align: center;
  vertical-align: middle;
}
#BandstructureTable td
{
	padding-top: 5px ;
	padding-left:10px; ;
}
</style>

    <script type="text/javascript">
    var currentCompoundId;
    $(document).ready(function(){
    	
    	$("#CompoundElements").change(function() {
    	
    		SetOrbitalValue($(this).val());

    	});
    	
    	
    	
    });
    
    function SetOrbitalValue(orbitalValue)
    {
    	var orbitals = orbitalValue.replace(/^[\s,]+|[\s,]+$/g, '').split(',');
		
    	
		 $("#Orbitals").html(''); 
	        $("#Orbitals").append($("<option></option>").val("None").html("None"));
		  	 
		 $.each(orbitals, function (key, value) {
	  	         $("#Orbitals").append($("<option></option>").val(value).html(value));
	  	       });
    	
    }
      function drawChart(bands,orbitalWeight) {  
    	//  $("#Bands").append($("<option></option>").val('All').html('All'));
     	
     	  
     	       drawBandChart(bands,orbitalWeight);
     	  
          }
      
      	  function drawBandChart(bands,orbitalWeight)
      	  {
      		
       	  
      	  BandChart = document.getElementById('BandChart');
      	  Plotly.purge(BandChart);
  		
      	  var data =[];
      	  var dx=[];
      	  var w=[];
    	  for(var i=0;i<bands[0].Energy.split(", ").length;i++)
    	  {       	  dx.push(i);
    	  			  w.push(0);
    	  }
    	  for(var l=0;l<bands.length;l++)
      		{
      		  
      		  var yval= bands[l].Energy.split(", ");
      		  var orbitalWeightVal=[];
      		  if(orbitalWeight.length>0)
      		  	orbitalWeightVal =orbitalWeight[l].split(", ");
      		  data.push({x:dx,
     			  y:yval,
     			  type: 'scatter',                    // set the chart type
    		      mode: 'lines',   
    		      line: {                             // set the width of the line.
    		         width: 1
    		      },
    		      name:'Band '+ bands[l].Index,
    		      
    		      error_y: {
    		        array: orbitalWeightVal.length==0?w:orbitalWeightVal.map(function(x){return x/2;}),
    		        thickness: 0.5,                   // set the thickness of the error bars
    		        width: 0
    		      }
     		  
     		  
     		  });
     	  
      		}
      	  
      	
      	 var layout = {
       			  title: 'Bandstructure ' ,
       			 
       			
       			  
       			};
      	  Plotly.plot( BandChart,data, layout );
      	  }
      	  
      
      	
      	  
      	  
      	function GetBandstructures(compoundid)
      	{
      		if(compoundid)
      		{
      			if(!currentCompoundId)
      				currentCompoundId = compoundid;
      			else if(currentCompoundId!=compoundid)
      			{
      				currentCompoundId = compoundid;
          			
      				$("#CompoundElements").html('');
      				$("#CompoundElements").append($("<option></option>").val("None").html("None"));
  			  	    	
      				$("#Orbitals").html(''); 
      		        $("#Orbitals").append($("<option></option>").val("None").html("None"));
      			  	 
      			}
      			
      		}
      		$('#dataStatus').show();
      		var eminBC= $("#EminBC").val(),emaxBC=$("#EmaxBC").val();
      		var compoundElementsText = $("#CompoundElements option:selected").text();
      		var elemIndex;
      		var elem="None";
      		if(compoundElementsText!="None")
      		{   var splitted= compoundElementsText.split(' ');
      			elem = splitted[0]
      			elemIndex =splitted[1]; 
      		}
      		$.get('BandStructureServlet', {
      			Emin: eminBC.length==0?-10:eminBC,
      			Emax: emaxBC.length==0?10:emaxBC,
      			element:elem,
      			orbital:$("#Orbitals").val(),
      			elementIndex:elemIndex?elemIndex:0,
      			id:currentCompoundId 
      			 }, function(data) { 
      				// $("#CompoundElements").html(''); 
      			//	    $("#CompoundElements").append($("<option></option>").val("None").html("None"));
      			  	    $('#dataStatus').hide();
      					if(data.CompoundElementOrbitals.length>0)
      			  	    {
      			  	    	$("#CompoundElements").html('');
      			  	    	
      			  	    	
      			  	    	SetOrbitalValue(data.CompoundElementOrbitals[0].Orbital);
      			  	    	$.each(data.CompoundElementOrbitals, function (key, value) {
      			  	     	   $("#CompoundElements").append($("<option></option>").val(value.Orbital).html(value.Element+' '+value.ElementIndex));
      			  	       });
      			  	    	
      			  	    }
      		     	  drawChart(data.Bands,data.OrbitalWeight);
      		     	  

      		});      		
      	}
     
  	
    </script>

</head>
<body>
<div  id="BandViewer"  class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" style="width:100%">
    <div class="modal-dialog modal-lg">
   
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" id="CompoundFormulaName"></h4>
          
        </div>
        <div class="modal-body">
    <div style="text-align: center;">
    <table id="BandstructureTable" >
    <tr>
	    <td>
	    	<label>Emin:</label>
	    </td>
	    <td>
	    	<label>Emax:</label>
	    </td>
	    <td>
	     <label  class="control-label ">Element </label>
    	</td>
    	<td>
    	 
		<label  class="control-label ">Orbital</label>
    	</td>
    	<td>
    	</td> 
    </tr>
    <tr>
    <td>
   		<input id="EminBC" style="width:100px;"  class="form-control"  value="-10">
	</td>

	<td>
	<input id="EmaxBC" style="width:100px;"  class="form-control"  value="10">
	</td>
	<td>
	 <select style="width: 100px; " class="form-control"   id="CompoundElements">
					<option value="None">None</option>		
		</select>
	</td>
	<td>
	 <select style="width: 150px; " class="form-control"   id="Orbitals">
			<option value="None">None</option>
		</select>
	</td>
	<td>
	<button style="width:100px;" class="btn btn-secondary" onclick="GetBandstructures()">Get </button>
		
	</td>
	<td >
	<span id="dataStatus" style="display: none;"> Getting Data...</span>
	</td>
	</tr>
	</table>
	</div>
	
   <div id="BandChart" style="width: 900px; height: 500px"></div>
   
   

<div id="ViewerContent"  style="display: none;"> <img src="" id="imagepreview" style="padding: 5px; width: 800px; height: 600px;" ></div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  

</body>
</html>