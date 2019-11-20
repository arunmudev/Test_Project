/**
 * 
 */
$(document).ready(function(){
	$("#save-btn").click(function(){
	    var url="ServletDbController";	
		var title = $("#title-input").val();
	     var author = $("#author-input").val();
	     var price = $("#price-input").val();
	     
	     $.post(url,{
	    	bookTitle : title,
	    	bookAuthor : author,
	    	bookPrice : price,
	    	
	     },alert("save button is clicked"));
	});
	
	$("#view-btn").click(function(){
		var url="view";
		$.post(url);
	});
	
	$("#back-btn").click(function(){
		alert("Back button is clicked");
	});
	
	
});