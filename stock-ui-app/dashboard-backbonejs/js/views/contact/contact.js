// Filename: views/projects/list
define([
  'jquery',
  'underscore',
  'backbone'
], function($, _, Backbone){
  var ContactPageView = Backbone.View.extend({
    el: $(".main"),
    render: function() {
    	console.log('contact page render called');
    	var that = this;
    	
    	$.get('templates/contact.html', function (data) {
    		console.log('data:' + data);
            template = _.template(data, {});//Option to pass any dynamic values to template
            console.log('data 2:' + template);
            that.$el.html(template);//adding the template content to the main template.
        }, 'html');
    }
  });
  // Returning instantiated views can be quite useful for having "state"
  return ContactPageView;
});