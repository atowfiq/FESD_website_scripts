/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-07-13 16:46:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Element_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Element</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"//code.jquery.com/ui/1.11.4/jquery-ui.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.tmpl.js\" type=\"text/javascript\"></script>   \r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled and minified JavaScript -->\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\" integrity=\"sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var elementName,elementSymbol;\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t\r\n");
      out.write("\t $(\"#CompoundTable\").hide();\r\n");
      out.write("\t $(\"#NoResultText\").hide();\r\n");
      out.write("\tvar atomicNo  = ");
      out.print(request.getParameter("atomicNo"));
      out.write(";\r\n");
      out.write("\t\r\n");
      out.write("\t$.get('ElementServlet', {\r\n");
      out.write("\t\t AtomicNo : atomicNo\r\n");
      out.write("\t}, function(elementData) {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\telementName = elementData.ElementObj.Name;\r\n");
      out.write("\t\telementSymbol = elementData.ElementObj.Symbol;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.each($(\".additionalElm\"),function(key,elm){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$( elm).autocomplete({\r\n");
      out.write("\t\t\t      source: elementData.AllElements//elementPageData.SpaceGroupSymmetry\r\n");
      out.write("\t\t\t    });\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#elementName').text(elementName);\r\n");
      out.write("\t\t$('#elementAtomicNo').text(\"(\"+elementSymbol+\"-\"+elementData.ElementObj.AtomicNo+\")\");\r\n");
      out.write("\t\r\n");
      out.write("\t\t$.each(elementData.SpaceGroupCellSetting, function (key, value) {\r\n");
      out.write("\r\n");
      out.write("         $(\"#crystalSystem\").append($(\"<option></option>\").val\r\n");
      out.write("            (value).html(value));\r\n");
      out.write("        });\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tvar spaceGroupNumbers = [];\r\n");
      out.write("\tfor(var i=1;i<=230;i++)\r\n");
      out.write("\t{\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tspaceGroupNumbers.push(i.toString());\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$( \"#spaceGroupId\" ).autocomplete({\r\n");
      out.write("\t      source: spaceGroupNumbers//elementPageData.SpaceGroupSymmetry\r\n");
      out.write("\t    });\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t$('input[type=radio][name=filterType]').change(function() {\r\n");
      out.write("\t\t$(\"#spaceGroupId\").attr(\"disabled\",\"disabled\");\r\n");
      out.write("\t\t$(\"#spaceGroupId\").val('');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#crystalSystem\").attr(\"disabled\",\"disabled\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (this.value == 'showall') {\r\n");
      out.write("\t           \r\n");
      out.write("\t        }\r\n");
      out.write("\t        else if (this.value == 'spacegroup') {\r\n");
      out.write("\t        \t$(\"#spaceGroupId\").removeAttr(\"disabled\");\r\n");
      out.write("\t        }\r\n");
      out.write("\t        \r\n");
      out.write("\t        else if (this.value == 'crystalsystem') {\r\n");
      out.write("\t        \t$(\"#crystalSystem\").removeAttr(\"disabled\");\r\n");
      out.write("\t        }\r\n");
      out.write("\t    });\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function SearchCompound()\r\n");
      out.write("{\r\n");
      out.write("\tvar atomicNo = ");
      out.print(request.getParameter("atomicNo"));
      out.write(";\r\n");
      out.write("\tvar additionalElements='';\r\n");
      out.write("\t$.each($(\".additionalElm:visible\"),function(key,elm){\r\n");
      out.write("\t\r\n");
      out.write("\t\tadditionalElements =additionalElements +  elm.value+',';\r\n");
      out.write("\t});\r\n");
      out.write("\tadditionalElements = additionalElements.substring(0, additionalElements.length-1);\r\n");
      out.write("\tvar restrictNumberOfElements =$(\"#RestrictNumberOfElements\").val();\r\n");
      out.write("\tvar selectedOption = $(\"input[type='radio']:checked\").val();\r\n");
      out.write("\tvar isShowAll=false;\r\n");
      out.write("\tvar crystalSystemVal='',spaceGroupVal=''\r\n");
      out.write("\tif(selectedOption!=\"showall\")\r\n");
      out.write("\t{  \r\n");
      out.write("\t\tif(selectedOption ==\"spacegroup\")\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tspaceGroupVal= $(\"#spaceGroupId\").val();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse if(selectedOption ==\"crystalsystem\")\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tcrystalSystemVal=$(\"#crystalSystem\").val();\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t{\r\n");
      out.write("\t\tisShowAll =true;\r\n");
      out.write("\t}\r\n");
      out.write("//\tvar directTo = \"\\Compound.jsp?AtomicNo=\"+atomicNo+\"&AE=\"+additionalElements +\"&IsShowAll=\"+isShowAll+\"&SpaceGroup=\"+spaceGroupVal+\"&CrystalSystem=\"+crystalSystemVal+\"&ElementName=\"+elementName+\"&ElementSymbol=\"+elementSymbol;\r\n");
      out.write("//\tlocation.href = directTo;\r\n");
      out.write("\r\n");
      out.write("\tSearch(atomicNo,additionalElements,isShowAll,spaceGroupVal,crystalSystemVal,restrictNumberOfElements);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function Search(atomicNo,ae,isShowAll,spaceGroup,crystalSystem,restrictNumberOfElements)\r\n");
      out.write("{\r\n");
      out.write("\t$(\"#TotalCount\").show();\r\n");
      out.write("\t$(\"#TotalCount\").text(\"Searching...\");\r\n");
      out.write("\t $(\"#NoResultText\").hide();\r\n");
      out.write("\t $(\"#CompoundTable\").hide();\r\n");
      out.write("\t\r\n");
      out.write("\t$.get('CompoundServlet', {\r\n");
      out.write("\t\t AtomicNo :atomicNo,\r\n");
      out.write("\t\t AE: ae,\r\n");
      out.write("\t\t IsShowAll:isShowAll,\r\n");
      out.write("\t\t SpaceGroup :spaceGroup.length==0? 0:spaceGroup ,\r\n");
      out.write("\t\t CrystalSystem : crystalSystem, \r\n");
      out.write("\t\t RestrictNumberOfElements:restrictNumberOfElements\r\n");
      out.write("\t\t }, function(compoundList) {\r\n");
      out.write("\t\t\t $(\"#TotalCount\").hide();\r\n");
      out.write("\t\t\t if(compoundList.length==0)\r\n");
      out.write("\t\t\t {\r\n");
      out.write("\t\t\t\t $(\"#NoResultText\").show();\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t else{\r\n");
      out.write("\t\t\t\t $(\"#CompoundTable\").show();\r\n");
      out.write("\t\t\t\t $(\"#TotalCount\").show();\r\n");
      out.write("\t\t\t\t $(\"#TotalCount\").text(\"Results Found Total: \"+compoundList.length);\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t$(\"#CompoundContent\").html('');\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#CompoundListTemplate\").tmpl(compoundList).appendTo(\"#CompoundContent\");\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t});\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function AddElement()\r\n");
      out.write("{\r\n");
      out.write("\tvar elementTextBox = $(\".additionalElm:hidden\");\r\n");
      out.write("\t$(elementTextBox[0]).show();\r\n");
      out.write("\t$(\"#RemoveBtn\").removeAttr(\"disabled\");\t\t\r\n");
      out.write("\tif(elementTextBox.length==1)\r\n");
      out.write("\t{\r\n");
      out.write("\t\t$(\"#AddBtn\").attr(\"disabled\",\"disabled\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function RemoveElement()\r\n");
      out.write("{\r\n");
      out.write("\tvar elementTextBox = $(\".additionalElm:visible\");\r\n");
      out.write("\t$(elementTextBox[elementTextBox.length-1]).val(\"\");\r\n");
      out.write("\t$(elementTextBox[elementTextBox.length-1]).hide();\r\n");
      out.write("\t$(\"#AddBtn\").removeAttr(\"disabled\");\r\n");
      out.write("\tif(elementTextBox.length==1)\r\n");
      out.write("\t{\r\n");
      out.write("\t\t$(\"#RemoveBtn\").attr(\"disabled\",\"disabled\");\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function ViewCIF(codId)\r\n");
      out.write("{\r\n");
      out.write("\t\r\n");
      out.write("\t$.get('SingleCompoundServlet', {\r\n");
      out.write("\t\t CODId : codId \r\n");
      out.write("\t\t }, function(compound) {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar s = compound.Cif.replace(/(?:\\r\\n|\\r|\\n)/g, '<br />');\r\n");
      out.write("\t\t\t$('#CompoundFormula').text(compound.Formula);\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t$('#CifModal').modal();\t\r\n");
      out.write("\t\t\t$('#content').html(s);\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function ViewRSPT(codId)\r\n");
      out.write("{\r\n");
      out.write("\t\r\n");
      out.write("\t$.get('SingleCompoundServlet', {\r\n");
      out.write("\t\t CODId : codId \r\n");
      out.write("\t\t }, function(compound) {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar s = compound.Cif.replace(/(?:\\r\\n|\\r|\\n)/g, '<br />');\r\n");
      out.write("\t\t\t$('#CompoundFormula').text(compound.Formula);\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t$('#CifModal').modal();\t\r\n");
      out.write("\t\t\t$('#content').html(s);\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function DownloadCIF(codId)\r\n");
      out.write("{\r\n");
      out.write("\twindow.location = 'CIFServlet?CODId='+codId;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function GoToSingleCompound(codId)\r\n");
      out.write("{\r\n");
      out.write("\tlocation.href =  \"\\SingleCompound.jsp?CODId=\"+codId;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script id=\"CompoundListTemplate\"  type=\"text/x-jquery-tmpl\">\r\n");
      out.write("<tr>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<td><a style=\"cursor:pointer;\" onclick=\"GoToSingleCompound({{html CodID}})\"> {{html Formula }}</a></td>\r\n");
      out.write("\t<td>{{html SpaceGroup}}</td>\r\n");
      out.write("\t<td>{{html CrystalSystem}}</td>\r\n");
      out.write("\t  <td>{{html SpaceGroupName}}</td>\r\n");
      out.write("<td><a style=\"cursor: pointer;\" onclick=\"ViewCIF({{html CodID}});\">View</a> | <a style=\"cursor: pointer;\"  onclick=\"DownloadCIF({{html CodID}})\">Download</a>\r\n");
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\">\r\n");
      out.write("  \r\n");
      out.write("<!-- Latest compiled and minified CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<!-- Optional theme -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css\" integrity=\"sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function goBack() {\r\n");
      out.write("    window.history.back();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("td { \r\n");
      out.write("    padding: 8px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".additionalElm{\r\n");
      out.write("display: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".modal .modal-body {\r\n");
      out.write("    max-height: 420px;\r\n");
      out.write("    overflow-y: auto;\r\n");
      out.write("}\r\n");
      out.write("#CompoundTable td,th{\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "leftSidebar.jsp", out, false);
      out.write("\r\n");
      out.write("<div class=\"main\" >\r\n");
      out.write("<table style=\"width:100%;\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td colspan=7>\r\n");
      out.write("\t<h1><span  class=\"label label-default\"><span id='elementName'></span><span id='elementAtomicNo'  class=\"badge\"></span></span> </h1>\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.write("<button style=\"float:right;\" class=\"btn btn-secondary\" onclick=\"goBack()\">Go Back</button>\r\n");
      out.write("\t<div style=\"clear: both;\"></div>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\t\t\r\n");
      out.write("<tr>\r\n");
      out.write("<td>\r\n");
      out.write("\t<button id=\"AddBtn\" type=\"button\" class=\"btn btn-default btn-sm\" onclick=\"AddElement()\">\r\n");
      out.write("\t<span class=\"glyphicon glyphicon-plus\"></span> Add Element\r\n");
      out.write("\t</button>\r\n");
      out.write("</td>\r\n");
      out.write("<td><input type='text' style='width:100px;' class='form-control additionalElm'/></td>\r\n");
      out.write("<td><input type='text' style='width:100px;' class='form-control additionalElm'/></td>\r\n");
      out.write("<td><input type='text' style='width:100px;' class='form-control additionalElm'/></td>\r\n");
      out.write("<td><button onclick=\"RemoveElement()\" id=\"RemoveBtn\" disabled=\"disabled\"  type=\"button\" class=\"btn btn-default btn-sm\">\r\n");
      out.write("\t<span  class=\"glyphicon glyphicon-minus\"></span> Remove Element\r\n");
      out.write("\t</button></td>\r\n");
      out.write("<td><label  class=\"control-label \">Number of elements:</label> <select style=\"width: 150px; \" class=\"form-control\" id=\"RestrictNumberOfElements\">\r\n");
      out.write("\t\t\t<option value=\"All\">All</option>\r\n");
      out.write("\t\t\t<option value=\"Binary\">Binary</option>\r\n");
      out.write("\t\t\t<option value=\"Ternary\">Ternary</option>\r\n");
      out.write("\t\t</select></td>\r\n");
      out.write("<td></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td colspan=\"3\"><label class=\"radio-inline\"><input type=\"radio\" checked=\"checked\" name=\"filterType\" value=\"showall\">Show All</label>\r\n");
      out.write("<label class=\"radio-inline\"><input type=\"radio\" name=\"filterType\" value=\"spacegroup\">Space Group</label>\r\n");
      out.write("<label class=\"radio-inline\"><input type=\"radio\" name=\"filterType\" value=\"crystalsystem\">Crystal System</label></td>\r\n");
      out.write("\r\n");
      out.write("<td><label  class=\"control-label\">Space Group:</label><input disabled=\"disabled\" id=\"spaceGroupId\" style=\"width:150px;\" class=\"form-control\"></td>\r\n");
      out.write("\r\n");
      out.write("<td>\r\n");
      out.write("\t\t<label  class=\"control-label \">Crystal System:</label> <select disabled=\"disabled\" id=\"crystalSystem\" style=\"width: 150px; \" class=\"form-control\" >\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("<td colspan=2><button style=\"width: 100px; float:right;\" type=\"button\" class=\"btn btn-secondary\" onclick=\"SearchCompound()\">Search</button></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\t\r\n");
      out.write("<hr>\r\n");
      out.write("<div id=\"TotalCount\" style=\"display: none;\"> </div>\r\n");
      out.write("\r\n");
      out.write("<table id=\"CompoundTable\" class=\"table table-striped\">\r\n");
      out.write("\t    <thead>\r\n");
      out.write("\t      <tr>\r\n");
      out.write("\t        \r\n");
      out.write("\t        \r\n");
      out.write("\t \r\n");
      out.write("\t<th>Formula</th>\r\n");
      out.write("\t<th>Space Group</th>\r\n");
      out.write("\t<th>Crystal System</th>\r\n");
      out.write("\t  <th>Space Group Name</th>\r\n");
      out.write("\t  <th>CIF</th>\r\n");
      out.write(" <!-- <th>RSPT</th> -->\r\n");
      out.write("\t      </tr>\r\n");
      out.write("\t    </thead>\r\n");
      out.write("\t    <tbody id=\"CompoundContent\">\r\n");
      out.write("\t    \r\n");
      out.write("\t    </tbody>\r\n");
      out.write("\t    </table>\r\n");
      out.write("\t    \r\n");
      out.write("\t    \r\n");
      out.write("\t         <div style=\"display: none;\" id=\"NoResultText\" >\r\n");
      out.write("\t    No Result Matched\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div  id=\"CifModal\"  class=\"modal fade bs-example-modal-lg\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myLargeModalLabel\">\r\n");
      out.write("    <div class=\"modal-dialog modal-lg\">\r\n");
      out.write("     \r\n");
      out.write("      <!-- Modal content-->\r\n");
      out.write("      \r\n");
      out.write("       \r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("        <div class=\"modal-header\">\r\n");
      out.write("          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("          <h4 class=\"modal-title\" id=\"CompoundFormula\"></h4>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal-body\">\r\n");
      out.write("       \r\n");
      out.write("<div id=\"content\" ></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal-footer\">\r\n");
      out.write("          <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
