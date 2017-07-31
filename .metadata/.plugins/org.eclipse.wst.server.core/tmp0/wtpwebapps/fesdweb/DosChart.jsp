<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dos</title>
<script src="https://cdn.plot.ly/plotly-latest.min.js"></script>

 <script type="text/javascript">
 
 	function drawDosChart(dos)
	  {
		
	  
	  dosChart = document.getElementById('DosChart');
	  Plotly.purge(DosChart);
	
	  var data =[];
	 
	  var energy = dos.Energy.split(", ");
	 var dtotal = dos.TotalDos.split(", ");
	  data.push({x:energy,
		  y: dtotal,
		  type: 'scatter',                    // set the chart type
	      mode: 'lines',   
	      line: {                             // set the width of the line.
	         width: 1
	      },
	      name:"'Total Dos'",
	  
	  
	  });
	  
	
	  for(var i=0;i<dos.PartialValue.length;i++)
	  {
		  data.push({x:energy,
			  y: dos.PartialValue[i].PartialDosValue.split(', '),
			  type: 'scatter',                    // set the chart type
		      mode: 'lines',   
		      line: {                             // set the width of the line.
		         width: 1
		      },
		      name:dos.PartialValue[i].Element+'-f',
		  
		  
		  });
		  
		  
	  }
	
	 var layout = {
			  title: 'Dos ' ,
			};
	  Plotly.plot( dosChart ,data, layout );
	  }
	  

 
 var currentCompoundId;
     	function GetDos(compoundid)
      	{
     		$('#DosViewer').modal('show');
     		if(compoundid)
      		{
      			if(!currentCompoundId)
      				currentCompoundId = compoundid;
      			else if(currentCompoundId!=compoundid)
      			{
      				currentCompoundId = compoundid;
    			  	 
      			}
      			
      		}
      		$('#dataStatus').show();
      //		var eminBC= $("#EminBC").val(),emaxBC=$("#EmaxBC").val();
      		$.get('DosServlet', {
      	//		Emin: eminBC.length==0?-10:eminBC,
      		//	Emax: emaxBC.length==0?10:emaxBC,
      			//element:$("#CompoundElements option:selected").text(),
      		//	orbital:$("#Orbitals").val(),
      			id:currentCompoundId 
      			 }, function(dos) { 
      				 $('#dataStatus').hide();
      					
      			  	drawDosChart(dos);
      		     	  

      		});      		
      	}
     
  	
    </script>
</head>
<body>


<div  id="DosViewer"  class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" style="width:100%">
    <div class="modal-dialog modal-lg">
   
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" id="CompoundFormulaName"></h4>
          
        </div>
        <div class="modal-body">
    <div style="text-align: center;">
    <table id="DosstructureTable" >
   <tr>
	<td >
	<span id="dosdataStatus" style="display: none;"> Getting Data...</span>
	</td>
	</tr>
	</table>
	</div>
	
   <div id="DosChart" style="width: 900px; height: 500px"></div>
   
   

      </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  

</body>
</html>