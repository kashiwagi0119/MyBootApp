$(function() {
    $("#alertbtn").click(function() {
    	alertify.confirm("This is a confirm dialog.",
    			  function(){
    			    alertify.success('Ok');
    			  },
    			  function(){
    			    alertify.error('Cancel');
    			  });
    	
    });
});

