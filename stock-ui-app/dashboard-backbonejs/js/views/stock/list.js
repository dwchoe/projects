// Filename: views/projects/list
define([
  'jquery',
  'underscore',
  'backbone',
  // Pull in the Collection module from above
  '../../models/trade',
], function($, _, Backbone, Stock){
  var StockListView = Backbone.View.extend({
    el: $(".page"),
    initialize: function(){
      console.log('StockListView');
      
      var stock = new Stock();
      var template = _.template($('#stock-list-template').html());
	  this.$el.html(template({stock:stock}));
    },
    render: function() {
    	console.log('StockListView render called');
    	var that = this;
    	
    	var stock = new Stock();
    	console.log('stock - name:' + stock.get("name") );
      	var template = _.template($('#stock-list-template').html());
	  	that.$el.html(template({stock:stock}));
    }
  });
  // Returning instantiated views can be quite useful for having "state"
  return StockListView;
});